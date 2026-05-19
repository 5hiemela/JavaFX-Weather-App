package com.chiemela.javafxweatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WeatherController {
    @FXML private TextField cityInput;

    @FXML private Label errorLabel;
    @FXML private Label placeLabel;
    @FXML private Label conditionLabel;
    @FXML private Label descriptionLabel;
    @FXML private Label temperatureLabel;
    @FXML private Label feelsLikeLabel;
    @FXML private Label humidityLabel;
    @FXML private Label windLabel;

    @FXML
    private void getWeather() {
        String city = cityInput.getText();
        if (city.isBlank()) {
            errorLabel.setText("Please enter a city");
            return;
        }

        errorLabel.setText("");

        WeatherService service = new WeatherService();
        String json = service.getWeather(city);
        if (json == null) {
            errorLabel.setText("Failed to retrieve weather");
            return;
        }
        WeatherData weather = service.parseWeather(json);

        placeLabel.setText(weather.getCity() + ", " + weather.getCountry());
        conditionLabel.setText(weather.getCondition());
        descriptionLabel.setText(weather.getDescription());
        temperatureLabel.setText((int) Math.round(weather.getTemperature()) + "°F");
        feelsLikeLabel.setText((int) Math.round(weather.getFeelsLike()) + "°F");
        humidityLabel.setText(weather.getHumidity() + "%");
        windLabel.setText((int) Math.round(weather.getWindSpeed()) + " mph");
    }
}