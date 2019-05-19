package Request;
import java.io.Serializable ;
import Constants.reqEnum;

public class SubjectListFetchRequestTeacher implements Serializable{
    private  int teacherid;

    public SubjectListFetchRequestTeacher(int teacherid) {
        this.teacherid = teacherid;
    }

    public SubjectListFetchRequestTeacher() {
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    /*************
     * we have to complete the overrride method here
     * do it accordingly how you actually defined constant and server
     *server banao xd :p
     * @return

     */
    @Override
    public String toString(){
        return ""+reqEnum.SubjectListFetchRequestTeacher;

    }
}
