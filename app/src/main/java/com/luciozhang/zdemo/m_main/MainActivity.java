package com.luciozhang.zdemo.m_main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.luciozhang.zdemo.R;
import com.luciozhang.zdemo.utils.ActivityUtils;
import com.luciozhang.zdemo.utils.ToastUtils;

public class MainActivity extends AppCompatActivity {

    MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = (MainFragment) getSupportFragmentManager()
                .findFragmentById(R.id.content_main_frame);

        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    mainFragment, R.id.content_main_frame);
        }

        // Create the presenter
        new MainPresenter(mainFragment);

    }

    @Override
    public void onBackPressed() {
        if(!mainFragment.onCloseDrawer()) {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            ToastUtils.showLongToast(this,"action_settings");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
