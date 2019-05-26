package Request;

import Constants.reqEnum;

import java.io.Serializable;

public class ScoreFetchRequest implements Serializable {
    int studentId,qId;

    public ScoreFetchRequest(int studentId, int qId) {
        this.studentId = studentId;
        this.qId = qId;
    }

    public ScoreFetchRequest() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getqId() {
        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
    }
    @Override
    public String toString()
    {
        return  "" + reqEnum.ScoreFetchRequest;
    }
}
