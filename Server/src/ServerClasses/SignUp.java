package ServerClasses;
import Request.SignupRequest;
import Constants.SignUpStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignUp {
    private static String query = "INSERT INTO `users`( `Fname`, `Lname`, `Email`,  `Pass`) VALUES (?,?,?,?)";
    private static Connection con = Server.db.getConnection();
    private static PreparedStatement st = null;
    private static String check =  "SELECT * FROM users WHERE Email=?";

    public static String signUp(SignupRequest req)
    {
        try {
            st = con.prepareStatement(check);
            boolean found = false;
            st.setString(1, req.getEmail());
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                found = true;
                break;
            }
            if(found)
                return String.valueOf(SignUpStatus.EMAIL_ALREADY_EXISTS);
            st = con.prepareStatement(query);
            st.setString(1,req.getFname());
            st.setString(2,req.getLname());
            st.setString(3,req.getEmail());
            st.setString(4,req.getPassword());
            if(st.executeUpdate()>0)
                return ""+SignUpStatus.SUCCESS;
            return "" + SignUpStatus.FAILURE;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return String.valueOf(SignUpStatus.FAILURE);
    }

}
