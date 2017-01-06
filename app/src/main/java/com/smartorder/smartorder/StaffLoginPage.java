package com.smartorder.smartorder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StaffLoginPage extends AppCompatActivity implements View.OnClickListener {

    Button logStaff;
    TextView icStaff, pwdStaff;
    DBHandler dbHandler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_loginpage);

        dbHandler = new DBHandler(this,null,null,1);
        logStaff = (Button) findViewById(R.id.logBtnStaff);
        icStaff = (EditText) findViewById(R.id.icStaff);
        pwdStaff = (EditText) findViewById(R.id.pwdStaff);

        logStaff.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.logBtnStaff:
                login();
                break;
            default:
        }
    }

    private void login() {
        String nationalid = icStaff.getText().toString();
        String pass = pwdStaff.getText().toString();

        if(dbHandler.getUserList(nationalid,pass)){
            startActivity(new Intent(this, StaffHomePage.class));
            finish();
        } else{
            Toast.makeText(getApplicationContext(), "Wrong email/password",Toast.LENGTH_SHORT).show();
        }
    }
}
