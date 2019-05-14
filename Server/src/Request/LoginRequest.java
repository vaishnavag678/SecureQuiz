package Request;

import java.io.Serializable;
import Database.User;
import Constants.reqEnum;

public class LoginRequest implements Serializable {

    private  int userid;
    private String password;
    private String email;

    public LoginRequest(int userid, String password, String email) {
        this.userid = userid;
        this.password = password;
        this.email = email;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*************
     * we have to complete the overrride method here
     * do it accordingly how you actually defined constant and server
     *
     * @return
     */
   @Override
    public String toString(){
        return "" + reqEnum.LoginRequest;

    }
}
