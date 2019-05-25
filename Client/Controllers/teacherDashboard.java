package Controllers;

import Constants.BinaryStatus;
import GUI.Main;
import Request.*;
import ServerClasses.Quiz;
import ServerClasses.Teacherid;
import ServerClasses.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class teacherDashboard {
    public static ObjectOutputStream oos = Main.oos;
    public static ObjectInputStream ooi = Main.ois;
    public static User teacher = Main.user;
    public static boolean islogin = Main.isLogin;
    //To store Subjects the teacher teaches, to be used during Add Quiz option
    // It is Initialized by setSubjectList Method
    private ArrayList<Integer> subjectsTaught;

    @FXML
    Label fnameLabel,lnameLabel,welcomeLabel,emailLabel,quizLabel;

    @FXML
    TextField addSubjectTextField, subjectCodeTextField, quizDurationTextField, questionNumberTextField;;

    @FXML
    Button addSubjectButton,logOutButton,addQuizButton;

    @FXML
    VBox subjectBox;
    private ArrayList<Pair<Quiz,Button>> subjects= new  ArrayList<>();//To create buttons dynamically


    @FXML
    public void initialize()
    {
        fnameLabel.setText(teacher.getFname());
        lnameLabel.setText(teacher.getLname());
        welcomeLabel.setText("Welcome, Teacher "+teacher.getFname()+" "+teacher.getLname());
        emailLabel.setText(teacher.getEmail());
        setSubjectList();


    }

    public void logOutButtonClicked() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/index.fxml"));
        Main.isLogin=false;
        Main.user=null;
        Main.Pstage.setTitle("Secure Quiz");
        System.out.println("Teacher Logout");
        Main.Pstage.setScene(new Scene(root,800,600));

        Main.Pstage.show();

    }

    public void addSubjectButtonClicked()
    {
        String[] str = addSubjectTextField.getText().trim().split(" ");
        ArrayList<Teacherid> toadd = new ArrayList<>();
        for(String u : str)
        {
            if(u.length()==0)
                continue;
            int subid = Integer.parseInt(u);
            toadd.add(new Teacherid(teacher.getUserid(),subid));

        }
        // Adding Subjects

        if(toadd.size()>0)
        {
            try
            {
                oos.writeObject(new SubjectAddRequestTeacher(toadd,teacher.getUserid()));
                oos.flush();
                //System.out.println("here");
                String status = (String ) ooi.readObject();
                //System.out.println("" + String.valueOf(status));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        addSubjectTextField.setText("");
        setSubjectList();
    }


    public void setSubjectList()
    {
        subjectBox.getChildren().clear();
        subjects.clear();
        SubjectListFetchRequestTeacher req = new SubjectListFetchRequestTeacher(teacher.getUserid());
        try {
            oos.writeObject(req);
            oos.flush();
            ArrayList<Integer> resp =(ArrayList<Integer>) ooi.readObject();
            subjectsTaught = resp;
            //No need to create  new object and copy here, just storing the reference is fine.

            if(resp==null)
                return;
            for(Integer u : resp)
            {

                QuizListFetchRequestTeacher req1 = new QuizListFetchRequestTeacher(teacher.getUserid(),u);
                oos.writeObject(req1);
                ArrayList<Quiz> resp1 = (ArrayList<Quiz>) ooi.readObject();

                for(Quiz quiz : resp1)
                {
                    Button btn = new Button(quiz.getQuizName());
                    subjects.add(new Pair<>(quiz,btn));
                    subjectBox.getChildren().add(btn);
                    btn.setPrefHeight(55);
                    btn.setMinWidth(122);
                    btn.setMaxHeight(55);
                    btn.setLayoutX(38);
                    btn.setPrefWidth(122);
                    btn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Do you Want to Deactivate "+quiz.getQuizName() +" of Subject "+u , ButtonType.YES,ButtonType.NO );
                            alert.showAndWait();
                            if (alert.getResult()==ButtonType.YES)
                            {

                                Parent root = null;
                                try {
                                    DeactivateQuizRequest req1= new DeactivateQuizRequest(quiz.getQid());
                                    oos.writeObject(req1);
                                    String status = (String) ooi.readObject();
                                    if(status.equals(String.valueOf(BinaryStatus.SUCCESS)))
                                    {
                                        Alert success = new Alert(Alert.AlertType.INFORMATION,"SUCCESS",ButtonType.OK);
                                        success.showAndWait();
                                    }
                                    else
                                    {
                                        Alert success = new Alert(Alert.AlertType.ERROR,"TRY AGAIN",ButtonType.OK);
                                        success.showAndWait();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    });
                }
            }
            if(subjects.size()==0)
                quizLabel.setText("No Quizzes for you take rest or try adding some Quizzes.");


        }
        catch (Exception e)
        {

            e.printStackTrace();
        }
    }

    public void addQuizButtonClicked()
    {
        String subcode = subjectCodeTextField.getText().trim();
        String quesno = questionNumberTextField.getText().trim();
        String duration = quizDurationTextField.getText().trim();
        Alert alert;
        if(subcode == "" || quesno == "" || duration == "")
        {
            alert = new Alert(Alert.AlertType.ERROR,"Check Your Input.",ButtonType.OK);
            alert.showAndWait();
            return;
        }
        boolean found=false;
        for(int u : subjectsTaught)
        {
            if(u == Integer.parseInt(subcode))
                found=true;
        }

        if( !found )
        {
            alert = new Alert(Alert.AlertType.ERROR,"You Don't Teach that Subject.",ButtonType.OK);
            alert.showAndWait();
            return;
        }

        Main.quizDuration = Integer.parseInt(duration);
        Main.quizSubId = Integer.parseInt(subcode);
        Main.quizQuesno = Integer.parseInt(quesno);
        alert = new Alert(Alert.AlertType.CONFIRMATION,"Do you want to add a quiz for Subject code: " + subcode + " with Duration: " + duration + " with number of questions: "+ quesno+" ?", ButtonType.YES,ButtonType.NO);
        alert.showAndWait();
        if(alert.getResult()==ButtonType.NO)
            return;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/addQuiz.fxml"));
            Main.Pstage.setTitle("Add Quiz");
            Main.Pstage.setScene(new Scene(root,800,600));
            Main.Pstage.show();

        } catch (IOException e) {
            e.printStackTrace();
            alert = new Alert(Alert.AlertType.ERROR,"Try Again.",ButtonType.OK);
            alert.showAndWait();
            return;
        }



    }


}
