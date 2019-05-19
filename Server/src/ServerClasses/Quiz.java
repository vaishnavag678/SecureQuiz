package ServerClasses;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Quiz implements Serializable {
    private int duration,qid,maxMarks;
    String QuizName;

    public Quiz(int duration,int qid,int maxMarks,String name)
    {
        this.duration =duration;
        this.qid = qid;
        this.maxMarks =maxMarks;
        this.QuizName= name;
    }
    public Quiz(ResultSet rs)
    {
        try {
            this.qid = rs.getInt(1);
            this.duration =rs.getInt(2);

            this.maxMarks =rs.getInt(3);
            this.QuizName= rs.getString(4);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Quiz()
    {

    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(int maxMarks) {
        this.maxMarks = maxMarks;
    }

    public String getQuizName() {
        return QuizName;
    }

    public void setQuizName(String quizName) {
        QuizName = quizName;
    }
}
