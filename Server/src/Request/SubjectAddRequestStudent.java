package Request;

import java.io.Serializable ;
import java.util.*;

import Constants.reqEnum;
import ServerClasses.Subid;
import ServerClasses.Teacherid;
import javafx.util.Pair;

public class SubjectAddRequestStudent implements  Serializable {
    ArrayList<Subid> subid = new ArrayList<>(1000);
    //ArrayList<Teacherid> teacherid = new ArrayList<>(1000);
    private int userid;

    public SubjectAddRequestStudent(ArrayList<Subid> subid, int userid) {
        this.subid = subid;
        this.userid = userid;
    }

    public ArrayList<Subid> getSubid() {
        return subid;
    }

    public void setSubid(ArrayList<Subid> subid) {
        this.subid = subid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString(){
        return ""+ reqEnum.SubjectAddRequestStudent;

    }
}

