package MainClasses;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Teacherid implements Serializable {

    private int teacherid,subid;

    public Teacherid(int teacherid, int subid) {
        this.teacherid = teacherid;
        this.subid = subid;
    }

    /****************teacherid class contains subid field and teacherid field
     you can handle which teacher added which subject  at a time :)
     * @param rs
     */
    public Teacherid(ResultSet rs)  {

        try {
            this.teacherid=rs.getInt(1);
            this.subid = rs.getInt(2);


        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getTeacherid() {

        return teacherid;
    }

    public void setTeacherid(int teacherid) {

        this.teacherid = teacherid;
    }

    public int getSubid() {

        return subid;
    }

    public void setSubid(int subid) {

        this.subid = subid;
    }
}
