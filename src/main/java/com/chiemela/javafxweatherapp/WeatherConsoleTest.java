package com.chiemela.javafxweatherapp;

import java.util.Scanner;

// Testing console before JavaFX
public class WeatherConsoleTest {
    public static void main(String[] args) {
        System.out.println("Console Weather Test");

        WeatherService service = new WeatherService();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        scanner.close();

        String json = service.getWeather(city);

        if (json != null) {
            WeatherData weather = service.parseWeather(json);

            System.out.println("Place: " + weather.getCity() + ", " + weather.getCountry());
            System.out.println("Condition: " + weather.getCondition());
            System.out.println("Description: " + weather.getDescription());
            System.out.println("Temperature: " + weather.getTemperature());
            System.out.println("Feels Like: " + weather.getFeelsLike());
            System.out.println("Humidity: " + weather.getHumidity() + "%");
            System.out.println("Wind Speed: " + weather.getWindSpeed() + " mph");

        } else {
            System.out.println("Failed to get weather data.");
        }
    }
}
