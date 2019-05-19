package ServerClasses;

import Request.SubjectListFetchRequestStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class SubjectListFetchStudent {

    private static Connection con = Server.db.getConnection();
    private static PreparedStatement st;
    private static String query = "SELECT * FROM `student_teacher_subject` WHERE `Studentid`=?";

    public static ArrayList<Subid> fetchSubject(SubjectListFetchRequestStudent req)
    {
        ArrayList<Subid> list=new ArrayList<>();
        try {
            st = con.prepareStatement(query);
            st.setInt(1,req.getStudentid());
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                list.add(new Subid(rs));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

}
