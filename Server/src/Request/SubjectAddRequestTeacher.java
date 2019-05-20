package Request;


import java.io.Serializable ;
import java.util.*;

import Constants.reqEnum;
import ServerClasses.Teacherid;


public class SubjectAddRequestTeacher implements Serializable {

    private int userid;
    ArrayList<Teacherid> teacherid;

    public SubjectAddRequestTeacher(ArrayList<Teacherid> teacherid,int userid) {
        this.teacherid = new ArrayList<>();

        for(Teacherid u : teacherid)
        {
            this.teacherid.add(u);
        }
        this.userid=userid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public ArrayList<Teacherid> getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(ArrayList<Teacherid> teacherid) {
        this.teacherid = teacherid;
    }

    @Override
    public String toString(){
        return  "" + reqEnum.SubjectAddRequestTeacher;

    }
}
