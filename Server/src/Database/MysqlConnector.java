package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/************yaha class
 * database ko connect karegi mysql ko program se
 *
 */

public class MysqlConnector {

    /***************
     * ye method data base
     * Connection type ka object bhejegi
     * yadi khali hua to null bhejjegi :p
     */


    public static Connection connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/squiz_database", DataBaseLoader.user, DataBaseLoader.password);

            /************database class ka user password use kar lliye hai yaha hum
             * **********/
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
