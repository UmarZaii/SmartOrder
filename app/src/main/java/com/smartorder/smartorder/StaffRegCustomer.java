package com.smartorder.smartorder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//thi is wat
public class StaffRegCustomer extends AppCompatActivity implements View.OnClickListener {
    EditText txtUserType, txtNationalID, txtUserName, txtUserPass, txtPhoneNum;
    Button regStaff, backHome;
    DBHandler dbhandler;
    Session s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_regcustomer);

        dbhandler = new DBHandler(this, null, null, 1);
        txtUserType = (EditText) findViewById(R.id.txtUserType);
        txtNationalID = (EditText) findViewById(R.id.txtNationalID);
        txtUserName = (EditText) findViewById(R.id.txtUserName);
        txtUserPass = (EditText) findViewById(R.id.txtUserPass);
        txtPhoneNum = (EditText) findViewById(R.id.txtPhoneNo);
        regStaff = (Button) findViewById(R.id.btnRegStaff);
        backHome = (Button) findViewById(R.id.btnBackHome);
        regStaff.setOnClickListener(this);
        backHome.setOnClickListener(this);



    }

    @Override
    public void onClick(View vi) {
        switch (vi.getId()){
            case R.id.btnRegStaff:
                register();
                break;
            case R.id.btnBackHome:
                Intent i = new Intent(getBaseContext(),StaffHomePage.class);
                //  startActivity(new Intent(this,StaffHomePage.class));
                this.startActivity(i);
                finish();
                break;
            default:
        }
    }

    private void register() {
        String NationalID = txtNationalID.getText().toString();
        String UserType = txtUserType.getText().toString();
        String UserName = txtUserName.getText().toString();
        String UserPass = txtUserPass.getText().toString();
        String PhoneNum = txtPhoneNum.getText().toString();

        if(NationalID.isEmpty() && UserType.isEmpty() && UserName.isEmpty() && UserPass.isEmpty() && PhoneNum.isEmpty() ){
            displayToast("Username/password field empty");
        }
        else{
            UserList userList = new UserList(NationalID,UserType,UserName,UserPass,PhoneNum);
            dbhandler.addUserList(userList);
            displayToast("User registered");
            finish();
        }
    }

    private void displayToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

}