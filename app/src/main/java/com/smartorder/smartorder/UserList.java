package com.smartorder.smartorder;

public class UserList {

    private String _nationalid;
    private String _usertype;
    private String _username;
    private String _userpass;
    private String _phoneno;

    public UserList() {
    }

    public UserList(String nationalid, String usertype, String username, String userpass, String phoneno) {
        this._nationalid = nationalid;
        this._usertype = usertype;
        this._username = username;
        this._userpass = userpass;
        this._phoneno = phoneno;
    }

    public String get_nationalid() {
        return _nationalid;
    }

    public void set_nationalid(String _nationalid) {
        this._nationalid = _nationalid;
    }

    public String get_usertype() {
        return _usertype;
    }

    public void set_usertype(String _usertype) {
        this._usertype = _usertype;
    }

    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public String get_userpass() {
        return _userpass;
    }

    public void set_userpass(String _userpass) {
        this._userpass = _userpass;
    }

    public String get_phoneno() {
        return _phoneno;
    }

    public void set_phoneno(String _phoneno) {
        this._phoneno = _phoneno;
    }
}
