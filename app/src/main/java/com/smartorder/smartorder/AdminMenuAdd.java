package com.smartorder.smartorder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AdminMenuAdd extends AppCompatActivity {

    String menuType, menuName, menuPrice, menuStatus;
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
    }

    public void addButtonClicked(View view) {
        menuType = "Air";
        menuName = txtMenuName.getText().toString();
        menuPrice = txtMenuPrice.getText().toString();
        menuStatus = txtMenuStatus.getText().toString();

//        OrderMenu orderMenu = new OrderMenu(menuType, menuName, menuPrice, menuStatus);
//        dbHandler.addOrderMenu(orderMenu);
        BackgroundTask bgTask = new BackgroundTask(this);
        bgTask.execute("add_menu", menuType, menuName, menuPrice, menuStatus);

        startActivity(new Intent(this, AdminMenuList.class));
    }

    public void deleteButtonClicked(View view) {
        String inputMenuname = txtMenuName.getText().toString();
        dbHandler.deleteOrderMenu(inputMenuname);

        startActivity(new Intent(this, AdminMenuList.class));
    }

    public void updateButtonClicked(View view) {
        menuType = "Air";
        menuName = txtMenuName.getText().toString();
        menuPrice = txtMenuPrice.getText().toString();
        menuStatus = txtMenuStatus.getText().toString();
        dbHandler.updOrderMenu(menuType, menuName, menuPrice, menuStatus);

        startActivity(new Intent(this, AdminMenuList.class));
    }

}
