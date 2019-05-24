package GUI;

import ServerClasses.Quiz;
import ServerClasses.User;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Main extends Application {
    public static Socket socket;
    public static ObjectOutputStream oos;
    public static ObjectInputStream ois;
    public static User user;
    public static boolean isLogin=false;
    public static Quiz studentQuiz;
    public static Stage Pstage;
    public static void main(String[] args) {
        try
        {
            socket = new Socket("127.0.0.1",6963);
            System.out.println("Connection Created");
            //Reversing the order causes Deadlock and the project freezes
            //https://stackoverflow.com/questions/54095782/the-program-stops-when-the-objectinputstream-object-is-created
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());


        }
        catch(Exception e)
        {
            //do nothing
            System.out.println(""+e);
        }
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        this.Pstage=primaryStage;
        Parent root=null;
        try {
             root= FXMLLoader.load(getClass().getResource("index.fxml"));
            primaryStage.setTitle("Secure Quiz");
            primaryStage.initStyle(StageStyle.DECORATED);
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
