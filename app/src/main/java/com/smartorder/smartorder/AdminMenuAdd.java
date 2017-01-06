package com.smartorder.smartorder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AdminMenuAdd extends AppCompatActivity {

    EditText txtMenuName, txtMenuPrice, txtMenuStatus;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menuadd);
        txtMenuName = (EditText) findViewById(R.id.txtMenuName);
        txtMenuPrice = (EditText) findViewById(R.id.txtMenuPrice);
        txtMenuStatus = (EditText) findViewById(R.id.txtMenuStatus);
        dbHandler = new DBHandler(this, null, null, 1);
        printDatabase();
    }

    public void addButtonClicked(View view) {
        OrderMenu orderMenu = new OrderMenu(txtMenuName.getText().toString(), "Air", txtMenuPrice.getText().toString(), txtMenuStatus.getText().toString());
        dbHandler.addOrderMenu(orderMenu);
        printDatabase();
    }

    public void deleteButtonClicked(View view) {
        String inputMenuname = txtMenuName.getText().toString();
        dbHandler.deleteOrderMenu(inputMenuname);
        printDatabase();
    }

    public void printDatabase() {
        String dbString = dbHandler.databaseToString();
    }

}
