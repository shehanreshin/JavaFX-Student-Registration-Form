package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.xml.validation.Validator;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationFormStage1Controller implements Initializable {
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
        boolean isAnyInputDataInvalid = !validateEmail() |
                !validateFirstName() |
                !validateLastName() |
                !validateDOB() |
                !validateContactNumber() |
                !validateBatch();

        if (isAnyInputDataInvalid) {
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/asset/fxml/RegistrationFormStage2.fxml"));
        root = loader.load();
        RegistrationFormStage2Controller registrationFormStage2Controller = loader.getController();

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

    private boolean validateEmail() {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._][a-zA-Z0-9._]*@[a-zA-Z0-9._]+([.][a-zA-Z]+)+$");
        Matcher matcher = pattern.matcher(txtEmailAddress.getText());

        if (matcher.find() && matcher.group().equals(txtEmailAddress.getText())) {
            return true;
        }

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid Email");
        alert.setHeaderText(null);
        alert.setContentText("Please enter a valid email");
        alert.showAndWait();
        return false;
    }

    private boolean validateFirstName() {
        Pattern pattern = Pattern.compile("^[a-zA-Z]{5,}$");
        Matcher matcher = pattern.matcher(txtFirstName.getText());

        if (matcher.find() && matcher.group().equals(txtFirstName.getText())) {
            return true;
        }

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid First Name");
        alert.setHeaderText(null);
        alert.setContentText("Please enter a valid name");
        alert.showAndWait();
        return false;
    }

    private boolean validateLastName() {
        Pattern pattern = Pattern.compile("^[a-zA-Z]{5,}$");
        Matcher matcher = pattern.matcher(txtLastName.getText());

        if (matcher.find() && matcher.group().equals(txtLastName.getText())) {
            return true;
        }

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid Last Name");
        alert.setHeaderText(null);
        alert.setContentText("Please enter a valid name");
        alert.showAndWait();
        return false;
    }

    private boolean validateDOB() {
        if (isValidDate(txtDOB.getText())) {
            return true;
        }

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid Date Of Birth");
        alert.setHeaderText(null);
        alert.setContentText("Please enter a valid date in DD-MM-YYYY format");
        alert.showAndWait();
        return false;
    }

    private boolean isValidDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate currentDate = LocalDate.now();

        try {
            dtf.parse(date);
        } catch (Exception e) {
            return false;
        }

        return !currentDate.isBefore(LocalDate.parse(date,dtf));
    }

    private boolean validateContactNumber() {
        Pattern pattern = Pattern.compile("^0[0-9]{9}$");
        Matcher matcher = pattern.matcher(txtContactNumber.getText());

        if (matcher.find() && matcher.group().equals(txtContactNumber.getText())) {
            return true;
        }

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid Contact Number");
        alert.setHeaderText(null);
        alert.setContentText("Please enter a valid contact number in format 0xxxxxxxxx");
        alert.showAndWait();
        return false;
    }

    private boolean validateBatch() {
        if (!(cmbxBatch.getValue() == null) && !String.valueOf(cmbxBatch.getValue()).equals("Select")) {
            return true;
        }

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Batch Not Selected");
        alert.setHeaderText(null);
        alert.setContentText("Please select the batch you wish to join");
        alert.showAndWait();
        return false;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbxBatch.getItems().add("Select");
        cmbxBatch.getItems().add("B104");
        cmbxBatch.getItems().add("B105");
        cmbxBatch.getItems().add("B106");
        cmbxBatch.getItems().add("B107");
        txtStudentID.setText(generateStudentId());
    }
}
