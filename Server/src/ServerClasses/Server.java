package ServerClasses;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import Database.DataBaseLoader;
import Request.*;
public class Server {
    public static  DataBaseLoader db = new DataBaseLoader();
    public static void main(String args[])
    {
        ServerSocket serverSocket=null;
    /*
        //testing userLogin
        LoginRequest req = new LoginRequest("mpsabhijeet@gmail.com","passwd");
        User user = Login.userLogin(req);
        System.out.println(""+user.getEmail()+" "+user.getFname()+" "+user.getLname()+" "+ user.getUserid()+" "+user.getUSER_LOGIN_STATUS()+" "+user.getType());
        */
    /*
        // Testing user Signup
        SignupRequest req = new SignupRequest("Abhijeet","Biswas","mpsabhijeet@gmail.com","pass");
        System.out.println(SignUp.signUp(req));
        req = new SignupRequest("Abhijeet","Biswas","mpsabhijeet10@gmail.com","pass2");
        System.out.println(SignUp.signUp(req));
        */


        try {
            serverSocket = new ServerSocket(6963);
        }
        catch (Exception ex)
        {
            System.out.println("Exception Occured");
        }
        while(true)
        {
            Socket socket=null;
            while(true)
            {
                try {
                    socket = serverSocket.accept();
                    System.out.println("A new Client" + socket.getRemoteSocketAddress().toString() +" Accepted ");
                    Thread t = new Thread(new RequestHandler(socket));
                    t.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
