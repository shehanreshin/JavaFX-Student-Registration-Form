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

public class RegistrationFormStage1Controller extends Application implements Initializable {

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

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/asset/fxml/RegistrationFormStage1.fxml"));
        scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("/asset/css/registration-form-stage1.css").toExternalForm());
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Student Registration");
        primaryStage.getIcons().add(new Image("/asset/img/logo3.png"));

        stage = primaryStage;
        stage.show();
    }

    public void getStarted(javafx.event.ActionEvent actionEvent) throws IOException{
        root = FXMLLoader.load(
                getClass().getResource("/asset/fxml/RegistrationFormStage2.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets()
                .add(this.getClass()
                        .getResource("/asset/css/registration-form-stage1.css")
                        .toExternalForm()
                );
        stage.setScene(scene);
    }

    public String generateStudentId() {
        /* Didn't add anything here since the assignment stated only to make
         * the front-end */
        return "031";
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

    public static void main(String[] args) {
        launch(args);
    }


}
