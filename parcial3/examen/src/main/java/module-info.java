module co.edu.poli.parcial {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.poli.parcial.controlador to javafx.fxml;
    opens co.edu.poli.parcial.model to javafx.base;

    exports co.edu.poli.parcial.vista;
}
