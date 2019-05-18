package Database;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class DataBaseLoader {


    static String user = "root";//user root by default
    static String password = "qwerty123" +
            "";//password for mysql connectio
    private Connection connection;
    private Statement st;

    public DataBaseLoader() {
        try{
            connection = MysqlConnector.connect();
            st = connection.createStatement();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    /*
    Method to close the Database connection.
     */
    public void close()
    {
        try
        {
            st.close();
            connection.close();

        }
        catch (Exception e)
        {
            // Ignored the exceptions
            System.out.println(""+ e);
        }
    }



    /*******************
     * testing ke liye connected not connected
     * @param args
     */
    /*public static void main(String args[]) {
        DataBaseLoader ob=new DataBaseLoader();
        if (ob.connection == null) {
            System.out.println("not connected");
        } else
            System.out.println(" connected");
        String query = "INSERT INTO `teacher_subject`(`Teacherid`, `Subid`) VALUES (2,3) ";
        ob.dbUpdate(query);
    }*/

    public ResultSet dbQuery(String query)
    {
        ResultSet out= null ;
        try {
            out = st.executeQuery(query);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return  out;
    }
    public void dbUpdate(String query)
    {
        try {
            st.executeUpdate(query);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
