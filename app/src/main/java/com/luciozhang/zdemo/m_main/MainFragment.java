package com.luciozhang.zdemo.m_main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.luciozhang.zdemo.R;
import com.luciozhang.zdemo.data.DemoHelper;
import com.luciozhang.zdemo.m_bottomsheets.BottomSheetsActivity;
import com.luciozhang.zdemo.m_glide.GlideActivity;
import com.luciozhang.zdemo.m_main.adapter.NormalRecyclerViewAdapter;
import com.luciozhang.zdemo.m_photoview.PhotoViewActivity;
import com.luciozhang.zdemo.m_ucrop.UCropActivity;
import com.luciozhang.zdemo.utils.ItemClickSupport;
import com.luciozhang.zdemo.utils.ToastUtils;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by luciozhang on 2017/7/28.
 */

public class MainFragment extends Fragment implements MainContract.View ,NavigationView.OnNavigationItemSelectedListener{

    private MainContract.Presenter mPresenter;

    RecyclerView rvContent;
    DrawerLayout drawer;

    NormalRecyclerViewAdapter normalRecyclerViewAdapter;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        rvContent = (RecyclerView)root.findViewById(R.id.zdemo_main_rv_content);
        rvContent.setLayoutManager(new LinearLayoutManager(getContext()));//这里用线性显示 类似于listview

        //左边抽屉和工具栏
        drawer = (DrawerLayout) root.findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) root.findViewById(R.id.toolbar);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //右下角按钮
        FloatingActionButton fab = (FloatingActionButton) root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        NavigationView navigationView = (NavigationView) root.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        return root;
    }

    @Override
    public void setPresenter(@NonNull MainContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            ToastUtils.showShortToast(getActivity(),"nav_camera");
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //判断是否需要关闭，不需要是在Activity中会另做处理
    public boolean onCloseDrawer(){
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void goToBottomSheets() {
        Intent intent = new Intent(getContext(), BottomSheetsActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToGlide() {
        Intent intent = new Intent(getContext(), GlideActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToPhotoView() {
        Intent intent = new Intent(getContext(), PhotoViewActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToUCrop() {
        Intent intent = new Intent(getContext(), UCropActivity.class);
        startActivity(intent);
    }


    @Override
    public void showList(List<String> moduleNames) {
        normalRecyclerViewAdapter=new NormalRecyclerViewAdapter(getContext(),moduleNames);
        rvContent.setAdapter(normalRecyclerViewAdapter);
        normalRecyclerViewAdapter.notifyDataSetChanged();
        ItemClickSupport.addTo(rvContent).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                switch (DemoHelper.getInstance().getDemos().get(position)){
                    case "BottomSheets":
                        goToBottomSheets();
                        break;
                    case "Glide":
                        goToGlide();
                        break;
                    case "PhotoView":
                        goToPhotoView();
                        break;
                    case "uCrop":
                        goToUCrop();
                        break;
                    default:
                        break;
                }
            }
        });
    }
}

