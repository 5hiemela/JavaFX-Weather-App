package com.chiemela.javafxweatherapp;

public class WeatherData {
    private String city;
    private String country;
    private String condition;
    private String description;
    private double temperature;
    private double feelsLike;
    private int humidity;
    private double windSpeed;

    public WeatherData(String city, String country, String condition, String description,
                       double temperature, double feelsLike, int humidity, double windSpeed) {
        this.city = city;
        this.country = country;
        this.condition = condition;
        this.description = description;
        this.temperature = temperature;
        this.feelsLike = feelsLike;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    public String getCity() {
        return city;
    }
    public String getCountry() {
        return country;
    }
    public String getCondition() {
        return condition;
    }
    public String getDescription() {
        return description;
    }
    public double getTemperature() {
        return temperature;
    }
    public double getFeelsLike() {
        return feelsLike;
    }
    public int getHumidity() {
        return humidity;
    }
    public double getWindSpeed() {
        return windSpeed;
    }
}
