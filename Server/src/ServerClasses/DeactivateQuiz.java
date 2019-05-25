package ServerClasses;

import Request.DeactivateQuizRequest;
import Constants.BinaryStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeactivateQuiz {
    private static String query = "UPDATE `teacher_subject_quiz` SET `Active`=0 WHERE `Quizid`=?";
    private static PreparedStatement st;
    private static Connection con = Server.db.getConnection();
    public static String deactivate(DeactivateQuizRequest req)
    {
        try {
            st= con.prepareStatement(query);
            st.setInt(1,req.getQuizId());
            if(st.executeUpdate()<=0)
                return String.valueOf(BinaryStatus.FAILURE);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return String.valueOf(BinaryStatus.FAILURE);
        }
        return String.valueOf(BinaryStatus.SUCCESS);
    }

}
