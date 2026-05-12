package com.chiemela.javafxweatherapp;

public class WeatherConsoleTest {
    public static void main(String[] args) {
        System.out.println("Console Weather Test");

        WeatherService service = new WeatherService();

        System.out.println(service.getWeather("Chicago"));
    }
}
