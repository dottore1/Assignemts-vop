module com.mycompany.oevelsestime2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.oevelsestime2 to javafx.fxml;
    exports com.mycompany.oevelsestime2;
}