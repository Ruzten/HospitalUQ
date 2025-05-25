module co.edu.uniquindio.poo.proyectojavafx {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    exports co.edu.uniquindio.poo.proyectojavafx;
    exports co.edu.uniquindio.poo.proyectojavafx.model;
    exports co.edu.uniquindio.poo.proyectojavafx.controller;
    exports co.edu.uniquindio.poo.proyectojavafx.viewController;


    opens co.edu.uniquindio.poo.proyectojavafx to javafx.fxml;
    opens co.edu.uniquindio.poo.proyectojavafx.viewController to javafx.fxml;
    opens co.edu.uniquindio.poo.proyectojavafx.controller to javafx.fxml;

}