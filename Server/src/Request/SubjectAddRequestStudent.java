package Request;

import java.io.Serializable ;
import java.util.*;

import Constants.reqEnum;
import javafx.util.Pair;

public class SubjectAddRequestStudent implements  Serializable {
    ArrayList< Pair<Integer,Integer>> v = new ArrayList<Pair<Integer,Integer>>(1000);
    private int userid;

    public SubjectAddRequestStudent(ArrayList<Pair<Integer, Integer>> v, int userid) {
        this.v = v;
        this.userid = userid;
    }

    public ArrayList<Pair<Integer, Integer>> getV() {
        return v;
    }



    public void setV(ArrayList<Pair<Integer, Integer>> v) {
        this.v = v;
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

