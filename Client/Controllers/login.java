package Controllers;

import Constants.LoginStatus;
import GUI.Main;
import Request.LoginRequest;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ServerClasses.User;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ServerClasses.HashGenerator;

public class login {

    private ObjectInputStream ois=Main.ois;
    private ObjectOutputStream oos=Main.oos;
    private User user;

    @FXML
    Button LoginButton,BackButton;

    @FXML
    TextField Email;

    @FXML
    PasswordField password;

    @FXML
    Label label;

    @FXML
    public  void backButtonClicked()
    {

        System.out.println("Back Button Clicked...");
        Stage primaryStage = (Stage) BackButton.getScene().getWindow();
        Parent root=null;
        try {

            root= FXMLLoader.load(getClass().getResource("../GUI/index.fxml"));
            primaryStage.setTitle("Secure Quiz");
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    public void loginButonClicked()
    {

        LoginRequest req = new LoginRequest(Email.getText().trim(),HashGenerator.getHash(password.getText().trim()));
        try {
            oos.writeObject(req);
            oos.flush();
            user = (User) ois.readObject();
            label.setText(""+user.getUSER_LOGIN_STATUS());
            if(user.getUSER_LOGIN_STATUS().equals(String.valueOf(LoginStatus.SUCCESS)))
            {
                System.out.println("User Login");
                Main.user = user;
                Main.isLogin =true;
                Parent root;
                Stage primarystage = (Stage) LoginButton.getScene().getWindow();
                if(user.getType()==0)
                    root = FXMLLoader.load(getClass().getResource("../GUI/studentDashboard.fxml"));
                else
                    root = FXMLLoader.load(getClass().getResource("../GUI/teacherDashboard.fxml"));
                primarystage.setTitle("DashBoard");
                primarystage.setScene(new Scene(root,800,600));
                primarystage.show();

            }

        }
        catch (Exception e)
        {
            System.out.println("Error in connection");
            label.setText("Try Again");
            e.printStackTrace();
        }

    }

}
