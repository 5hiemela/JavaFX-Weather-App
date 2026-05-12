module com.chiemela.javafxweatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;


    opens com.chiemela.javafxweatherapp to javafx.fxml;
    exports com.chiemela.javafxweatherapp;
}