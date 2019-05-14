package Request;

import Constants.reqEnum;
import java.io.Serializable;

public class QuizListFetchRequestStudent implements Serializable {
    private int StudentId,TeacherId,SubId;

    public QuizListFetchRequestStudent(int studentId, int teacherId, int subId) {
        StudentId = studentId;
        TeacherId = teacherId;
        SubId = subId;
    }

    public QuizListFetchRequestStudent() {
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public int getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(int teacherId) {
        TeacherId = teacherId;
    }

    public int getSubId() {
        return SubId;
    }

    public void setSubId(int subId) {
        SubId = subId;
    }

    @Override
    public  String toString()
    {
        return  "" +  reqEnum.QuizListFetchRequestStudent;
    }
}
