package Request;


import java.io.Serializable ;
import java.util.*;

import Constants.reqEnum;
import javafx.util.Pair;

public class RankFetchRequest implements Serializable {

    private String studentid;
    private String quizid;

    public RankFetchRequest(String studentid, String quizid) {
        this.studentid = studentid;
        this.quizid = quizid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getQuizid() {
        return quizid;
    }

    public void setQuizid(String quizid) {
        this.quizid = quizid;
    }
    @Override
    public String toString(){
        return "" + reqEnum.RankFetchRequest;
    }
}
