package ServerClasses;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Teacherid implements Serializable {


    private int teacherid;

    public Teacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }
}
