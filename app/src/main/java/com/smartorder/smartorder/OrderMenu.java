package com.smartorder.smartorder;

public class OrderMenu {

    private int _menuid;
    private String _menuname;
    private String _menutype;
    private String _menuprice;
    private String _menustatus;

    public OrderMenu() {
    }

    public OrderMenu(String menuname, String menutype, String menuprice, String menustatus) {
        this._menuname = menuname;
        this._menutype = menutype;
        this._menuprice = menuprice;
        this._menustatus = menustatus;
    }

    public int get_menuid() {
        return _menuid;
    }

    public void set_menuid(int _menuid) {
        this._menuid = _menuid;
    }

    public String get_menuname() {
        return _menuname;
    }

    public void set_menuname(String _menuname) {
        this._menuname = _menuname;
    }

    public String get_menutype() {
        return _menutype;
    }

    public void set_menutype(String _menutype) {
        this._menutype = _menutype;
    }

    public String get_menuprice() {
        return _menuprice;
    }

    public void set_menuprice(String _menuprice) {
        this._menuprice = _menuprice;
    }

    public String get_menustatus() {
        return _menustatus;
    }

    public void set_menustatus(String _menustatus) {
        this._menustatus = _menustatus;
    }
}
