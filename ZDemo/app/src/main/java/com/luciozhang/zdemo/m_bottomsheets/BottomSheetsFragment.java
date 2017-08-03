package com.luciozhang.zdemo.m_bottomsheets;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static com.google.common.base.Preconditions.checkNotNull;
import com.luciozhang.zdemo.R;

/**
 * Created by luciozhang on 2017/7/28.
 */

public class BottomSheetsFragment extends Fragment implements BottomSheetsContract.View {

    private BottomSheetsContract.Presenter mPresenter;
    private Button mButton1, mButton2, mButton3;
    private BottomSheetBehavior mBottomSheetBehavior1, mBottomSheetBehavior2;

    public static BottomSheetsFragment newInstance() {
        BottomSheetsFragment fragment = new BottomSheetsFragment();
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
        View root = inflater.inflate(R.layout.fragment_bottom_sheets, container, false);

        final View bottomSheet = root.findViewById(R.id.bottom_sheet1);
        mBottomSheetBehavior1 = BottomSheetBehavior.from(bottomSheet);
        mBottomSheetBehavior1.setPeekHeight(300);
        mButton1 = (Button) root.findViewById(R.id.button_1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mBottomSheetBehavior1.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_EXPANDED);
                    mButton1.setText(R.string.collapse_button1);
                }
                else {
                    mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    mButton1.setText(R.string.button1);
                }
            }
        });

        final View bottomSheet2 = root.findViewById(R.id.bottom_sheet2);
        mBottomSheetBehavior2 = BottomSheetBehavior.from(bottomSheet2);
        mBottomSheetBehavior2.setHideable(true);
        mBottomSheetBehavior2.setPeekHeight(300);
        mBottomSheetBehavior2.setState(BottomSheetBehavior.STATE_HIDDEN);

        mButton2 = (Button) root.findViewById(R.id.button_2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mBottomSheetBehavior2.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    mBottomSheetBehavior2.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    mButton2.setText(R.string.button2_hide);
                }
                else if(mBottomSheetBehavior2.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    mBottomSheetBehavior2.setState(BottomSheetBehavior.STATE_HIDDEN);
                    mButton2.setText(R.string.button2);
                }
                else if(mBottomSheetBehavior2.getState() == BottomSheetBehavior.STATE_HIDDEN) {
                    mBottomSheetBehavior2.setState(BottomSheetBehavior.STATE_EXPANDED);
                    mButton2.setText(R.string.button2_peek);
                }
            }
        });

        mBottomSheetBehavior2.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    mButton2.setText(R.string.button2_peek);
                }
                else if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    mButton2.setText(R.string.button2_hide);
                }
                else if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    mButton2.setText(R.string.button2);
                }
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {
            }
        });

        mButton3 = (Button) root.findViewById(R.id.button_3);
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialogFragment bottomSheetDialogFragment = new BottomSheet3DialogFragment();
                bottomSheetDialogFragment.show(getActivity().getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
            }
        });

        return root;
    }

    @Override
    public void setPresenter(@NonNull BottomSheetsContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

}
