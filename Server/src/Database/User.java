package Database;

import java.io.Serializable ;
public class User implements Serializable {


    private String userid;
    private String email;
    private String password;
    private String fname;
    private String lname;

    public String getfname() {
        return fname;
    }

    public void setfname(String fname){
        this.fname=fname;
    }

    public  void setemail(String email){
        this.email=email;
    }
    public String getemail(){
        return email;
    }
    public String getlname(){
        return lname;
    }
    public void setlame(String lname){
        this.lname=lname;
    }

    public void setuserid(String userid){
        this.userid=userid;
    }
    public String getuserid(){
        return userid;
    }
    public String getpassword(){
        return password;
    }
    public void setpassword(String password){
        this.password=password;
    }
}
