package com.luciozhang.zdemo.m_photoview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luciozhang.zdemo.R;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

import static com.google.common.base.Preconditions.checkNotNull;

public class PhotoViewFragment extends Fragment implements PhotoViewContract.View{

    private PhotoViewContract.Presenter mPresenter;

    public static PhotoViewFragment newInstance() {
        PhotoViewFragment fragment = new PhotoViewFragment();
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
        View root = inflater.inflate(R.layout.fragment_photo_view, container, false);

        PhotoView mPhotoView;
        PhotoViewAttacher mAttacher;

        mPhotoView=(PhotoView)root.findViewById(R.id.photoView);

        mAttacher = new PhotoViewAttacher(mPhotoView);
        mPhotoView.setImageResource(R.drawable.android_authority);
        mAttacher.update();

        return root;
    }

    @Override
    public void setPresenter(@NonNull PhotoViewContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
}
