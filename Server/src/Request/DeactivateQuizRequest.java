package Request;

import java.io.Serializable;
import Constants.reqEnum;

public class DeactivateQuizRequest implements Serializable {
    private int quizId;

    public DeactivateQuizRequest(int quizId) {
        this.quizId = quizId;
    }

    public DeactivateQuizRequest() {
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    @Override
    public String toString()
    {
        return String.valueOf(reqEnum.DeactivateQuizRequest);
    }
}
