package ServerClasses;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Request.QuizListFetchRequestTeacher;

public class QuizListFetchTeacher implements Serializable {
    private static Connection con = Server.db.getConnection();
    private static String Query1 = "SELECT * FROM `teacher_subject_quiz` WHERE `Teacherid`=? AND Subid=?";
    private static String Query2 = "SELECT * FROM `quiz` WHERE `Quizid`=?";
    private static PreparedStatement st1,st2;
    public static ArrayList<Quiz> quizFetch(QuizListFetchRequestTeacher req)
    {
        ArrayList<Quiz> Qlist = new ArrayList<>();
        try {
            st1 = con.prepareStatement(Query1);
            st2 = con.prepareStatement(Query2);
            st1.setInt(1,req.getTeacherID());
            st1.setInt(2,req.getSubjectID());
            ResultSet rs1 = st1.executeQuery();
            while(rs1.next())
            {
                int qID = rs1.getInt(3);
                st2.setInt(1,qID);
                ResultSet rs2 = st2.executeQuery();
                if(rs2.next())
                    Qlist.add(new Quiz(rs2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Qlist;
    }

}
