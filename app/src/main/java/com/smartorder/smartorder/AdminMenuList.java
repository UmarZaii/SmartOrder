package com.smartorder.smartorder;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;
import android.util.Log;


public class AdminMenuList extends AppCompatActivity implements OnItemClickListener {

//    Spinner spnMenuType;
//    ArrayAdapter<CharSequence> adpMenuType;
    String[] dataMenuList;
    ListView menuList = BackgroundTask.menuList;
    protected Cursor cursor;
    DBHandler dbhandler;
    public static String selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menulist);
        menuList = (ListView)findViewById(R.id.dispMenuList);
        menuList.setOnItemClickListener(AdminMenuList.this);
        BackgroundTask bgTask = new BackgroundTask(this);
        bgTask.execute("disp_menu");

        //ComboBox Menu Type
//        spnMenuType = (Spinner) findViewById(R.id.spnMenuType);
//        adpMenuType = ArrayAdapter.createFromResource(this,R.array.menu_types,android.R.layout.simple_spinner_item);
//        adpMenuType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spnMenuType.setAdapter(adpMenuType);
//        spnMenuType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(AdminMenuList.this, parent.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

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
        Log.d("Selection", selection);

        startActivity(new Intent(this, AdminViewMenuDetails.class));
    }

    public void addMenuPage(View view) {
        startActivity(new Intent(this, AdminMenuAdd.class));
    }

//    public void viewMenuPage(View view) {
//        startActivity(new Intent(this, DisplayMenuList.class));
//    }

}
