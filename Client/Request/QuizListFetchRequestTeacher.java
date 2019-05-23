package Request;

import java.io.Serializable;
import Constants.reqEnum;

public class QuizListFetchRequestTeacher implements Serializable {

    int TeacherID,SubjectID;

    public QuizListFetchRequestTeacher(int teacherID, int subjectID) {
        TeacherID = teacherID;
        SubjectID = subjectID;
    }

    public QuizListFetchRequestTeacher() {
    }

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int teacherID) {
        TeacherID = teacherID;
    }

    public int getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(int subjectID) {
        SubjectID = subjectID;
    }

    @Override
    public String toString()
    {
        return "" + reqEnum.QuizListFetchRequestTeacher;
    }
}
