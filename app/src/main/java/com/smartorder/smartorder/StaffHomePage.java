package com.smartorder.smartorder;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class StaffHomePage extends AppCompatActivity implements View.OnClickListener {

    TextView tvLogoutStaff;
    Button EnterRegStaff;
    Session s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_homepage);

        EnterRegStaff = (Button) findViewById(R.id.btnreg);
        EnterRegStaff.setOnClickListener(this);
        s = new Session(this);
        if(!s.loggedin()){
            logout();
        }
        tvLogoutStaff = (TextView) findViewById(R.id.tvLogOutStaff);
        tvLogoutStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    private void logout() {
        s.setLoggedin(false);
        finish();
    }

    @Override
    public void onClick(View vie) {
        switch (vie.getId()){
            case R.id.btnreg:
                startActivity(new Intent(this,TestingForStaffAddRegCust.class));
        }
    }
}
