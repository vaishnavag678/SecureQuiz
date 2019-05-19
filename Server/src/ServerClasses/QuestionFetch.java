package ServerClasses;
import Request.QuestionFetchRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class QuestionFetch {
    private static Connection con = Server.db.getConnection();
    private static String Query="SELECT * FROM `question` WHERE `Quizid`=?";
    private static PreparedStatement st;
    public static ArrayList<Question> questionFetch(QuestionFetchRequest req)
    {
        ArrayList<Question> queslist = new ArrayList<>();
        try {
            st = con.prepareStatement(Query);
            st.setInt(1,req.getQuizId());
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                queslist.add(new Question(rs));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return queslist;
    }
}
