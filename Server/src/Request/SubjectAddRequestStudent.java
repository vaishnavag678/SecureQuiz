package Request;

import java.io.Serializable ;
import java.util.*;
import javafx.util.Pair;

public class SubjectAddRequestStudent implements  Serializable {
    ArrayList< Pair<Integer,Integer>> v = new ArrayList<Pair<Integer,Integer>>(1000);
    private String userid;

    public SubjectAddRequestStudent(ArrayList<Pair<Integer, Integer>> v, String userid) {
        this.v = v;
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

     /*  @Override
    public String toString(){


    }*/
}

