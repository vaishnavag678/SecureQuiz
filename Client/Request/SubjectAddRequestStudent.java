package Request;

import java.io.Serializable ;
import java.util.*;

import Constants.reqEnum;
import MainClasses.Subid;
import MainClasses.Teacherid;
import javafx.util.Pair;

public class SubjectAddRequestStudent implements  Serializable {
    ArrayList<Subid> subid;
    //ArrayList<Teacherid> teacherid = new ArrayList<>(1000);
    private int userid;

    public SubjectAddRequestStudent(ArrayList<Subid> subid, int userid) {
        this.subid = new ArrayList<>();
        for(Subid u : subid)
            this.subid.add(u);

        this.userid = userid;
    }

    public ArrayList<Subid> getSubid() {
        return subid;
    }

    public void setSubid(ArrayList<Subid> subid) {
        this.subid = new ArrayList<>();
        for(Subid u : subid)
            this.subid.add(u);
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

