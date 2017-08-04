package com.luciozhang.zdemo.m_photoview;

import android.os.Bundle;

import com.luciozhang.zdemo.BaseActivity;
import com.luciozhang.zdemo.R;
import com.luciozhang.zdemo.utils.ActivityUtils;

public class PhotoViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PhotoViewFragment photoViewFragment = (PhotoViewFragment) getSupportFragmentManager()
                .findFragmentById(R.id.zdemo_activity_base_fl_content);

        if (photoViewFragment == null) {
            photoViewFragment = PhotoViewFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    photoViewFragment, R.id.zdemo_activity_base_fl_content);
        }

        // Create the presenter
        new PhotoViewPresenter(photoViewFragment);

        setUpView();
    }

    @Override
    protected void setUpView() {
        super.setUpView();
        setToolbarTitle("PhotoView");
        setApi("https://github.com/chrisbanes/PhotoView");
        setArticle("https://github.com/chrisbanes/PhotoView");
    }
}
