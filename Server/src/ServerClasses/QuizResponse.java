package ServerClasses;
import Request.QuizResponseRequest;
import Constants.BinaryStatus;
import javafx.util.Pair;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QuizResponse implements Serializable {
    private static Connection con = Server.db.getConnection(); //This can be improved ,if time permits
    private static PreparedStatement st1,st2;
    private static String query1 = "SELECT `AnsKey` FROM `question` WHERE  `Questionid`=?";
    private static String query2 = "INSERT INTO `student_quiz_marks` (`Studentid`, `Quizid`, `Marks`, `Flag`) VALUES (?,?,?,?)";
    public static String saveResponse(QuizResponseRequest req)
    {
            int score =0;
            int worth = req.getMax_martks()/req.getNumOfQuestions();
            try {
                st1 = con.prepareStatement(query1);
                for(Pair<Integer,Integer> u : req.getResponse())
                {
                    int res = u.getValue();
                    int qid = u.getKey();
                    st1.setInt(1,qid);
                    ResultSet rs = st1.executeQuery();
                    if(rs.next())
                    {
                        if(res==rs.getInt(1))//no negative marking
                            score+=worth;
                    }
                    else
                        return ""+BinaryStatus.FAILURE;
                }
                st2 = con.prepareStatement(query2);
                st2.setInt(1,req.getStID());
                st2.setInt(2,req.getQuizID());
                st2.setInt(3,score);
                st2.setInt(4,1);
                if(st2.executeUpdate()<=0)
                    return ""+BinaryStatus.FAILURE;

            }
            catch (Exception e)
            {
                e.printStackTrace();
                return ""+BinaryStatus.FAILURE;
            }
            return "" + BinaryStatus.SUCCESS;
    }

}
