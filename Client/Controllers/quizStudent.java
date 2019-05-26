package Controllers;

import Constants.BinaryStatus;
import GUI.Main;
import Request.QuestionFetchRequest;
import Request.QuizResponseRequest;
import ServerClasses.Question;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;


public class quizStudent {

    private ArrayList<Question> questions;
    private ArrayList<questionDisplayContainer> questionDisplayContainers;
    private Button submitButton;
    private int secNow ;
    private Timeline time;

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

        time = new Timeline(
                new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        setTimerDisplay();
                        secNow--;
                        //System.out.println(secNow);
                        if(secNow==0)
                        {
                            setTimerDisplay();
                            timeUp();
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
        time.stop();
        ArrayList<Pair<Integer,Integer>> list= new ArrayList<>();
        for(questionDisplayContainer u : questionDisplayContainers)
        {
            int quesId = u.getQuestionId();
            RadioButton selected =(RadioButton) u.getToggleGroup().getSelectedToggle();
            int key =-1;
            if(selected!=null)
            {
                if(selected.getId().equals("Option 1"))
                    key=1;
                else if(selected.getId().equals("Option 2"))
                    key=2;
                else if(selected.getId().equals("Option 3"))
                    key=3;
                else
                    key =4;
            }
            Pair<Integer,Integer> p = new Pair<>(quesId,key);
            list.add(p);

        }

        QuizResponseRequest req = new QuizResponseRequest(Main.studentQuiz.getQid(),questions.size(),Main.user.getUserid(),list,Main.studentQuiz.getMaxMarks());
        try {
            Main.oos.writeObject(req);
            Main.oos.flush();
            String status = (String) Main.ois.readObject();
            if(status.equals(BinaryStatus.FAILURE))
                throw new Exception("Server side Failure");

            Parent root = FXMLLoader.load(getClass().getResource("../GUI/quizCheckOut.fxml"));
            Main.Pstage.setScene(new Scene(root,800,600));


        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR,"Error Occured , Try Again",ButtonType.OK);
            alert.showAndWait();

        }


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
    public void timeUp()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Time is Up!!",ButtonType.OK);
        endQuiz();
    }

}
