package Controllers;

import GUI.Main;
import Request.QuestionFetchRequest;
import ServerClasses.Question;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Timer;

public class quizStudent {

    private ArrayList<Question> questions;
    private ArrayList<questionDisplayContainer> questionDisplayContainers;
    private Button submitButton;
    Timer timer;

    @FXML
    Label quizNameLabel,subjectCodeLabel,maxMarksLabel;

    @FXML
    VBox questionContiner;

    public quizStudent() {
        try {
            Main.oos.writeObject(new QuestionFetchRequest(Main.studentQuiz.getQid()));
            Main.oos.flush();
            questions = (ArrayList<Question>) Main.ois.readObject();
            questionDisplayContainers = new ArrayList<>();
            timer = new Timer();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR,"Error, Try Again", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    public void initialize()
    {
        quizNameLabel.setText(Main.studentQuiz.getQuizName());
        maxMarksLabel.setText(""+Main.studentQuiz.getMaxMarks());
        subjectCodeLabel.setText(""+Main.studentquizSubID);
        for(Question u : questions)
        {
            questionDisplayContainers.add(new questionDisplayContainer(questionContiner,u));
        }
        submitButton = new Button("Submit");
        submitButton.setLayoutX(350);
        submitButton.setPrefHeight(55);
        submitButton.setMinWidth(200);
        submitButton.setMinHeight(55);
        questionContiner.getChildren().add(submitButton);
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Submit the Quiz ?",ButtonType.YES,ButtonType.NO);
                alert.showAndWait();
                if(alert.getResult()==ButtonType.NO)
                    return;
                timer.cancel();
                endQuiz();
            }
        });

    }

    public void endQuiz()
    {
        System.out.println("End Quiz Called");
    }



}
