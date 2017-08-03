package com.luciozhang.zdemo.m_main;

import com.luciozhang.zdemo.base.BasePresenter;
import com.luciozhang.zdemo.base.BaseView;

import java.util.List;

/**
 * Created by luciozhang on 2017/7/28.
 */

public class MainContract {

    interface View extends BaseView<MainContract.Presenter> {
        abstract void goToBottomSheets();
        abstract void goToGlide();
        abstract void showList(List<String> moduleNames);
    }

    interface Presenter extends BasePresenter {
        abstract void loadList();
    }
}
