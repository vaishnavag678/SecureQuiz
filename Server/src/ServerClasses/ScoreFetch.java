package ServerClasses;

import Constants.BinaryStatus;
import Request.ScoreFetchRequest;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ScoreFetch implements Serializable {
    private static Connection con = Server.db.getConnection();
    private static String query = "SELECT Marks from `student_quiz_marks` WHERE Quizid=? AND Flag=1 AND Studentid=?";
    private  static PreparedStatement st;
    public static String scoreFetch(ScoreFetchRequest req)
    {
        String score=null;
        try {
            st = con.prepareStatement(query);
            st.setInt(1,req.getqId());
            st.setInt(2,req.getStudentId());
            ResultSet rs = st.executeQuery();
            if(!rs.next())
                return ""+BinaryStatus.FAILURE;
            score = String.valueOf(rs.getInt(1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ""+ BinaryStatus.FAILURE;
        }
        return score;
    }

}
