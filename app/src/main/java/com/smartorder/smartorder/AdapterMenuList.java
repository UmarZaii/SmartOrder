package com.smartorder.smartorder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterMenuList extends ArrayAdapter {

    List list = new ArrayList();

    public AdapterMenuList(Context context, int resource) {
        super(context, resource);
    }

    public void add(OrderMenu object) {
        list.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        HolderMenuList holderMenuList;

        if(row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.fragment_row_menulist, parent, false);
            holderMenuList = new HolderMenuList();
            holderMenuList.txtMenuType = (TextView)row.findViewById(R.id.lblMenuType);
            holderMenuList.txtMenuName = (TextView)row.findViewById(R.id.lblMenuName);
            holderMenuList.txtMenuPrice = (TextView)row.findViewById(R.id.lblMenuPrice);
            holderMenuList.txtMenuStatus = (TextView)row.findViewById(R.id.lblMenuStatus);
            row.setTag(holderMenuList);
        } else {
            holderMenuList = (HolderMenuList)row.getTag();
        }

        OrderMenu orderMenu = (OrderMenu)getItem(position);
        holderMenuList.txtMenuType.setText(orderMenu.get_menutype().toString());
        holderMenuList.txtMenuName.setText(orderMenu.get_menuname().toString());
        holderMenuList.txtMenuPrice.setText(orderMenu.get_menuprice().toString());
        holderMenuList.txtMenuStatus.setText(orderMenu.get_menustatus().toString());

        return row;

    }

    static class HolderMenuList {
        TextView txtMenuType, txtMenuName, txtMenuPrice, txtMenuStatus;
    }

}
