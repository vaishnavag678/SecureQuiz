package Controllers;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class questionInputContainer {
    private TextField questionField,option1, option2,option3,option4,type,ansKey;
    private HBox hbox;

    public questionInputContainer(VBox questionBox) {
        hbox = new HBox();
        hbox.setMinWidth(760);
        hbox.setMinHeight(60);
        hbox.setLayoutX(30);
        questionField = new TextField();
        option1 = new TextField();
        option2 = new TextField();
        option3 = new TextField();
        option4 = new TextField();
        type = new TextField();
        ansKey =new TextField();

        questionField.setPromptText("Enter the question");
        option1.setPromptText("Option 1");
        option2.setPromptText("Option 2");
        option3.setPromptText("Option 3");
        option4.setPromptText("Option 4");
        type.setPromptText("Type");
        ansKey.setPromptText("Answer option");

        questionField.setLayoutX(30);
        questionField.setMinHeight(60);
        questionField.setMinWidth(200);

        option1.setLayoutX(30);
        option1.setMinHeight(60);
        option1.setMinWidth(100);

        option2.setLayoutX(30);
        option2.setMinHeight(60);
        option2.setMinWidth(100);

        option3.setLayoutX(30);
        option3.setMinHeight(60);
        option3.setMinWidth(100);

        option4.setLayoutX(30);
        option4.setMinHeight(60);
        option4.setMinWidth(100);

        type.setLayoutX(30);
        type.setMinHeight(60);
        type.setMinWidth(20);

        ansKey.setLayoutX(30);
        ansKey.setMinHeight(60);
        ansKey.setMinWidth(20);

        hbox.getChildren().add(questionField);
        hbox.getChildren().add(option1);
        hbox.getChildren().add(option2);
        hbox.getChildren().add(option3);
        hbox.getChildren().add(option4);
        hbox.getChildren().add(type);
        hbox.getChildren().add(ansKey);

        questionBox.getChildren().add(hbox);
    }

    public HBox getHbox() {
        return hbox;
    }

    public void setHbox(HBox hbox) {
        this.hbox = hbox;
    }

    public TextField getQuestionField() {
        return questionField;
    }



    public void setQuestionField(TextField questionField) {
        this.questionField = questionField;
    }

    public TextField getOption1() {
        return option1;
    }

    public void setOption1(TextField option1) {
        this.option1 = option1;
    }

    public TextField getOption2() {
        return option2;
    }

    public void setOption2(TextField option2) {
        this.option2 = option2;
    }

    public TextField getOption3() {
        return option3;
    }

    public void setOption3(TextField option3) {
        this.option3 = option3;
    }

    public TextField getOption4() {
        return option4;
    }

    public void setOption4(TextField option4) {
        this.option4 = option4;
    }

    public TextField getType() {
        return type;
    }

    public void setType(TextField type) {
        this.type = type;
    }

    public TextField getAnsKey() {
        return ansKey;
    }

    public void setAnsKey(TextField ansKey) {
        this.ansKey = ansKey;
    }
}
