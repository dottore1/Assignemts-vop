module com.mycompany.vopoevelsestime1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.vopoevelsestime1 to javafx.fxml;
    exports com.mycompany.vopoevelsestime1;
}