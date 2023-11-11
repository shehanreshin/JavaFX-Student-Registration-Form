package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationFormStage3Controller implements Initializable {
    @FXML
    private Label lblTitle;
    @FXML
    private Label lblNIC;
    @FXML
    private Label lblMethodOfLearning;

    @FXML
    private JFXTextArea txtReason;
    @FXML
    private JFXTextField txtGuardianContact;
    @FXML
    private JFXTextField txtGuardianName;
    @FXML
    private JFXTextField txtNIC;

    @FXML
    private JFXButton btnWrapItUp;

    @FXML
    private JFXComboBox<String> cmbxMethodOfLearning;

    public void wrapItUp(javafx.event.ActionEvent actionEvent) throws IOException{
        boolean isAnyInputDataInvalid =
                !validateNIC() |
                !validateGuardianName() |
                !validateGuardianContact() |
                !validateReason() |
                !validateMethodOfLearning();

        if (isAnyInputDataInvalid) {
            return;
        }

        /* Continuation logic should come here */
    }

    private boolean validateNIC() {
        Pattern pattern = Pattern.compile("^[0-9]{9,12}[V]?$");
        Matcher matcher = pattern.matcher(txtNIC.getText());

        if (matcher.find() && matcher.group().equals(txtNIC.getText())) {
            return true;
        }

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("Invalid NIC Number");
        alert.setContentText("Please enter a valid NIC Number");
        alert.showAndWait();
        return false;
    }

    private boolean validateGuardianName() {
        Pattern pattern = Pattern.compile("^[a-zA-Z]{3,}$");
        Matcher matcher = pattern.matcher(txtGuardianName.getText());

        if (matcher.find() && matcher.group().equals(txtGuardianName.getText())) {
            return true;
        }

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid Guardian Name");
        alert.setHeaderText(null);
        alert.setContentText("Please enter a valid name");
        alert.showAndWait();
        return false;
    }

    private boolean validateGuardianContact() {
        Pattern pattern = Pattern.compile("^0[0-9]{9}$");
        Matcher matcher = pattern.matcher(txtGuardianContact.getText());

        if (matcher.find() && matcher.group().equals(txtGuardianContact.getText())) {
            return true;
        }

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid Guardian Contact Number");
        alert.setHeaderText(null);
        alert.setContentText("Please enter a valid contact number for the guardian in format 0xxxxxxxxx");
        alert.showAndWait();
        return false;
    }

    private boolean validateReason() {
        if (!txtReason.getText().isEmpty() && txtReason.getText().length() > 60) {
            return true;
        }

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Inadequate Reason");
        alert.setHeaderText(null);
        alert.setContentText("Please tell us a bit more about why you are applying");
        alert.showAndWait();
        return false;
    }

    private boolean validateMethodOfLearning() {
        if (
                !(cmbxMethodOfLearning.getValue() == null)
                && !String.valueOf(cmbxMethodOfLearning.getValue()).equals("Select")
        ) {
            return true;
        }

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Method Of Learning Not Selected");
        alert.setHeaderText(null);
        alert.setContentText("Please select your preferred method of learning");
        alert.showAndWait();
        return false;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbxMethodOfLearning.getItems().add("Select");
        cmbxMethodOfLearning.getItems().add("Online");
        cmbxMethodOfLearning.getItems().add("Physical");
    }
}
