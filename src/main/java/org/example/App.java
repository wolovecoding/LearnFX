package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage)  {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/org/example/primary.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("My Application");
        stage.setScene(new Scene(root));
        stage.show();
    }

/*    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }*/

 /*   private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }*/

    public static void main(String[] args) {
        launch();
    }

}