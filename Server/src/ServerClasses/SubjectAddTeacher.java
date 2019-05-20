package ServerClasses;

import Constants.BinaryStatus;
import Request.SubjectAddRequestStudent;
import Request.SubjectAddRequestTeacher;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.*;


public class SubjectAddTeacher implements Serializable {
        //private int teacherid;
        //private int subid;
        private static  String query="INSERT INTO `teacher_subject` (`Teacherid`,`Subid`) VALUES(?,?)";
        /***query added to your database****/

        private static Connection con = Server.db.getConnection();
        private static PreparedStatement st;

        public static String SubjectAddteacher(SubjectAddRequestTeacher req)
        {
            ArrayList<Teacherid> list1 = req.getTeacherid();
            try {
                for(Teacherid u : list1)
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

    public static String addToDatabase(Teacherid u)
    {
        try{
            st = con.prepareStatement(query);
            st.setInt(1,u.getTeacherid());
            st.setInt(2,u.getSubid());
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
