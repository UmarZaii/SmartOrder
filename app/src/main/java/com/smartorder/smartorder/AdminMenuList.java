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

        } else if (menuItemId == R.id.btmBarMenu){

            startActivity(new Intent(this, AdminMenuList.class));

        } else if (menuItemId == R.id.btmBarUser){

            TestingForStaffAddRegCust uf = new TestingForStaffAddRegCust();
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_admin_menulist, uf).commit();

        } else if (menuItemId == R.id.btmBarSetting){

        }

    }

    @Override
    public void onMenuTabReSelected(@IdRes int menuItemId) {

    }

    public void addMenuPage(View view) {
        startActivity(new Intent(this, AdminMenuAdd.class));
    }

}
