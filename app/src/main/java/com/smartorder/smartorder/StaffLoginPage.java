package com.smartorder.smartorder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by mansoull on 6/1/2017.
 */

public class StaffLoginPage extends AppCompatActivity implements View.OnClickListener {

    Button logStaff;
    TextView icStaff, pwdStaff;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_page);
    }

    @Override
    public void onClick(View view) {

    }
}
