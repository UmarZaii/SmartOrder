package com.smartorder.smartorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;


public class AdminMenuList extends AppCompatActivity {

    Spinner spnMenuType;
    ArrayAdapter<CharSequence> adpMenuType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menulist);

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

    public void addMenuPage(View view) {
        startActivity(new Intent(this, AdminMenuAdd.class));
    }

    public void viewMenuPage(View view) {
        startActivity(new Intent(this, DisplayMenuList.class));
    }

}
