package Controllers;

import GUI.Main;
import Request.SignupRequest;
import ServerClasses.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class signup {

    private ObjectInputStream ois= Main.ois;
    private ObjectOutputStream oos=Main.oos;

    @FXML
    Button SignUpButton,BackButton;

    @FXML
    TextField fname,lname,Email;

    @FXML
    PasswordField password;

    @FXML
    Label label;


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

    public void signUpButtonClicked()
    {
        System.out.println("SignUp Button Clicked...");
        SignupRequest req = new SignupRequest(fname.getText().trim(),lname.getText().trim(),Email.getText().trim(),password.getText().trim());
        try {
            oos.writeObject(req);
            oos.flush();
            String status = (String) ois.readObject();
            label.setText(String.valueOf(status));
        }
        catch (Exception e)
        {
            System.out.println("Error in connection");
            label.setText("Try Again");
            e.printStackTrace();
        }
    }

}
