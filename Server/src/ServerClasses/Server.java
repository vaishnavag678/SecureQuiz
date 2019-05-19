package ServerClasses;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Database.DataBaseLoader;
import Request.*;
import javafx.util.Pair;

public class Server {
    public static  DataBaseLoader db = new DataBaseLoader();
    public static void main(String args[])
    {
        ServerSocket serverSocket=null;
    /*
        //TYesting Student Subject fetch
        SubjectListFetchRequestStudent req = new SubjectListFetchRequestStudent(2);
        ArrayList<Subid> list = SubjectListFetchStudent.fetchSubject(req);
        for(Subid u : list)
        {
            System.out.println(""+u.getStudentid()+" "+u.getSubid()+" "+u.getTeacherid());
        }


     */
        try {
            serverSocket = new ServerSocket(6963);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
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
