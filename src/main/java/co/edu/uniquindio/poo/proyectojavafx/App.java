package co.edu.uniquindio.poo.proyectojavafx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carga el archivo FXML
        Parent root = FXMLLoader.load(getClass().getResource("InicioApp.fxml"));

        // Crea y muestra la escena
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("HospitalUQ");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
