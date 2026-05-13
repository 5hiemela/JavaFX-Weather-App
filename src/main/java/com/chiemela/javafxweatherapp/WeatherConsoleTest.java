package com.chiemela.javafxweatherapp;

import java.util.Scanner;

public class WeatherConsoleTest {
    public static void main(String[] args) {
        System.out.println("Console Weather Test");

        WeatherService service = new WeatherService();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        String json = service.getWeather(city);

        if (json != null) {
            service.parseWeather(json);
        } else {
            System.out.println("Failed to get weather data.");
        }
    }
}
