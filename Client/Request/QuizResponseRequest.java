package Request;


import java.io.Serializable ;
import java.util.*;
import javafx.util.Pair;
import Constants.reqEnum;
public class QuizResponseRequest implements Serializable{
    int quizID,numOfQuestions,stID,max_martks;
    //ArrayList<Integer> response; ye kya hai?? question konsa hai kaise pata chalega??
    ArrayList<Pair<Integer,Integer> >  response; //pehla questionId dusra response

    public QuizResponseRequest() {
        response = new ArrayList<>();
    }

    public QuizResponseRequest(int quizID, int numOfQuestions, int stID, ArrayList<Pair<Integer, Integer>> response,int max_martks) {
        this.quizID = quizID;
        this.numOfQuestions = numOfQuestions;
        this.stID = stID;
        this.max_martks = max_martks;
        this.response = new ArrayList<>();
        for(Pair<Integer,Integer> u:response)
            this.response.add(u);

    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public int getNumOfQuestions() {
        return numOfQuestions;
    }

    public void setNumOfQuestions(int numOfQuestions) {
        this.numOfQuestions = numOfQuestions;
    }

    public int getStID() {
        return stID;
    }

    public void setStID(int stID) {
        this.stID = stID;
    }

    public ArrayList<Pair<Integer, Integer>> getResponse() {
        return response;
    }

    public void setResponse(ArrayList<Pair<Integer, Integer>> response) {
        for(Pair<Integer,Integer> u:response)
            this.response.add(u);
    }

    public int getMax_martks() {
        return max_martks;
    }

    public void setMax_martks(int max_martks) {
        this.max_martks = max_martks;
    }

    @Override
    public String toString()
    {
        return "" + reqEnum.QuizResponseRequest;
    }
}
