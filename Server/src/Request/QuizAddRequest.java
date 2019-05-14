package Request;

import Constants.reqEnum;

import java.io.Serializable;

public class QuizAddRequest implements Serializable {
    private int duration,qid,maxMarks;
    String QuizName;
    public QuizAddRequest(int duration,int qid,int maxMarks,String QuizName)
    {
        this.duration=  duration;
        this.qid = qid;
        this.maxMarks=maxMarks;
        this.QuizName = QuizName;
    }

    public QuizAddRequest() {
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

    @Override
    public String toString()
    {
        return ""+ reqEnum.QuizAddRequest;
    }
}
