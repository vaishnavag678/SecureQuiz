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
        //Testing RankFetch
        ArrayList<Pair<Integer,Integer>> list = new ArrayList<>();
        list.add(new Pair<>(9,1));
        list.add(new Pair<>(10,1));
        list.add(new Pair<>(11,1));
        list.add(new Pair<>(12,1));
        QuizResponseRequest req = new QuizResponseRequest(1,4,1,list,16);
        System.out.println(QuizResponse.saveResponse(req));


        ScoreFetchRequest r = new ScoreFetchRequest(20,1);
        System.out.println(ScoreFetch.scoreFetch(r));
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
