package Controllers;

import GUI.Main;
import Request.RankFetchRequest;
import Request.ScoreFetchRequest;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class quizCheckOut {

    @FXML
    Label scoreLabel,rankLabel;
    @FXML
    Button backButton;

    @FXML
    public void initialize()
    {
        try{
            ScoreFetchRequest req = new ScoreFetchRequest(Main.user.getUserid(),Main.studentQuiz.getQid());
            Main.oos.writeObject(req);
            Main.oos.flush();
            scoreLabel.setText((String) Main.ois.readObject());
            RankFetchRequest req1 = new RankFetchRequest(Main.user.getUserid(),Main.studentQuiz.getQid());
            Main.oos.writeObject(req1);
            Main.oos.flush();
            rankLabel.setText((String)Main.ois.readObject());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void backButtonClicked()
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/studentDashboard.fxml"));
            Main.Pstage.setTitle("Dashboard");
            Main.Pstage.setScene( new Scene(root,800,600));
            Main.Pstage.show();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
