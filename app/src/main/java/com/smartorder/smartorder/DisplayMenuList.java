package com.smartorder.smartorder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DisplayMenuList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_display_menulist);
        BackgroundTask bgTask = new BackgroundTask(this);
        bgTask.execute("disp_menu");
    }

}