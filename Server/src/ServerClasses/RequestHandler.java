package ServerClasses;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import Constants.reqEnum;
import Request.*;


public class RequestHandler extends Thread
{

    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    public RequestHandler(Socket socket)
    {
        try {

            this.socket = socket;
            //Reversing the order causes Deadlock and the project freezes
            //https://stackoverflow.com/questions/54095782/the-program-stops-when-the-objectinputstream-object-is-created
            this.oos = new ObjectOutputStream(socket.getOutputStream());
            this.ois = new ObjectInputStream(socket.getInputStream());

        }
        catch (IOException e)
        {
            e.getMessage();
        }
    }

    @Override
    public void run()
    {
        System.out.println("Handling Client: "+socket.getRemoteSocketAddress());
        String client = ""+socket.getRemoteSocketAddress();
        while (true)
        {
            Object inReq = null;
            try{

                try{
                    inReq = ois.readObject();
                }
                catch (EOFException e)
                {
                    System.out.println(client + " Disconnected");
                    break;
                }
                String identifier = inReq.toString();
                if(identifier.equals(String.valueOf(reqEnum.LoginRequest)))
                {
                    LoginRequest req = (LoginRequest ) inReq;
                    oos.writeObject(Login.userLogin(req));
                    oos.flush();
                }
                if(identifier.equals(String.valueOf(reqEnum.SignupRequest)))
                {
                    System.out.println(reqEnum.SignupRequest);
                    SignupRequest req = (SignupRequest) inReq;
                    oos.writeObject(SignUp.signUp(req));
                    oos.flush();
                }
                if(identifier.equals(String.valueOf(reqEnum.SubjectAddRequestStudent)))
                {
                    System.out.println(reqEnum.SubjectAddRequestStudent);
                    SubjectAddRequestStudent req = (SubjectAddRequestStudent ) inReq;
                    oos.writeObject(SubjectAddStudent.subjectAddStudent(req));
                    oos.flush();
                }
                if(identifier.equals(String.valueOf(reqEnum.SubjectAddRequestTeacher)))
                {
                    System.out.println(reqEnum.SubjectAddRequestTeacher);
                    SubjectAddRequestTeacher req = (SubjectAddRequestTeacher ) inReq;
                    oos.writeObject(SubjectAddTeacher.SubjectAddteacher(req));
                    oos.flush();
                }
                if(identifier.equals(String.valueOf(reqEnum.QuizAddRequest)))
                {
                    System.out.println(reqEnum.QuizAddRequest);
                    QuizAddRequest req = (QuizAddRequest ) inReq;
                    oos.writeObject(QuizAdd.quizAdd(req));
                    oos.flush();
                }
                if(identifier.equals(String.valueOf(reqEnum.SubjectListFetchRequestStudent)))
                {
                    System.out.println(reqEnum.SubjectListFetchRequestStudent);
                    SubjectListFetchRequestStudent req = (SubjectListFetchRequestStudent ) inReq;
                    oos.writeObject(ServerClasses.SubjectListFetchStudent.fetchSubject(req));
                    oos.flush();
                }
                if(identifier.equals(String.valueOf(reqEnum.SubjectListFetchRequestTeacher)))
                {
                    System.out.println(reqEnum.SubjectListFetchRequestTeacher);
                    SubjectListFetchRequestTeacher req = (SubjectListFetchRequestTeacher ) inReq;
                    oos.writeObject(ServerClasses.SubjectListFetchTeacher.fetchSubject(req));
                    oos.flush();
                }
                if(identifier.equals(String.valueOf(reqEnum.QuizListFetchRequestTeacher)))
                {
                    System.out.println(String.valueOf(reqEnum.QuizListFetchRequestTeacher));
                    QuizListFetchRequestTeacher req = (QuizListFetchRequestTeacher ) inReq;
                    oos.writeObject(ServerClasses.QuizListFetchTeacher.quizFetch(req));
                    oos.flush();
                }
                if(identifier.equals(String.valueOf(reqEnum.QuizListFetchRequestStudent)))
                {
                    System.out.println(reqEnum.QuizListFetchRequestStudent);
                    QuizListFetchRequestStudent req = (QuizListFetchRequestStudent ) inReq;
                    oos.writeObject(ServerClasses.QuizListFetchStudent.quizFetch(req));
                    oos.flush();
                }
                if(identifier.equals(String.valueOf(reqEnum.ScoreFetchRequest)))
                {
                    System.out.println(reqEnum.ScoreFetchRequest);
                    ScoreFetchRequest req = (ScoreFetchRequest ) inReq;
                    oos.writeObject(ServerClasses.ScoreFetch.scoreFetch(req));
                    oos.flush();
                }
                if(identifier.equals(String.valueOf(reqEnum.QuizResponseRequest)))
                {
                    System.out.println(reqEnum.QuizResponseRequest);
                    QuizResponseRequest req = (QuizResponseRequest ) inReq;
                    oos.writeObject(ServerClasses.QuizResponse.saveResponse(req));
                    oos.flush();
                }
                if(identifier.equals(String.valueOf(reqEnum.RankFetchRequest)))
                {
                    RankFetchRequest req = (RankFetchRequest ) inReq;
                    oos.writeObject(ServerClasses.RankFetch.rankFetch(req));
                    oos.flush();
                }
                if(identifier.equals(String.valueOf(reqEnum.QuestionFetchRequest)))
                {
                    QuestionFetchRequest req = (QuestionFetchRequest ) inReq;
                    oos.writeObject(ServerClasses.QuestionFetch.questionFetch(req));
                    oos.flush();
                }
                if(identifier.equals(String.valueOf(reqEnum.QuestionAddRequest)))
                {
                    QuestionAddRequest req = (QuestionAddRequest ) inReq;
                    oos.writeObject(ServerClasses.QuestionAdd.questionAdd(req));
                    oos.flush();
                }
                if(identifier.equals(String.valueOf(reqEnum.DeactivateQuizRequest)))
                {
                    DeactivateQuizRequest req = (DeactivateQuizRequest) inReq;
                    oos.writeObject(ServerClasses.DeactivateQuiz.deactivate(req));
                    oos.flush();
                }




            }
            catch (Exception e){
                e.printStackTrace();
                System.out.println(client + " Disconnected");
                break;
            }

        }
    }

}
