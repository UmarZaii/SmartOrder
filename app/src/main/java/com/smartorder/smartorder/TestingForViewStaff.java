package com.smartorder.smartorder;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TestingForViewStaff extends AppCompatActivity {
    protected Cursor cursor;
    DBHandler dbhandler;
    Button ton2;
    TextView txtNationalID, txtUserType, txtUserName, txtUserPass, txtPhoneNo;
    String strNationalID, strUserType, strUserName, strUserPass, strPhoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing_for_viewstaff);

        dbhandler = new DBHandler(this, null, null, 1);
        txtNationalID = (TextView) findViewById(R.id.textView1);
        txtUserType = (TextView) findViewById(R.id.textView2);
        txtUserName = (TextView) findViewById(R.id.textView3);
        txtUserPass = (TextView) findViewById(R.id.textView4);
        txtPhoneNo = (TextView) findViewById(R.id.textView5);
        SQLiteDatabase db = dbhandler.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM userlist WHERE usertype = '" + TestingForStaffAddRegCust.selections + "'",null);
        cursor.moveToFirst();
        txtNationalID.setText(cursor.getString(0).toString());
        txtUserType.setText(cursor.getString(1).toString());
        txtUserName.setText(cursor.getString(2).toString());
        txtUserPass.setText(cursor.getString(3).toString());
        txtPhoneNo.setText(cursor.getString(4).toString());

        ton2 = (Button) findViewById(R.id.button1);
        ton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }

}
