package co.edu.uniquindio.poo.proyectojavafx;
import co.edu.uniquindio.poo.proyectojavafx.model.HospitalUQ;
import co.edu.uniquindio.poo.proyectojavafx.model.Navegacion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class HospitalUQAPP extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Navegacion.setStagePrincipal(primaryStage);
        Parent root = FXMLLoader.load(getClass().getResource("InicioAPP.fxml"));
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/Images/HospitalUQLOGO.png")));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(1400);
        primaryStage.setHeight(820);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();

        primaryStage.setTitle("HospitalUQ");

        primaryStage.show();
        HospitalUQ hospitalUQ = new HospitalUQ("HospitalUQ");
        hospitalUQ.iniciarDatosQuemados();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
