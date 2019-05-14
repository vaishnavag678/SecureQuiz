package Request;


import java.io.Serializable ;
import java.util.*;
import javafx.util.Pair;
public class SubjectAddRequestTeacher implements Serializable {

    private String teacherid;
    ArrayList<Integer>  id=new ArrayList<Integer>(1000);

    public SubjectAddRequestTeacher(String teacherid, ArrayList<Integer> id) {
        this.teacherid = teacherid;
        this.id = id;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }
       /*  @Override
    public String toString(){


    }*/
}
