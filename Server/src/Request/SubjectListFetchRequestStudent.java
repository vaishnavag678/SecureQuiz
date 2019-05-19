package Request;
import java.io.Serializable ;
import Constants.reqEnum;
public class SubjectListFetchRequestStudent implements Serializable {

    private int studentid;

    public SubjectListFetchRequestStudent(int studentid) {
        this.studentid = studentid;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

      @Override
    public String toString(){
            return ""+ reqEnum.SubjectListFetchRequestStudent;

    }
}
