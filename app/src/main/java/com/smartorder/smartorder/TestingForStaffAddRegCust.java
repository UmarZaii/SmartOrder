package com.smartorder.smartorder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.UserDataHandler;

public class TestingForStaffAddRegCust extends AppCompatActivity implements OnItemClickListener {
    String[] registercust;
    ListView ListView01;
    Menu menu;
    protected Cursor cursor;
    DBHandler dbhandler;
    public static TestingForStaffAddRegCust TFSAR;
    public static String selections;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing_for_staffaddregcust);
        Button btn=(Button)findViewById(R.id.button2);
        ListView01 = (ListView)findViewById(R.id.listView1);
        ListView01.setOnItemClickListener(TestingForStaffAddRegCust.this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent inte = new Intent(TestingForStaffAddRegCust.this, TestingForStaffCreateCust.class);
                startActivity(inte);
            }
        });


        TFSAR = this;
        dbhandler = new DBHandler(this, null, null, 1);
        RefreshList();
    }

    public void RefreshList(){
        SQLiteDatabase db = dbhandler.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM userlist",null);
        registercust = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            registercust[cc] = cursor.getString(1).toString();
        }
        ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, registercust));
        ((ArrayAdapter)ListView01.getAdapter()).notifyDataSetInvalidated();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        final String selection = registercust[position];
        this.selections = selection;
        final CharSequence[] dialogitem = {"View Customer", "Update Customer", "Delete Customer"};
        AlertDialog.Builder builder = new AlertDialog.Builder(TestingForStaffAddRegCust.this);
        builder.setTitle("Choose");
        builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                switch(item){
                    case 0 :
                        Intent i = new Intent(getApplicationContext(), TestingForViewStaff.class);
                        i.putExtra("nama", selection);
                        startActivity(i);
                        break;
                    case 2 :
                        SQLiteDatabase db = dbhandler.getWritableDatabase();
                        db.execSQL("delete from userlist where usertype = '"+selection+"'");
                        RefreshList();
                        break;
                }
            }
        });
        builder.create().show();

    }

}