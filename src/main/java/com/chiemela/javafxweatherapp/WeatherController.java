package com.chiemela.javafxweatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WeatherController {
    @FXML
    private TextField cityInput;

    @FXML
    private void getWeather() {
        String city = cityInput.getText();
        System.out.println("Button clicked: " + city);
    }
}