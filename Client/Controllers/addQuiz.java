package Controllers;

import Constants.BinaryStatus;
import GUI.Main;
import Request.QuestionAddRequest;
import Request.QuizAddRequest;
import Request.QuizListFetchRequestTeacher;
import ServerClasses.Question;
import ServerClasses.Quiz;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;


public class addQuiz {

    private ArrayList<questionInputContainer> containers = new ArrayList<>();

    @FXML
    Label subjectCodeLabel;


    @FXML
    TextField quizNameTextField,maxMarksTextField;

    @FXML
    Button backButton,addButton;

    @FXML
    VBox questionBox; // container for dynamically creadted GUI components

    @FXML
    public void initialize()
    {
        subjectCodeLabel.setText(""+ Main.quizSubId);

        for(int i=0;i<Main.quizQuesno;i++)
        {
            containers.add( new questionInputContainer(questionBox) );

        }

    }

    @FXML
    public void backButtonClicked()
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/teacherDashboard.fxml"));
            Main.Pstage.setTitle("Dashboard");
            Main.Pstage.setScene( new Scene(root,800,600));
            Main.Pstage.show();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void addButtonClicked()
    {
        try {
            QuizAddRequest quizAddRequest = new QuizAddRequest(Main.quizDuration,Integer.parseInt(maxMarksTextField.getText().trim()),Main.user.getUserid(),Main.quizSubId,1,quizNameTextField.getText().trim()," ");
            Main.oos.writeObject(quizAddRequest);
            String status = (String ) Main.ois.readObject();
            if(status.equals(String.valueOf(BinaryStatus.FAILURE)))
            {
                Alert alert = new Alert(Alert.AlertType.ERROR,"Error Ocuured ,Try Again ",ButtonType.OK);
                alert.showAndWait();
                return;
            }
            QuizListFetchRequestTeacher req = new QuizListFetchRequestTeacher(Main.user.getUserid(),Main.quizSubId);
            Main.oos.writeObject(req);
            Main.oos.flush();
            ArrayList<Quiz> list = (ArrayList<Quiz>) Main.ois.readObject();
            int qId=-1;
            for(Quiz quiz : list)
            {
                if(quiz.getQuizName().equals(quizNameTextField.getText().trim()) && quiz.getDuration()==Main.quizDuration && quiz.getMaxMarks()==Integer.parseInt(maxMarksTextField.getText().trim()))
                {
                    qId=quiz.getQid();
                }
            }
            if(qId==-1)
            {
                throw new Exception("Quiz Was Not Added");
            }

            ArrayList<Question> list1 = new ArrayList<>();
            for(questionInputContainer u : containers )
            {
                int type = Integer.parseInt(u.getType().getText().trim());
                int ansKey = Integer.parseInt(u.getAnsKey().getText().trim());
                String questionField = u.getQuestionField().getText().trim();
                String option1 = u.getOption1().getText().trim();
                String option2 = u.getOption2().getText().trim();
                String option3 = u.getOption3().getText().trim();
                String option4 = u.getOption4().getText().trim();

                Question question = new Question(0,qId,type,ansKey,questionField,option1,option2,option3,option4);
                list1.add(question);
            }

            QuestionAddRequest questionAddRequest = new QuestionAddRequest(list1);
            Main.oos.writeObject(questionAddRequest);
            Main.oos.flush();
            String result = (String ) Main.ois.readObject();
            if(result.equals(BinaryStatus.FAILURE))
            {
                throw new Exception("Could not add questions");
            }

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Done ,The quiz is Active Now ",ButtonType.OK);
            alert.showAndWait();
            backButtonClicked();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR,"Error Ocuured ,Try Again ",ButtonType.OK);
            alert.showAndWait();
        }
    }
}
