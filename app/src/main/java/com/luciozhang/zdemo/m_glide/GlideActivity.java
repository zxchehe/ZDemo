package com.luciozhang.zdemo.m_glide;

import android.os.Bundle;
import com.luciozhang.zdemo.BaseActivity;
import com.luciozhang.zdemo.R;
import com.luciozhang.zdemo.utils.ActivityUtils;

public class GlideActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GlideFragment glideFragment = (GlideFragment) getSupportFragmentManager()
                .findFragmentById(R.id.zdemo_activity_base_fl_content);

        if (glideFragment == null) {
            glideFragment = GlideFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    glideFragment, R.id.zdemo_activity_base_fl_content);
        }

        // Create the presenter
        new GlidePresenter(glideFragment);

        setUpView();
    }

    @Override
    protected void setUpView() {
        super.setUpView();
        setToolbarTitle("Glide");
        setApi("http://bumptech.github.io/glide/ref/javadocs.html");
        setArticle("http://bumptech.github.io/glide/");
    }
}
