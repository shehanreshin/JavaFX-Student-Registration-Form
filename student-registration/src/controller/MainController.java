package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainController extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/asset/fxml/RegistrationFormStage1.fxml"));
        Parent root = loader.load();
        RegistrationFormStage1Controller registrationFormStage1Controller = loader.getController();
        registrationFormStage1Controller.setup();

        Scene scene = new Scene(root);
        scene.getStylesheets()
                .add(this.getClass()
                        .getResource("/asset/css/registration-form-stage1.css")
                        .toExternalForm()
                );

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("BrillianZ");
        primaryStage.getIcons().add(new Image("/asset/img/logo4.png"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
