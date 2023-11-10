package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationFormStage1Controller {
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

    public void getStarted(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/asset/fxml/RegistrationFormStage2.fxml"));
        root = loader.load();
        RegistrationFormStage2Controller registrationFormStage2Controller = loader.getController();
        registrationFormStage2Controller.setup();

        scene = new Scene(root);
        scene.getStylesheets()
                .add(this.getClass()
                        .getResource("/asset/css/registration-form-stage2.css")
                        .toExternalForm()
                );

        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public String generateStudentId() {
        /* Didn't add anything here since the assignment stated only to make
         * the front-end */
        return "031";
    }

    public void setup() {
        cmbxBatch.getItems().add("Select");
        cmbxBatch.getItems().add("B104");
        cmbxBatch.getItems().add("B105");
        cmbxBatch.getItems().add("B106");
        cmbxBatch.getItems().add("B107");
        txtStudentID.setText(generateStudentId());
    }
}