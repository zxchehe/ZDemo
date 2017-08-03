package com.luciozhang.zdemo.m_bottomsheets;

import android.support.annotation.Nullable;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by luciozhang on 2017/7/28.
 */

public class BottomSheetsPresenter implements BottomSheetsContract.Presenter{

    private final BottomSheetsContract.View mBottomSheetsView;

    public BottomSheetsPresenter(@Nullable BottomSheetsContract.View bottomSheetsView){
        mBottomSheetsView=checkNotNull(bottomSheetsView,"bottomSheetsView cannot be null!");

        mBottomSheetsView.setPresenter(this);
    }

    @Override
    public void start(){

    }

}
