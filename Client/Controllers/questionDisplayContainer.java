package Controllers;

import ServerClasses.Question;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class questionDisplayContainer {
    private RadioButton op1,op2,op3,op4;
    private Label questionField;
    private VBox vBox;
    private ToggleGroup toggleGroup;
    private int questionId;

    public questionDisplayContainer(VBox container, Question question) {

        this.vBox = new VBox();
        this.vBox.setMinWidth(800);
        this.vBox.setLayoutX(16);
        questionField = new Label(question.getQuestionField());
        questionField.setLayoutX(16);
        questionField.setMinWidth(Region.USE_COMPUTED_SIZE);
        questionField.setMinHeight(Region.USE_COMPUTED_SIZE);
        questionField.setWrapText(true);

        op1 = new RadioButton(question.getOption1());
        op2 = new RadioButton(question.getOption2());
        op3 = new RadioButton(question.getOption3());
        op4 = new RadioButton(question.getOption4());

        op1.setLayoutX(16);
        op2.setLayoutX(16);
        op3.setLayoutX(16);
        op4.setLayoutX(16);

        op1.setId("Option 1");
        op2.setId("Option 2");
        op3.setId("Option 3");
        op4.setId("Option 4");


        toggleGroup = new ToggleGroup();
        op1.setToggleGroup(toggleGroup);
        op2.setToggleGroup(toggleGroup);
        op3.setToggleGroup(toggleGroup);
        op4.setToggleGroup(toggleGroup);

        Region padding1 = new Region();
        padding1.setMinHeight(20);
        padding1.setMinWidth(800);

        this.vBox.getChildren().add(questionField);
        vBox.getChildren().add(padding1);
        this.vBox.getChildren().add(op1);
        this.vBox.getChildren().add(op2);
        if(question.getType()==1)
        this.vBox.getChildren().add(op3);
        if(question.getType()==1)
        this.vBox.getChildren().add(op4);
        Region padding2 = new Region();
        padding2.setMinHeight(20);
        padding2.setMinWidth(800);
        vBox.getChildren().add(padding2);

        container.getChildren().add(vBox);

        this.questionId = question.getQuestionId();


    }

    public RadioButton getOp1() {
        return op1;
    }

    public void setOp1(RadioButton op1) {
        this.op1 = op1;
    }

    public RadioButton getOp2() {
        return op2;
    }

    public void setOp2(RadioButton op2) {
        this.op2 = op2;
    }

    public RadioButton getOp3() {
        return op3;
    }

    public void setOp3(RadioButton op3) {
        this.op3 = op3;
    }

    public RadioButton getOp4() {
        return op4;
    }

    public void setOp4(RadioButton op4) {
        this.op4 = op4;
    }

    public Label getQuestionField() {
        return questionField;
    }

    public void setQuestionField(Label questionField) {
        this.questionField = questionField;
    }

    public VBox getvBox() {
        return vBox;
    }

    public void setvBox(VBox vBox) {
        this.vBox = vBox;
    }

    public ToggleGroup getToggleGroup() {
        return toggleGroup;
    }

    public void setToggleGroup(ToggleGroup toggleGroup) {
        this.toggleGroup = toggleGroup;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
