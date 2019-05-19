package ServerClasses;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Question implements Serializable {
    private int questionId,quizId,type, ansKey;
    private String QuestionField,option1,option2,option3,option4;

    public Question(int questionId, int quizId, int type, int ansKey, String questionField, String option1, String option2, String option3, String option4) {
        this.questionId = questionId;
        this.quizId = quizId;
        this.type = type;
        this.ansKey = ansKey;
        QuestionField = questionField;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }

    public Question() {
    }
    public  Question(ResultSet rs)
    {
        try {
            this.questionId = rs.getInt(1);
            this.quizId = rs.getInt(3);
            this.type = rs.getInt(9);
            this.ansKey = rs.getInt(8);
            QuestionField =rs.getString(2) ;
            this.option1 = rs.getString(4);
            this.option2 = rs.getString(5);
            this.option3 = rs.getString(6);
            this.option4 =rs.getString(7) ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAnsKey() {
        return ansKey;
    }

    public void setAnsKey(int ansKey) {
        this.ansKey = ansKey;
    }

    public String getQuestionField() {
        return QuestionField;
    }

    public void setQuestionField(String questionField) {
        QuestionField = questionField;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }
}
