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

    Button btnLogStaff;
    TextView txtStaffID, txtStaffPass;
    DBHandler dbHandler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_loginpage);

        dbHandler = new DBHandler(this,null,null,1);
        btnLogStaff = (Button) findViewById(R.id.btnLogStaff);
        txtStaffID = (EditText) findViewById(R.id.txtStaffID);
        txtStaffPass = (EditText) findViewById(R.id.txtStaffPass);

        btnLogStaff.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogStaff:
                loginStaff();
                break;
            default:
        }
    }

    private void loginStaff() {
        String inputStaffID = txtStaffID.getText().toString();
        String inputStaffPass = txtStaffPass.getText().toString();

        if(dbHandler.getUserList(inputStaffID,inputStaffPass)){
            startActivity(new Intent(this, AdminMenuList.class));
            finish();
        } else{
            Toast.makeText(getApplicationContext(), "Wrong email/password",Toast.LENGTH_SHORT).show();
        }
    }
}
