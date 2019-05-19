package ServerClasses;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Database.DataBaseLoader;

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
    /*
    //Testing Teacher Subject Fetch
        SubjectListFetchRequestTeacher req = new SubjectListFetchRequestTeacher(2);
        ArrayList<Integer> list = SubjectListFetchTeacher.fetchSubject(req);
        for(Integer u : list)
        {
            System.out.println(""+u);
        }

     */
    /*
    //Testing SubjectAddStudent
        ArrayList<Subid> list = new ArrayList<>();
        for(int i=0;i<2;i++)
            list.add(new Subid(i+100,i+200,3));
        SubjectAddRequestStudent req = new SubjectAddRequestStudent(list,3);
        System.out.println(SubjectAddStudent.subjectAddStudent(req));

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
