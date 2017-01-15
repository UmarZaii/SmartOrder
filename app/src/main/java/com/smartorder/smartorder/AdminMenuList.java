package com.smartorder.smartorder;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.IdRes;
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
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;
import android.util.Log;


public class AdminMenuList extends AppCompatActivity implements OnItemClickListener, OnMenuTabClickListener {

//    Spinner spnMenuType;
//    ArrayAdapter<CharSequence> adpMenuType;
    String[] dataMenuList;
    ListView menuList = BackgroundTask.menuList;
    protected Cursor cursor;
    DBHandler dbhandler;
    BottomBar btmBarAdmin;
    public static String selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menulist);

        btmBarAdmin = BottomBar.attach(this, savedInstanceState);
        btmBarAdmin.setItemsFromMenu(R.menu.menu_admin, this);
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

    @Override
    public void onMenuTabSelected(@IdRes int menuItemId) {

        if (menuItemId == R.id.btmBarHome){

//            HomeFragment hf = new HomeFragment();
//            getSupportFragmentManager().beginTransaction().replace(R.id.Frame,hf).commit();

        } else if (menuItemId == R.id.btmBarMenu){

            startActivity(new Intent(this, AdminMenuList.class));
//            MenuFragment mf = new MenuFragment();
//            getSupportFragmentManager().beginTransaction().replace(R.id.Frame,mf).commit();

        } else if (menuItemId == R.id.btmBarUser){

            startActivity(new Intent(this, TestingForStaffAddRegCust.class));
//            UserFragment uf = new UserFragment();
//            getSupportFragmentManager().beginTransaction().replace(R.id.Frame,uf).commit();

        } else if (menuItemId == R.id.btmBarSetting){

//            RegisterFragment rf = new RegisterFragment();
//            getSupportFragmentManager().beginTransaction().replace(R.id.Frame,rf).commit();

        }

    }

    @Override
    public void onMenuTabReSelected(@IdRes int menuItemId) {

    }

    public void addMenuPage(View view) {
        startActivity(new Intent(this, AdminMenuAdd.class));
    }

}
