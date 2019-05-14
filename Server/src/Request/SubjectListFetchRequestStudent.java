package Request;
import java.io.Serializable ;

public class SubjectListFetchRequestStudent implements Serializable {

    private String studentid;

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    /*  @Override
    public String toString(){


    }*/
}
