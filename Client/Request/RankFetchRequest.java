package Request;


import java.io.Serializable ;
import java.util.*;

import Constants.reqEnum;
import javafx.util.Pair;

public class RankFetchRequest implements Serializable {

    int studentId,quizId;

    public RankFetchRequest() {
    }

    public RankFetchRequest(int studentId, int quizId) {
        this.studentId = studentId;
        this.quizId = quizId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    @Override
    public String toString(){
        return "" + reqEnum.RankFetchRequest;
    }
}
