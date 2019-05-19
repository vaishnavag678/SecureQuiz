package ServerClasses;

import Request.QuestionAddRequest;
import Constants.BinaryStatus;
import Request.QuizAddRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class QuizAdd {
    private static Connection con = Server.db.getConnection();
    private static PreparedStatement st,st1,st2;
    private static String query1 = "INSERT INTO quiz (`Duration`, `MaxMarks`, `QuizName`) VALUES (?,?,?)";
    private static String query2 = "INSERT INTO `teacher_subject_quiz`(`Teacherid`, `Subid`, `Quizid`, `Active`, `SubName`) VALUES (?,?,?,1,?)";
    private static String  query3 = "SELECT Quizid from quiz ORDER BY Quizid DESC";
    public static String quizAdd(QuizAddRequest req)
    {
        try{
            st = con.prepareStatement(query1);
            st.setInt(1,req.getDuration());
            st.setInt(2,req.getMaxMarks());
            st.setString(3,req.getQuizName());
            if(st.executeUpdate()<=0)
                return "" + BinaryStatus.FAILURE;
            st1 = con.prepareStatement(query3);
            ResultSet rs =st1.executeQuery();
            if(!rs.next())
                return ""+BinaryStatus.FAILURE;
            int qid = rs.getInt(1);
            st2 = con.prepareStatement(query2);
            st2.setInt(1,req.getTeacherId());
            st2.setInt(2,req.getSubjectId());
            st2.setInt(3,qid);
            st2.setString(4,req.getSubName());
            if(st2.executeUpdate()<=0)
                return "" + BinaryStatus.FAILURE;



        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return ""+BinaryStatus.FAILURE;
        }
        return ""+BinaryStatus.SUCCESS;
    }
}
