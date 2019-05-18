package ServerClasses;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Database.DataBaseLoader;
import Request.*;
public class Server {
    public static  DataBaseLoader db = new DataBaseLoader();
    public static void main(String args[])
    {
        ServerSocket serverSocket=null;

        /*
        //Testing QuizListFetch Student

        QuizListFetchRequestStudent req = new QuizListFetchRequestStudent(1,2);
        ArrayList<Quiz> Qlist = QuizListFetchStudent.quizFetch(req);
        for(Quiz q : Qlist)
        {
            System.out.println(" "+q.getQuizName()+" "+q.getDuration() + " "+q.getMaxMarks()+" "+q.getQid());
        }
        */
        /*
            //Testing QuizListFEtch Teacher
        QuizListFetchRequestTeacher req = new QuizListFetchRequestTeacher(2,3);
        ArrayList<Quiz> Qlist = QuizListFetchTeacher.quizFetch(req);
        for(Quiz q : Qlist)
        {
            System.out.println(" "+q.getQuizName()+" "+q.getDuration() + " "+q.getMaxMarks()+" "+q.getQid());
        }
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
