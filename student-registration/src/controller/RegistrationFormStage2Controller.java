package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationFormStage2Controller implements Initializable {
    private Stage stage;
    private Scene scene;

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

    public void keepGoing(javafx.event.ActionEvent actionEvent) throws IOException {
        boolean isAnyInputDataInvalid =
                !validateEducationLevel() |
                !validateCurrentStatus() |
                !validateGender() |
                !validateAddress();

        if (isAnyInputDataInvalid) {
            return;
        }

        scene = new Scene(FXMLLoader.load(getClass().getResource("/asset/fxml/RegistrationFormStage3.fxml")));
        scene.getStylesheets()
                .add(this.getClass()
                        .getResource("/asset/css/registration-form-stage3.css")
                        .toExternalForm()
                );

        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public boolean validateEducationLevel() {
        if (
                !(cmbxEducationLevel.getValue() == null)
                && !String.valueOf(cmbxEducationLevel.getValue()).equals("Select")
        ) {
            return true;
        }

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Education Level Not Selected");
        alert.setHeaderText(null);
        alert.setContentText("Please select your education level");
        alert.showAndWait();
        return false;
    }

    public boolean validateCurrentStatus() {
        if (
                !(cmbxCurrentStatus.getValue() == null)
                && !String.valueOf(cmbxCurrentStatus.getValue()).equals("Select")
        ) {
            return true;
        }

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Current Status Not Selected");
        alert.setHeaderText(null);
        alert.setContentText("Please select your current status");
        alert.showAndWait();
        return false;
    }

    public boolean validateGender() {
        if (
                !(cmbxGender.getValue() == null)
                && !String.valueOf(cmbxGender.getValue()).equals("Select")
        ) {
            return true;
        }

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Gender Not Selected");
        alert.setHeaderText(null);
        alert.setContentText("Please select your gender");
        alert.showAndWait();
        return false;
    }

    public boolean validateAddress() {
        boolean isValidAddress =
                !txtAddressLine1.getText().isEmpty() &&
                !txtAddressLine2.getText().isEmpty() &&
                !txtAddressLine3.getText().isEmpty() ;

        if (isValidAddress) {
            return true;
        }

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid Address");
        alert.setHeaderText(null);
        alert.setContentText("Please enter a valid address");
        alert.showAndWait();
        return false;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
