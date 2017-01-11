package com.smartorder.smartorder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DisplayMenuList extends AppCompatActivity implements OnItemClickListener{

    String[] dataMenuList;
    ListView menuList = BackgroundTask.menuList;
    protected Cursor cursor;
    DBHandler dbhandler;
    public static String selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_display_menulist);
        menuList = (ListView)findViewById(R.id.dispMenuList);
        menuList.setOnItemClickListener(DisplayMenuList.this);
        BackgroundTask bgTask = new BackgroundTask(this);
        bgTask.execute("disp_menu");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        dbhandler = new DBHandler(this, null, null, 1);
        SQLiteDatabase db = dbhandler.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM ordermenu",null);
        dataMenuList = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            dataMenuList[cc] = cursor.getString(2).toString();
        }
        final String selection = dataMenuList[position];
        this.selection = selection;
        startActivity(new Intent(this, AdminViewMenuDetails.class));

    }
}