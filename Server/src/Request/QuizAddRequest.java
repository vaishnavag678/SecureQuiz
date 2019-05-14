package Request;

import Constants.reqEnum;

import java.io.Serializable;

public class QuizAddRequest implements Serializable {
    private int duration,maxMarks;
    String QuizName;
    public QuizAddRequest(int duration,int maxMarks,String QuizName)
    {
        this.duration=  duration;
        //this.qid = qid;
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
