package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationFormStage3Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private JFXComboBox<String> cmbxBatch;
    @FXML
    private Label lblTitle;
    @FXML
    private Label lblStudentID;
    @FXML
    private JFXTextField txtStudentID;
    @FXML
    private Label lblBatch;
    @FXML
    private JFXTextField txtFirstName;
    @FXML
    private JFXTextField txtLastName;
    @FXML
    private JFXTextField txtDOB;
    @FXML
    private JFXTextField txtContactNumber;
    @FXML
    private JFXTextField txtEmailAddress;
    @FXML
    private JFXButton btnGetStarted;
    @FXML
    private JFXComboBox<String> cmbxEducationLevel;
    @FXML
    private JFXComboBox<String> cmbxCurrentStatus;
    @FXML
    private JFXComboBox<String> cmbxGender;
    @FXML
    private JFXComboBox<String> cmbxMethodOfLearning;

    public void wrapItUp(javafx.event.ActionEvent actionEvent) throws IOException{

    }

    public void setup() {
        cmbxMethodOfLearning.getItems().add("Select");
        cmbxMethodOfLearning.getItems().add("Online");
        cmbxMethodOfLearning.getItems().add("Physical");
    }
}
