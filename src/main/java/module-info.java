module co.edu.uniquindio.poo.proyectojavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.compiler;
    requires java.desktop;

    opens co.edu.uniquindio.poo.proyectojavafx to javafx.fxml;
    opens co.edu.uniquindio.poo.proyectojavafx.viewController to javafx.fxml;

    exports co.edu.uniquindio.poo.proyectojavafx;

    exports co.edu.uniquindio.poo.proyectojavafx.viewController to javafx.fxml;
}
