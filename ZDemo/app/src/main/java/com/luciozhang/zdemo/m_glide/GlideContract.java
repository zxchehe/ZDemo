package com.luciozhang.zdemo.m_glide;

import com.luciozhang.zdemo.base.BasePresenter;
import com.luciozhang.zdemo.base.BaseView;

/**
 * Created by luciozhang on 2017/8/3.
 */

public class GlideContract{
    interface View extends BaseView<GlideContract.Presenter> {
        abstract void showImage(String url);
        abstract void showErrerImage(String url);
        abstract void showGIF(String url);
        abstract void showTransformImage(String url);
    }

    interface Presenter extends BasePresenter {
        abstract void loadImage(String url);
        abstract void loadErrerImage(String url);
        abstract void loadGIF(String url);
        abstract void loadTransformImage(String url);
    }
}
