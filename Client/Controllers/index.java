package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javax.sound.midi.ControllerEventListener;

public  class index  {
    @FXML
    Button LoginButton;
    @FXML
    Button SignUpButton;
    public void loginButtonClicked()
    {
        System.out.println("Login Window Requested...");
    }
    public void  signUpButtnClicked()
    {
        System.out.println("SignUp Window requested...");
    }
}
