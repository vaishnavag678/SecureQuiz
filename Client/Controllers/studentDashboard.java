package Controllers;

import GUI.Main;
import ServerClasses.Quiz;
import ServerClasses.Subid;
import ServerClasses.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import Request.SubjectListFetchRequestStudent;
import Request.SubjectAddRequestStudent;
import Constants.*;
import javafx.stage.Stage;
import javafx.util.Pair;
import Request.QuizListFetchRequestStudent;

public class studentDashboard
{
        public static ObjectOutputStream oos = Main.oos;
        public static ObjectInputStream ooi = Main.ois;
        public static User student = Main.user;
        public static boolean islogin = Main.isLogin;
        @FXML
        Label fnameLabel,lnameLabel,welcomeLabel,emailLabel,quizLabel;

        @FXML
        TextField addSubjectTextField;

        @FXML
        Button addSubjectButton,logOutButton;

        @FXML
        VBox subjectBox;

        private ArrayList<Pair<Quiz,Button> > subjects= new  ArrayList<>();//To create buttons dynamically


        @FXML
        public void initialize()
        {
                fnameLabel.setText(student.getFname());
                lnameLabel.setText(student.getLname());
                welcomeLabel.setText("Welcome, "+student.getFname()+" "+student.getLname());
                emailLabel.setText(student.getEmail());
                setSubjectList();


        }

        public void setSubjectList()
        {
                subjectBox.getChildren().clear();
                subjects.clear();
                SubjectListFetchRequestStudent req = new SubjectListFetchRequestStudent(student.getUserid());
                try {
                        oos.writeObject(req);
                        oos.flush();
                        ArrayList<Subid> resp =(ArrayList<Subid>) ooi.readObject();

                        if(resp==null)
                                return;
                        for(Subid u : resp)
                        {

                                QuizListFetchRequestStudent req1 = new QuizListFetchRequestStudent(student.getUserid(),u.getSubid());
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
                                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Do you Want to start the quiz "+quiz.getQuizName() +" of Subject " + u.getSubid(),ButtonType.YES,ButtonType.NO );
                                                alert.showAndWait();
                                                if (alert.getResult()==ButtonType.YES)
                                                {
                                                    Main.studentQuiz=quiz;
                                                    quizLabel.setText(quiz.getQuizName());

                                                    Parent root = null;
                                                    try {
                                                        root = FXMLLoader.load(getClass().getResource("../GUI/quizStudent.fxml"));
                                                        Main.Pstage.setScene(new Scene(root,800,600));
                                                        Main.Pstage.setTitle(""+quiz.getQuizName());
                                                    } catch (IOException e) {
                                                        e.printStackTrace();
                                                    }

                                                }
                                            }
                                        });
                                }
                        }
                        if(subjects.size()==0)
                            quizLabel.setText("No Quizzes for you take rest or try adding some subjects.");


                }
                catch (Exception e)
                {

                        e.printStackTrace();
                }
        }




        public void addSubjectButtonClicked()
        {
            String[] str = addSubjectTextField.getText().trim().split(" ");
            //first split <subid,teachid> pairs with <space> delimiter
            ArrayList<Subid> toadd = new ArrayList<>();
            for(String u : str)
            {
                System.out.println(u);
                //now get subid and teachid
                String[] add = u.split(",");
                if(add.length!=2)
                    continue;
                try {

                    int subid = Integer.parseInt(add[0]);
                    int teachid = Integer.parseInt(add[1]);
                    toadd.add(new Subid(subid,teachid,student.getUserid()));

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
            // Adding Subjects

            if(toadd.size()>0)
            {
                try
                {
                    oos.writeObject(new SubjectAddRequestStudent(toadd,student.getUserid()));
                    oos.flush();
                    //System.out.println("here");
                    String status = (String ) ooi.readObject();
                    System.out.println("" + String.valueOf(status));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            setSubjectList();
        }

        public void logOutButtonClicked() throws IOException
        {
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/index.fxml"));
            Main.isLogin=false;
            Main.user=null;
            Main.Pstage.setTitle("Secure Quiz");
            Main.Pstage.setScene(new Scene(root,800,600));
            System.out.println("User Logout");
            Main.Pstage.show();

        }


}
