package Request;


import java.io.Serializable ;
import java.util.*;

import Constants.reqEnum;


public class SubjectAddRequestTeacher implements Serializable {

    private int teacherid;
    ArrayList<Integer>  id;

    public SubjectAddRequestTeacher(int teacherid, ArrayList<Integer> id) {
        this.id = new ArrayList<>();
        for(Integer u : id)
            this.id.add(u);
        this.teacherid = teacherid;
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
        this.id = new ArrayList<>();
        for(Integer u : id)
            this.id.add(u);
    }

    @Override
    public String toString(){
        return  "" + reqEnum.SubjectAddRequestTeacher;

    }
}
