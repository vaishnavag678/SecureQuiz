package ServerClasses;

import Request.SubjectListFetchRequestTeacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectListFetchTeacher {
     private static Connection con = Server.db.getConnection();
     private static PreparedStatement st;
     private static String query = "SELECT Subid FROM `teacher_subject` WHERE `Teacherid`=?";
     public static ArrayList<Integer> fetchSubject(SubjectListFetchRequestTeacher req)
     {
         ArrayList<Integer> list = new ArrayList<>();
         try {
             st = con.prepareStatement(query);
             st.setInt(1,req.getTeacherid());
             ResultSet rs = st.executeQuery();
             while(rs.next())
             {
                 list.add(new Integer(rs.getInt(1)));
             }
         }
         catch (SQLException e)
         {
             e.printStackTrace();
         }
         return list;
     }
}
