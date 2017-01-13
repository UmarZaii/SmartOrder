package com.smartorder.smartorder;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

public class AdminViewMenuDetails extends AppCompatActivity {

    protected Cursor cursor;
    DBHandler dbHandler;
    TextView lblMenuNameDB, lblMenuPriceDB, lblMenuStatusDB;
    String strMenuNameDB, strMenuPriceDB, strMenuStatusDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_viewmenudetails);

        dbHandler = new DBHandler(this, null, null, 1);
        lblMenuNameDB = (TextView) findViewById(R.id.lblMenuNameDB);
        lblMenuPriceDB = (TextView) findViewById(R.id.lblMenuPriceDB);
        lblMenuStatusDB = (TextView) findViewById(R.id.lblMenuStatusDB);

        SQLiteDatabase db = dbHandler.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM ordermenu WHERE menuname = '" + AdminMenuList.selection + "'",null);
        while(cursor.moveToNext()) {
            strMenuNameDB = cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_MENUNAME));
            strMenuPriceDB = cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_MENUPRICE));
            strMenuStatusDB = cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_MENUSTATUS));
            lblMenuNameDB.setText(strMenuNameDB);
            lblMenuPriceDB.setText(strMenuPriceDB);
            lblMenuStatusDB.setText(strMenuStatusDB);
        }

    }

}
