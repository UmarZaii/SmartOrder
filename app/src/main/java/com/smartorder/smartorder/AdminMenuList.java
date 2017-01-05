package com.smartorder.smartorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;


public class AdminMenuList extends AppCompatActivity implements View.OnClickListener {

    Button btnAddMenu;
    Spinner spnMenuType;
    ArrayAdapter<CharSequence> adpMenuType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menulist);

        //Button Add Menu
        btnAddMenu = (Button) findViewById(R.id.btnAddMenu);
        btnAddMenu.setOnClickListener(this);

        //ComboBox Menu Type
        spnMenuType = (Spinner) findViewById(R.id.spnMenuType);
        adpMenuType = ArrayAdapter.createFromResource(this,R.array.menu_types,android.R.layout.simple_spinner_item);
        adpMenuType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnMenuType.setAdapter(adpMenuType);
        spnMenuType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AdminMenuList.this, parent.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch ((v.getId())) {
            case R.id.btnAddMenu:
                startActivity(new Intent(this, AdminMenuAdd.class));
                break;
        }

    }
}
