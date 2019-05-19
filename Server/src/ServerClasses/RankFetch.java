package ServerClasses;
import Constants.BinaryStatus;
import Request.RankFetchRequest;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RankFetch implements Serializable {
    private static Connection con = Server.db.getConnection();
    private static String query = "SELECT Studentid from `student_quiz_marks` WHERE Quizid=? AND Flag=1 ORDER BY Marks DESC";
    private  static PreparedStatement st;
    public static String rankFetch(RankFetchRequest req)
    {
        int rank=0;
        boolean found=false;
        try {
            st = con.prepareStatement(query);
            st.setInt(1,req.getQuizId());
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                rank++;
                if(rs.getInt(1)==req.getStudentId() && (found=true))
                    break;
            }
            if(!found)
                return ""+BinaryStatus.FAILURE;
        } catch (SQLException e) {
            e.printStackTrace();
            return ""+BinaryStatus.FAILURE;
        }
        return String.valueOf(rank);
    }
}
