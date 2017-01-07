package com.smartorder.smartorder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.Toast;

public class BackgroundTask extends AsyncTask<String,Void,String> {

    DBHandler dbHandler;
    Context context;
    BackgroundTask(Context context) {
        this.context = context;
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
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context,result,Toast.LENGTH_LONG).show();
    }

}
