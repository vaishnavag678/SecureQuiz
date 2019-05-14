package Request;

import java.io.Serializable;
import Database.User;

public class LoginRequest implements Serializable {

    private  String userid;
    private String password;
    private String email;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
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
  /*  @Override
    public String toString(){


    }*/
}
