package Request;

import Constants.reqEnum;

import java.io.Serializable;

public class QuizAddRequest implements Serializable {
    //No use of isActive but still keeping it for future expandability.
    // while saving to the database the active field is kept 1 by default irrespective of the value passed during request.
    // for now, The same will be true for client side, no option will be given to activate or deactivate the quiz, once the quiz is saved it becomnes active or the database admin can change it.
    private int duration,maxMarks,teacherId,subjectId,isActive;
    String QuizName,SubName;

    public QuizAddRequest(int duration, int maxMarks, int teacherId, int subjectId, int isActive, String quizName, String subName) {
        this.duration = duration;
        this.maxMarks = maxMarks;
        this.teacherId = teacherId;
        this.subjectId = subjectId;
        this.isActive = isActive;
        QuizName = quizName;
        SubName = subName;
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

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getQuizName() {
        return QuizName;
    }

    public void setQuizName(String quizName) {
        QuizName = quizName;
    }

    public String getSubName() {
        return SubName;
    }

    public void setSubName(String subName) {
        SubName = subName;
    }

    @Override
    public String toString()
    {
        return ""+ reqEnum.QuizAddRequest;
    }
}
