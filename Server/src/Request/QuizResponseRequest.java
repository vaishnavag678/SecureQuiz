package Request;


import java.io.Serializable ;
import java.util.*;
import javafx.util.Pair;
import Constants.reqEnum;
public class QuizResponseRequest implements Serializable{
    int quizID,numOfQuestions,stID;
    ArrayList<Integer> response;

    public QuizResponseRequest(int quizID, int numOfQuestions, int stID, ArrayList<Integer> response) {
        this.quizID = quizID;
        this.numOfQuestions = numOfQuestions;
        this.stID = stID;
        this.response = response;
    }

    public QuizResponseRequest() {
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

    public ArrayList<Integer> getResponse() {
        return response;
    }

    public void setResponse(ArrayList<Integer> response) {
        this.response = response;
    }

    @Override
    public String toString()
    {
        return "" + reqEnum.QuizResponseRequest;
    }
}
