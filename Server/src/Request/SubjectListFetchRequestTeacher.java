package Request;
import java.io.Serializable ;


public class SubjectListFetchRequestTeacher implements Serializable{
    private  String teacherid;

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    /*************
     * we have to complete the overrride method here
     * do it accordingly how you actually defined constant and server
     *server banao xd :p
     * @return

     */
  /*  @Override
    public String toString(){


    }*/
}
