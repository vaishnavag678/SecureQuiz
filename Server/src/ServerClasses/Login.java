package ServerClasses;
import Constants.LoginStatus;
import Request.LoginRequest;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login implements Serializable{
    private static String query;
   // private static String query2;
    private static Connection con;
    private static PreparedStatement st;
    static {
        query = "Select * from users where Email=? ";
        con = Server.db.getConnection();
    }
    public static User userLogin(LoginRequest req)
    {

        User user = new User();
        try {

            st = con.prepareStatement(query);
            st.setString(1,req.getEmail());
            ResultSet rs = st.executeQuery();
            boolean found = false;
            while (rs.next())
            {
                found = true;
                if(rs.getString(6).equals(req.getPassword()))
                {
                    System.out.println("LOGIN REQUEST FOR USER :: User ID "+rs.getInt(1));
                    user.setUserid(rs.getInt(1));
                    user.setEmail(rs.getString(4));
                    user.setFname(rs.getString(2));
                    user.setLname(rs.getString(3));
                    user.setUSER_LOGIN_STATUS(""+LoginStatus.SUCCESS);
                    user.setType(rs.getInt(5));
                    return user;
                }
            }
            if(found)
                user.setUSER_LOGIN_STATUS(""+LoginStatus.WRONG_CREDENTIALS);
            return user;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return user;

    }

}
