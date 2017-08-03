package com.luciozhang.zdemo.m_glide;

import android.support.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by luciozhang on 2017/8/3.
 */

public class GlidePresenter implements GlideContract.Presenter {

    private final GlideContract.View mGlideView;

    public GlidePresenter(@Nullable GlideContract.View glideView) {
        mGlideView = checkNotNull(glideView, "glideView cannot be null!");

        mGlideView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void loadImage(String url) {
        mGlideView.showImage(url);
    }

    @Override
    public void loadErrerImage(String url) {
        mGlideView.showErrerImage(url);
    }

    @Override
    public void loadGIF(String url) {
        mGlideView.showGIF(url);
    }

    @Override
    public void loadTransformImage(String url) {
        mGlideView.showTransformImage(url);
    }
}
