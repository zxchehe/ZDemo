package com.luciozhang.zdemo.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luciozhang on 2017/7/31.
 */

public class DemoHelper {
    private static List<String> demos;
    private static DemoHelper INSTANCE;

    private DemoHelper(){
        demos=new ArrayList<>();
        demos.clear();
        demos.add("BottomSheets");
        demos.add("Glide");
    }

    public static DemoHelper getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new DemoHelper();
        }
        return INSTANCE;
    }

    public List<String> getDemos() {
        return demos;
    }

    public void setDemos(List<String> demos) {
        DemoHelper.demos = demos;
    }
}
