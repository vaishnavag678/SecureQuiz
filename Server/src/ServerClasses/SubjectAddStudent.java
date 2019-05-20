package ServerClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;
import java.io.Serializable ;

import Constants.BinaryStatus;
import Request.SubjectAddRequestStudent;



public class SubjectAddStudent implements Serializable{

    private static  String query="INSERT INTO `student_teacher_subject` (`Studentid`,`Teacherid`,`Subid`) VALUES(?,?,?)";

    private static Connection con = Server.db.getConnection();
    private static PreparedStatement st;


    public static  String subjectAddStudent(SubjectAddRequestStudent req)
    {
        ArrayList<Subid> list1 = req.getSubid(); // ye request se pura array return ho raha yaad rakhna :)
        //ArrayList<Teacherid>list2=req.getTeacherid();
        try {
            for(Subid u : list1)
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
    public static String addToDatabase(Subid u)
    {
        try{
            st = con.prepareStatement(query);
            st.setInt(1,u.getStudentid());
            st.setInt(2,u.getTeacherid());
            st.setInt(3,u.getSubid());
           // st.setInt(2,u.getTeacherid)
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
