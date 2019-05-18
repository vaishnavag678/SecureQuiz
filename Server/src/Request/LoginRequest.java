package Request;

import java.io.Serializable;

import Constants.reqEnum;

public class LoginRequest implements Serializable {


    private String email;
    private String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
