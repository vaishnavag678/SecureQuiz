package Request;

import java.io.Serializable;
import java.util.ArrayList;

import Constants.reqEnum;
import ServerClasses.Question;

public class QuestionAddRequest implements Serializable {
    private ArrayList<Question> questions;

    public QuestionAddRequest() {
        questions = new ArrayList<>();
    }

    public QuestionAddRequest(ArrayList<Question> questions) {
        this.questions = new ArrayList<>();
        for(Question u : questions) // We have to actually make a copy of the list, previously we were just taking reference of the list
            this.questions.add(u);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        for(Question u : questions)
            this.questions.add(u);
    }

    @Override
    public String toString()
    {
        return ""+reqEnum.QuestionAddRequest;
    }
}
