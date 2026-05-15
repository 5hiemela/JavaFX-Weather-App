package com.chiemela.javafxweatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WeatherController {
    @FXML
    private TextField cityInput;

    @FXML private Label cityLabel;
    @FXML private Label countryLabel;
    @FXML private Label conditionLabel;
    @FXML private Label descriptionLabel;
    @FXML private Label temperatureLabel;
    @FXML private Label feelsLikeLabel;
    @FXML private Label humidityLabel;
    @FXML private Label windLabel;

    @FXML
    private void getWeather() {
        String city = cityInput.getText();

        WeatherService service = new WeatherService();
        String json = service.getWeather(city);
        if (json == null) {
            System.out.println("Failed to retrieve weather");
            return;
        }
        WeatherData weather = service.parseWeather(json);

        cityLabel.setText("City: " + weather.getCity());
        countryLabel.setText("Country: " + weather.getCountry());
        conditionLabel.setText("Condition: " + weather.getCondition());
        descriptionLabel.setText("Description: " + weather.getDescription());
        temperatureLabel.setText("Temperature: " + weather.getTemperature());
        feelsLikeLabel.setText("Feels Like: " + weather.getFeelsLike());
        humidityLabel.setText("Humidity: " + weather.getHumidity() + "%");
        windLabel.setText("Wind Speed: " + weather.getWindSpeed() + " mph");
    }
}