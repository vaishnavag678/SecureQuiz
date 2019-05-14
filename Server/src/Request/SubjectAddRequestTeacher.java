package Request;


import java.io.Serializable ;
import java.util.*;

import Constants.reqEnum;
import javafx.util.Pair;
public class SubjectAddRequestTeacher implements Serializable {

    private int teacherid;
    ArrayList<Integer>  id=new ArrayList<Integer>(1000);

    public SubjectAddRequestTeacher(int teacherid, ArrayList<Integer> id) {
        this.teacherid = teacherid;
        this.id = id;
    }

    public SubjectAddRequestTeacher() {
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public ArrayList<Integer> getId() {
        return id;
    }

    public void setId(ArrayList<Integer> id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return  "" + reqEnum.SubjectAddRequestTeacher;

    }
}
