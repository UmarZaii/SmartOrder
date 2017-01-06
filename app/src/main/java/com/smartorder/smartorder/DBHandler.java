package com.smartorder.smartorder;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "smartorder.db";
    private static final String TABLE_ORDERMENU = "ordermenu";
    private static final String COLUMN_MENUID = "_menuid";
    private static final String COLUMN_MENUNAME = "menuname";
    private static final String COLUMN_MENUTYPE = "menutype";
    private static final String COLUMN_MENUPRICE = "menuprice";
    private static final String COLUMN_MENUSTATUS = "menustatus";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_ORDERMENU + "(" +
                COLUMN_MENUID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                COLUMN_MENUNAME + " TEXT " +
                COLUMN_MENUTYPE + " TEXT " +
                COLUMN_MENUPRICE + " TEXT " +
                COLUMN_MENUSTATUS + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDERMENU);
        onCreate(db);
    }

    public void addOrderMenu(OrderMenu orderMenu){
        ContentValues values = new ContentValues();
        values.put(COLUMN_MENUNAME, orderMenu.get_menuname());
        values.put(COLUMN_MENUTYPE, orderMenu.get_menutype());
        values.put(COLUMN_MENUPRICE, orderMenu.get_menuprice());
        values.put(COLUMN_MENUSTATUS, orderMenu.get_menustatus());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_ORDERMENU, null, values);
        db.close();
    }

    public void deleteOrderMenu(String menuName){
        SQLiteDatabase db = getWritableDatabase();
        String query = "DELETE FROM " + TABLE_ORDERMENU + " WHERE " + COLUMN_MENUNAME + "=\"" + menuName + "\";";
        db.execSQL(query);
    }

    public String databaseToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ORDERMENU + "WHERE 1";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        while(!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex("menuname")) != null) {
                dbString += c.getString(c.getColumnIndex("menuname"));
                dbString += "\t";
            }
            if(c.getString(c.getColumnIndex("menutype")) != null) {
                dbString += c.getString(c.getColumnIndex("menutype"));
                dbString += "\t";
            }
            if(c.getString(c.getColumnIndex("menuprice")) != null) {
                dbString += c.getString(c.getColumnIndex("menuprice"));
                dbString += "\t";
            }
            if(c.getString(c.getColumnIndex("menustatus")) != null) {
                dbString += c.getString(c.getColumnIndex("menustatus"));
                dbString += "\n";
            }
        }
        db.close();
        return dbString;
    }

}
