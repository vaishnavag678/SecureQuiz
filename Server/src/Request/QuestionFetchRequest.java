package Request;

import java.io.Serializable;
import Constants.reqEnum;

public class QuestionFetchRequest implements Serializable {
   private int quizId;

    public QuestionFetchRequest() {
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public QuestionFetchRequest(int quizId) {
        this.quizId = quizId;
    }
    @Override
    public String toString()
    {
        return "" + reqEnum.QuestionFetchRequest;
    }
}
