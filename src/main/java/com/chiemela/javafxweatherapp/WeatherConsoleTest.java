package com.chiemela.javafxweatherapp;

public class WeatherConsoleTest {
    public static void main(String[] args) {
        System.out.println("Console Weather Test");

        WeatherService service = new WeatherService();

        String json = service.getWeather("Chicago"); // Chicago is placeholder
        service.parseWeather(json);
    }
}
