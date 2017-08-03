package com.luciozhang.zdemo.m_main;

import android.support.annotation.Nullable;

import com.luciozhang.zdemo.data.DemoHelper;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by luciozhang on 2017/7/28.
 */

public class MainPresenter implements MainContract.Presenter {
    private final MainContract.View mMainView;

    public MainPresenter(@Nullable MainContract.View mainView){
        mMainView=checkNotNull(mainView,"bottomSheetsView cannot be null!");
        mMainView.setPresenter(this);
    }

    @Override
    public void start(){
        loadList();
    }

    @Override
    public void loadList() {
        mMainView.showList(DemoHelper.getInstance().getDemos());
    }
}
