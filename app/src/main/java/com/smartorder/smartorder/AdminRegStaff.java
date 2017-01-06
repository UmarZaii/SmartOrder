package com.smartorder.smartorder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AdminRegStaff extends AppCompatActivity {

    //da
    EditText txtNationalID, txtUserType, txtUserName, txtUserPass, txtPhoneNo;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_regstaff);
        txtNationalID = (EditText) findViewById(R.id.txtNationalID);
        txtUserType = (EditText) findViewById(R.id.txtUserType);
        txtUserName = (EditText) findViewById(R.id.txtUserName);
        txtUserPass = (EditText) findViewById(R.id.txtUserPass);
        txtPhoneNo = (EditText) findViewById(R.id.txtPhoneNo);
        dbHandler = new DBHandler(this, null, null, 1);
        printDatabase();
    }

    public void addButtonClicked(View view) {
        UserList userList = new UserList(txtNationalID.getText().toString(), txtUserType.getText().toString(), txtUserName.getText().toString(), txtUserPass.getText().toString(), txtPhoneNo.getText().toString());
        dbHandler.addUserList(userList);
        printDatabase();
    }

    public void deleteButtonClicked(View view) {
        String inputNationalID = txtNationalID.getText().toString();
        dbHandler.deleteUserList(inputNationalID);
        printDatabase();
    }

    public void printDatabase() {

        String dbString = dbHandler.databaseToString();
    }

}
