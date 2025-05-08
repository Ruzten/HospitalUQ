module co.edu.uniquindio.poo.proyectojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.proyectojavafx to javafx.fxml;
    exports co.edu.uniquindio.poo.proyectojavafx;
}