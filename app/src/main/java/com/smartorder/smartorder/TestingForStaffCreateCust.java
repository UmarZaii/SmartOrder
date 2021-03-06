package com.smartorder.smartorder;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.smartorder.smartorder.R.id.txtMenuName;

public class TestingForStaffCreateCust extends AppCompatActivity {
    protected Cursor cursor;
    DBHandler dbhandler;
    Button ton1, ton2;
    EditText txtNationalID, txtUserType, txtUserName, txtUserPass, txtPhoneNo;
    String nationalID, userType, userName, userPass, phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_regcustomer);

        dbhandler = new DBHandler(this, null, null, 1);
        txtNationalID = (EditText) findViewById(R.id.txtNationalID);
        txtUserType = (EditText) findViewById(R.id.txtUserType);
        txtUserName = (EditText) findViewById(R.id.txtUserName);
        txtUserPass = (EditText) findViewById(R.id.txtUserPass);
        txtPhoneNo = (EditText) findViewById(R.id.txtPhoneNo);
        ton1 = (Button) findViewById(R.id.btnRegStaff);
        ton2 = (Button) findViewById(R.id.btnBackHome);

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbhandler.getWritableDatabase();
                db.execSQL("insert into userlist(nationalid, usertype, username, userpass, phoneno) values('" +
                        txtNationalID.getText().toString()+"','"+
                        txtUserType.getText().toString() +"','" +
                        txtUserName.getText().toString()+"','"+
                        txtUserPass.getText().toString() +"','" +
                        txtPhoneNo.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "User Registered", Toast.LENGTH_LONG).show();
                TestingForStaffAddRegCust.TFSAR.RefreshList();
                finish();
            }
        });
        ton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });

    }
    public void del(View view) {
        String inputMenuname = txtNationalID.getText().toString();
        dbhandler.deleteUserList(inputMenuname);
        TestingForStaffAddRegCust.TFSAR.RefreshList();
        finish();
    }

    public void upd(View view) {
        nationalID = txtNationalID.getText().toString();
        userType = txtUserType.getText().toString();
        userName = txtUserName.getText().toString();
        userPass = txtUserPass.getText().toString();
        phoneNo = txtPhoneNo.getText().toString();
        dbhandler.updUserList(nationalID, userType, userName, userPass, phoneNo);
        TestingForStaffAddRegCust.TFSAR.RefreshList();
        finish();
    }

}