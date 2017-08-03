package com.luciozhang.zdemo.m_glide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.luciozhang.zdemo.R;
import com.luciozhang.zdemo.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

public class GlideFragment extends Fragment implements GlideContract.View{

    private GlideContract.Presenter mPresenter;

    @BindView(R.id.zdemo_fragment_glide_iv_load_image)
    ImageView ivLoadImage;
    @BindView(R.id.zdemo_fragment_glide_iv_load_errer_image)
    ImageView ivLoadErrerImage;
    @BindView(R.id.zdemo_fragment_glide_iv_load_gif)
    ImageView ivLoadGIF;
    @BindView(R.id.zdemo_fragment_glide_iv_load_transform_image)
    ImageView ivLoadTransformImage;

    public static GlideFragment newInstance() {
        GlideFragment fragment = new GlideFragment();
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
        View root = inflater.inflate(R.layout.fragment_glide, container, false);

        ButterKnife.bind(this,root);

        return root;
    }

    @Override
    public void setPresenter(@NonNull GlideContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @OnClick(R.id.zdemo_fragment_glide_btn_load_image)
    public void onClickLoadImage(){
        mPresenter.loadImage("http://i.imgur.com/fG8JU4B.jpg");
    }

    @OnClick(R.id.zdemo_fragment_glide_btn_load_errer_image)
    public void onClickLoadErrerImage(){
        mPresenter.loadErrerImage("http://nothing");
    }

    @OnClick(R.id.zdemo_fragment_glide_btn_load_noerrer_image)
    public void onClickLoadNoErrerImage(){
        mPresenter.loadErrerImage("http://i.imgur.com/z8QrVZr.png");
    }

    @OnClick(R.id.zdemo_fragment_glide_btn_load_gif)
    public void onClickLoadGif(){
        mPresenter.loadGIF("http://i.imgur.com/l752ujR.gif");
    }

    @OnClick(R.id.zdemo_fragment_glide_btn_load_transform_image)
    public void onClickLoadTransformImage(){
        mPresenter.loadTransformImage("http://i.imgur.com/fG8JU4B.jpg");
    }

    @Override
    public void showImage(String url) {
        ToastUtils.showLongToast(getContext(),"loadImage");
        Glide.with(this).load(url).into(ivLoadImage);
    }

    @Override
    public void showErrerImage(String url) {
        ToastUtils.showLongToast(getContext(),"loadCrossFadeImage");

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error);

        Glide.with(this).load(url).apply(options).transition(new DrawableTransitionOptions().crossFade(2000)).into(ivLoadErrerImage);
    }

    @Override
    public void showGIF(String url) {
        ToastUtils.showLongToast(getContext(),"loadGIF");
        Glide.with(this).load(url).into(ivLoadGIF);
    }

    @Override
    public void showTransformImage(String url) {
        ToastUtils.showLongToast(getContext(),"loadTransformImage");

        RequestOptions options = new RequestOptions();
        options.circleCrop();
        Glide.with(this).load(url).apply(options).into(ivLoadTransformImage);
    }
}
