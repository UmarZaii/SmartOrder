package com.smartorder.smartorder;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdminViewMenuDetails extends AppCompatActivity {

    protected Cursor cursor;
    DBHandler dbhandler;
    TextView lblMenuNameDB, lblMenuPriceDB, lblMenuStatusDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_viewmenudetails);

        dbhandler = new DBHandler(this, null, null, 1);
        lblMenuNameDB = (TextView) findViewById(R.id.lblMenuNameDB);
        lblMenuPriceDB = (TextView) findViewById(R.id.lblMenuPriceDB);
        lblMenuStatusDB = (TextView) findViewById(R.id.lblMenuStatusDB);
        SQLiteDatabase db = dbhandler.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM ordermenu WHERE menuname = '" + DisplayMenuList.selection + "'",null);
        cursor.moveToFirst();
        lblMenuNameDB.setText(cursor.getString(3).toString());
        lblMenuPriceDB.setText(cursor.getString(4).toString());
        lblMenuStatusDB.setText(cursor.getString(5).toString());
    }

}
