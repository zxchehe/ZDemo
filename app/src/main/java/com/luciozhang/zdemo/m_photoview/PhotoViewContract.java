package com.luciozhang.zdemo.m_photoview;

import com.luciozhang.zdemo.base.BasePresenter;
import com.luciozhang.zdemo.base.BaseView;

/**
 * Created by luciozhang on 2017/8/4.
 */

public class PhotoViewContract {
    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends BasePresenter {
    }
}
