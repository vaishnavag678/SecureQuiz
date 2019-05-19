package ServerClasses;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Request.QuizListFetchRequestStudent;
public class QuizListFetchStudent {
    private static Connection con = Server.db.getConnection();
    private static String query1= "SELECT * FROM `student_teacher_subject` WHERE Studentid=? AND Subid=?";
    private static String query2 = "SELECT * FROM `teacher_subject_quiz` WHERE `Teacherid`=? AND Subid=? AND `Active`=1";
    private static String query3 ="SELECT * FROM `quiz` WHERE `Quizid`=?";
    private static PreparedStatement st1,st2,st3;

    // Returns Array List of active Quizzes for the student with the given subjectId
    //Don't Touch
    public static ArrayList<Quiz> quizFetch(QuizListFetchRequestStudent req)
    {
        ArrayList<Quiz> Qlist = new ArrayList<>();
        try{
            //pehle ye pata karo kis teacher se padtha he
            st1 = con.prepareStatement(query1);
            st1.setInt(1,req.getStudentId());
            st1.setInt(2,req.getSubId());
            ResultSet rs1 = st1.executeQuery();
            // Fir us teacher ne kon si quiz dali iss subject me wo dekho
            st2=con.prepareStatement(query2);
            //st3 ke jariye Qid se quiz fetch karenge
            st3=con.prepareStatement(query3);
            while(rs1.next())
            {
                st2.setInt(1,rs1.getInt(2));
                st2.setInt(2,req.getSubId());
                ResultSet rs2 =st2.executeQuery();
                while (rs2.next())
                {
                    st3.setInt(1,rs2.getInt(3));
                    ResultSet rs3 = st3.executeQuery();
                    if(rs3.next())
                    Qlist.add(new Quiz(rs3));
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return Qlist;

    }


}
