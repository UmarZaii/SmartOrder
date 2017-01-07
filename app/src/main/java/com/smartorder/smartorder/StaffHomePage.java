package com.smartorder.smartorder;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class StaffHomePage extends AppCompatActivity {

    TextView tvLogoutStaff;
    Session s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_homepage);

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
}
