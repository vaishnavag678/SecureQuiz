package ServerClasses;

import Constants.LoginStatus;

import java.io.Serializable;

public class User implements Serializable {


    private int userid;
    private String email;
    private String fname;
    private String lname;
    private String USER_LOGIN_STATUS;
    int type;

    public User(int userid, String email, String fname, String lname, String USER_LOGIN_STATUS, int type) {
        this.userid = userid;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.USER_LOGIN_STATUS = USER_LOGIN_STATUS;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public User() {
        USER_LOGIN_STATUS = String.valueOf(LoginStatus.NO_SUCH_USER);//Default Status
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUSER_LOGIN_STATUS() {
        return USER_LOGIN_STATUS;
    }

    public void setUSER_LOGIN_STATUS(String USER_LOGIN_STATUS) {
        this.USER_LOGIN_STATUS = USER_LOGIN_STATUS;
    }
}
