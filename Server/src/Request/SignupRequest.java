package Request;


import Constants.reqEnum;

import java.io.Serializable ;

public class SignupRequest {

    private String fname;
    private String lname;
    private String email;
    private String password;

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
     *server banao xd :p
     * @return

     */
    @Override
    public String toString(){
        return "" + reqEnum.SignupRequest;

    }
}
