package com.smartorder.smartorder;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TestingForStaffCreateCust extends AppCompatActivity {
    protected Cursor cursor;
    DBHandler dbhandler;
    Button ton1, ton2;
    EditText text1, text2, text3, text4, text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_regcustomer);

        dbhandler = new DBHandler(this, null, null, 1);
        text1 = (EditText) findViewById(R.id.txtNationalID);
        text2 = (EditText) findViewById(R.id.txtUserType);
        text3 = (EditText) findViewById(R.id.txtUserName);
        text4 = (EditText) findViewById(R.id.txtUserPass);
        text5 = (EditText) findViewById(R.id.txtPhoneNo);
        ton1 = (Button) findViewById(R.id.btnRegStaff);
        ton2 = (Button) findViewById(R.id.btnBackHome);

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbhandler.getWritableDatabase();
                db.execSQL("insert into userlist(nationalid, usertype, username, userpass, phoneno) values('" +
                        text1.getText().toString()+"','"+
                        text2.getText().toString() +"','" +
                        text3.getText().toString()+"','"+
                        text4.getText().toString() +"','" +
                        text5.getText().toString() + "')");
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

}