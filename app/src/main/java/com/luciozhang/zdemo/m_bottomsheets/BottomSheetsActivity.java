package com.luciozhang.zdemo.m_bottomsheets;

import android.os.Bundle;

import com.luciozhang.zdemo.BaseActivity;
import com.luciozhang.zdemo.R;
import com.luciozhang.zdemo.utils.ActivityUtils;

public class BottomSheetsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BottomSheetsFragment bottomSheetsFragment = (BottomSheetsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.zdemo_activity_base_fl_content);

        if (bottomSheetsFragment == null) {
            bottomSheetsFragment = BottomSheetsFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    bottomSheetsFragment, R.id.zdemo_activity_base_fl_content);
        }

        // Create the presenter
        new BottomSheetsPresenter(bottomSheetsFragment);

        setUpView();

    }

    @Override
    protected void setUpView() {
        super.setUpView();
        setToolbarTitle("BottomSheets");
        setApi("https://developer.android.com/reference/android/support/design/widget/BottomSheetBehavior.html");
        setArticle("http://www.androidauthority.com/bottom-sheets-707252/");
    }
}
