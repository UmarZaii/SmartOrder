package com.smartorder.smartorder;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class BackgroundTask extends AsyncTask<String,OrderMenu,String> {

    public static Context context;
    DBHandler dbHandler;
    AdapterMenuList adapterMenuList;
    Activity activity;
    public static ListView menuList;

    BackgroundTask(Context context) {

        this.context = context;
        activity = (Activity)context;
    }

    @Override
    protected void onPreExecute() {

        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        String method = params[0];
        dbHandler = new DBHandler(context, null, null, 1);

        if(method.equals("add_menu")) {

            String menuType = params[1];
            String menuName = params[2];
            String menuPrice = params[3];
            String menuStatus = params[4];
            SQLiteDatabase db = dbHandler.getWritableDatabase();
            OrderMenu orderMenu = new OrderMenu(menuType, menuName, menuPrice, menuStatus);
            dbHandler.addOrderMenu(orderMenu);
            return "One Row Inserted....";

        } else if (method.equals("disp_menu")) {

            menuList = (ListView)activity.findViewById(R.id.dispMenuList);
            SQLiteDatabase db = dbHandler.getReadableDatabase();
            Cursor cursor = dbHandler.getMenuList(db);
            adapterMenuList = new AdapterMenuList(context,R.layout.fragment_row_menulist);
            String strMenuType, strMenuName, strMenuPrice, strMenuStatus;
            while(cursor.moveToNext()) {
                strMenuType = cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_MENUTYPE));
                strMenuName = cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_MENUNAME));
                strMenuPrice = cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_MENUPRICE));
                strMenuStatus = cursor.getString(cursor.getColumnIndex(DBHandler.COLUMN_MENUSTATUS));
                OrderMenu orderMenu = new OrderMenu(strMenuType, strMenuName, strMenuPrice, strMenuStatus);
                publishProgress(orderMenu);
            }
            return "disp_menu";
        }

        return null;

    }

    @Override
    protected void onProgressUpdate(OrderMenu... values) {
        adapterMenuList.add(values[0]);
    }

    @Override
    protected void onPostExecute(String result) {

        if(result.equals("add_menu")) {
            Toast.makeText(context,result,Toast.LENGTH_LONG).show();
        } else if (result.equals("disp_menu")) {
            menuList.setAdapter(adapterMenuList);
        }

    }

}
