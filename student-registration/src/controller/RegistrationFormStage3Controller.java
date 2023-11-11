package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationFormStage3Controller implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

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

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbxMethodOfLearning.getItems().add("Select");
        cmbxMethodOfLearning.getItems().add("Online");
        cmbxMethodOfLearning.getItems().add("Physical");
    }
}
