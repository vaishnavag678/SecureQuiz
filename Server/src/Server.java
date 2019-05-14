import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import Database.DataBaseLoader;

public class Server {
    public static  DataBaseLoader db = new DataBaseLoader();
    public static void main(String args[])
    {
        ServerSocket serverSocket=null;

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
