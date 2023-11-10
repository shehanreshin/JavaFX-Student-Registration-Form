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

public class RegistrationFormStage2Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label lblTitle;
    @FXML
    private Label lblEducationLevel;
    @FXML
    private Label lblCurrentStatus;
    @FXML
    private Label lblGender;
    @FXML
    private Label lblAddress;

    @FXML
    private JFXTextField txtAddressLine1;
    @FXML
    private JFXTextField txtAddressLine2;
    @FXML
    private JFXTextField txtAddressLine3;

    @FXML
    private JFXButton btnKeepGoing;

    @FXML
    private JFXComboBox<String> cmbxEducationLevel;
    @FXML
    private JFXComboBox<String> cmbxCurrentStatus;
    @FXML
    private JFXComboBox<String> cmbxGender;

    public void keepGoing(javafx.event.ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/asset/fxml/RegistrationFormStage3.fxml"));
        root = loader.load();
        RegistrationFormStage3Controller registrationFormStage3Controller = loader.getController();
        registrationFormStage3Controller.setup();

        scene = new Scene(root);
        scene.getStylesheets()
                .add(this.getClass()
                        .getResource("/asset/css/registration-form-stage3.css")
                        .toExternalForm()
                );

        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void setup() {
        cmbxEducationLevel.getItems().add("Select");
        cmbxEducationLevel.getItems().add("Ordinary Level");
        cmbxEducationLevel.getItems().add("Advanced Level");
        cmbxEducationLevel.getItems().add("Undergraduate");
        cmbxEducationLevel.getItems().add("Graduate");
        cmbxEducationLevel.getItems().add("Masters");
        cmbxEducationLevel.getItems().add("Doctorate");

        cmbxCurrentStatus.getItems().add("Select");
        cmbxCurrentStatus.getItems().add("Student");
        cmbxCurrentStatus.getItems().add("Employed");
        cmbxCurrentStatus.getItems().add("Self-employed");
        cmbxCurrentStatus.getItems().add("Unemployed");

        cmbxGender.getItems().add("Select");
        cmbxGender.getItems().add("Male");
        cmbxGender.getItems().add("Female");
        cmbxGender.getItems().add("Other");
        cmbxGender.getItems().add("Prefer not to say");
    }
}
