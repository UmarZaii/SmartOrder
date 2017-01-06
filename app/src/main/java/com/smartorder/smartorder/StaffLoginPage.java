package com.smartorder.smartorder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StaffLoginPage extends AppCompatActivity implements View.OnClickListener {

    Button logStaff;
    TextView icStaff, pwdStaff;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_loginpage);
    }

    @Override
    public void onClick(View view) {

    }
}
