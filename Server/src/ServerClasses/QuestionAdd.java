package ServerClasses;
import Request.QuestionAddRequest;
import sun.plugin2.main.client.DisconnectedExecutionContext;

import java.io.Serializable;
import java.rmi.activation.ActivationGroup_Stub;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import Constants.BinaryStatus;

public class QuestionAdd implements Serializable {
    private static String query="INSERT INTO `question`( `QuestionField`, `Quizid`, `Option1`, `Option2`, `Option3`, `Option4`, `AnsKey`, `Type`) VALUES (?,?,?,?,?,?,?,?)";
    private static Connection con = Server.db.getConnection();
    private static PreparedStatement st;
    public static String questionAdd(QuestionAddRequest req)
    {
        ArrayList<Question> list = req.getQuestions();
        try {
            for(Question u : list)
            {
                if(addToDatabase(u).equals(String.valueOf(BinaryStatus.FAILURE)))
                    return ""+BinaryStatus.FAILURE;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ""+BinaryStatus.FAILURE;
        }
        return ""+BinaryStatus.SUCCESS;
    }
    public static String addToDatabase(Question q)
    {
        try{
            st = con.prepareStatement(query);
            st.setInt(2,q.getQuizId());
            st.setInt(8,q.getType());
            st.setInt(7,q.getAnsKey());
            st.setString(1,q.getQuestionField());
            st.setString(3,q.getOption1());
            st.setString(4,q.getOption2());
            st.setString(5,q.getOption3());
            st.setString(6,q.getOption4());
            if(st.executeUpdate()<=0)
                return "" + BinaryStatus.FAILURE;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ""+BinaryStatus.FAILURE;
        }
        return ""+BinaryStatus.SUCCESS;
    }

}
