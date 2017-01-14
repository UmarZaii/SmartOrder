package com.smartorder.smartorder;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.util.Log;

public class DBHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "smartorder.db";

    public static final String TABLE_USERLIST = "userlist";
    public static final String COLUMN_NATIONALID = "nationalid";
    public static final String COLUMN_USERTYPE = "usertype";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_USERPASS = "userpass";
    public static final String COLUMN_PHONENO = "phoneno";

    public static final String TABLE_ORDERMENU = "ordermenu";
    public static final String COLUMN_MENUID = "menuid";
    public static final String COLUMN_MENUTYPE = "menutype";
    public static final String COLUMN_MENUNAME = "menuname";
    public static final String COLUMN_MENUPRICE = "menuprice";
    public static final String COLUMN_MENUSTATUS = "menustatus";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query;
        query = "CREATE TABLE " + TABLE_USERLIST + "(" +
                COLUMN_NATIONALID + " TEXT PRIMARY KEY," +
                COLUMN_USERTYPE + " TEXT," +
                COLUMN_USERNAME + " TEXT," +
                COLUMN_USERPASS + " TEXT," +
                COLUMN_PHONENO + " TEXT" +
                ");";
        db.execSQL(query);
        query = "CREATE TABLE " + TABLE_ORDERMENU + "(" +
                COLUMN_MENUID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_MENUTYPE + " TEXT," +
                COLUMN_MENUNAME + " TEXT," +
                COLUMN_MENUPRICE + " TEXT," +
                COLUMN_MENUSTATUS + " TEXT" +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERLIST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDERMENU);
        onCreate(db);
    }

    public void addUserList(UserList userList){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NATIONALID, userList.get_nationalid());
        values.put(COLUMN_USERTYPE, userList.get_usertype());
        values.put(COLUMN_USERNAME, userList.get_username());
        values.put(COLUMN_USERPASS, userList.get_userpass());
        values.put(COLUMN_PHONENO, userList.get_phoneno());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_USERLIST, null, values);
        db.close();
    }

    public void addOrderMenu(OrderMenu orderMenu){
        ContentValues values = new ContentValues();
        values.put(COLUMN_MENUTYPE, orderMenu.get_menutype());
        values.put(COLUMN_MENUNAME, orderMenu.get_menuname());
        values.put(COLUMN_MENUPRICE, orderMenu.get_menuprice());
        values.put(COLUMN_MENUSTATUS, orderMenu.get_menustatus());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_ORDERMENU, null, values);
        db.close();
    }

    public void updOrderMenu(String menuName, String menuPrice, String menuStatus){
        SQLiteDatabase db = getWritableDatabase();
        String query = "UPDATE FROM " + TABLE_ORDERMENU + " SET " +
                COLUMN_MENUPRICE + "=" + menuPrice + ", " +
                COLUMN_MENUSTATUS + "=" + menuStatus + " WHERE " +
                COLUMN_MENUNAME + "=\"" + menuName + "\";";
        db.execSQL(query);
    }

    public void deleteUserList(String nationalID){
        SQLiteDatabase db = getWritableDatabase();
        String query = "DELETE FROM " + TABLE_USERLIST + " WHERE " + COLUMN_NATIONALID + "=\"" + nationalID + "\";";
        db.execSQL(query);
    }

    public void deleteOrderMenu(String menuName){
        SQLiteDatabase db = getWritableDatabase();
        String query = "DELETE FROM " + TABLE_ORDERMENU + " WHERE " + COLUMN_MENUNAME + "=\"" + menuName + "\";";
        db.execSQL(query);
    }

    public Cursor getMenuList(SQLiteDatabase db) {
        String[] dbColumns = { COLUMN_MENUTYPE, COLUMN_MENUNAME, COLUMN_MENUPRICE, COLUMN_MENUSTATUS };
        Cursor cursor = db.query(TABLE_ORDERMENU, dbColumns, null, null, null, null, null);
        return cursor;
    }

    public boolean getUserList(String staffID, String staffPass) {
        String selectQuery = "SELECT * FROM " + TABLE_USERLIST + " WHERE " +
                COLUMN_NATIONALID + " = " +  "'"+staffID+"'" + " AND " + COLUMN_USERPASS + " = "
                + "'"+staffPass+"'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();
        if (cursor.getCount() > 0){
            return true;
        }
        cursor.close();
        db.close();

        return false;
    }
}
