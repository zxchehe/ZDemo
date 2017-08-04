package com.luciozhang.zdemo.m_photoview;

import android.support.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by luciozhang on 2017/8/4.
 */

public class PhotoViewPresenter implements PhotoViewContract.Presenter {

    private final PhotoViewContract.View mPhotoViewView;

    public PhotoViewPresenter(@Nullable PhotoViewContract.View photoViewView){
        mPhotoViewView=checkNotNull(photoViewView,"photoViewView cannot be null!");
        mPhotoViewView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
