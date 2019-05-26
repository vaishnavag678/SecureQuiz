package Controllers;

import GUI.Main;
import Request.QuestionFetchRequest;
import ServerClasses.Question;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;


public class quizStudent {

    private ArrayList<Question> questions;
    private ArrayList<questionDisplayContainer> questionDisplayContainers;
    private Button submitButton;
    int secNow ;

    @FXML
    Label quizNameLabel,subjectCodeLabel,maxMarksLabel,hrLabel,minLabel,secLabel;

    @FXML
    VBox questionContiner;


    public quizStudent() {
        try {
            Main.oos.writeObject(new QuestionFetchRequest(Main.studentQuiz.getQid()));
            Main.oos.flush();
            questions = (ArrayList<Question>) Main.ois.readObject();
            questionDisplayContainers = new ArrayList<>();
            secNow = Main.studentQuiz.getDuration()*60;



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
        Collections.shuffle(questions);
        for(Question u : questions)
        {
            questionDisplayContainers.add(new questionDisplayContainer(questionContiner,u));
        }

        Timeline time = new Timeline(
                new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        setTimerDisplay();
                        secNow--;
                        System.out.println(secNow);
                        if(secNow==0)
                        {
                            setTimerDisplay();
                            endQuiz();
                        }
                    }
                })
        );
        time.setCycleCount(secNow);
        time.playFromStart();









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
                endQuiz();
            }
        });

    }

    public void endQuiz()
    {
        System.out.println("End Quiz Called");
        
    }

    public void setTimerDisplay()
    {


        int hours = secNow / 3600;
        int secondsLeft = secNow - hours * 3600;
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;

        String hr = "",min="",sec = "";
        if (hours < 10)
            hr += "0";
        hr += hours + ":";

        if (minutes < 10)
            min += "0";
        min += minutes + ":";

        if (seconds < 10)
            sec += "0";
        sec += seconds ;


        secLabel.setText(sec);
        minLabel.setText(min);
        hrLabel.setText(hr);


    }


}
