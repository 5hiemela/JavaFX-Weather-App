package com.chiemela.javafxweatherapp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// This class will handle API requests and data
public class WeatherService {
    // Receives raw JSON data
    public String getWeather(String city) {
        try {
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q="
                    + city + "&appid=5551f7592d08719d859a9c6a573579a6&units=imperial";

            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int status = connection.getResponseCode();

            if (status != 200) {
                System.out.println("Error: HTTP " + status);
                return null;
            }

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            return response.toString();

        } catch (Exception e) {
            e.printStackTrace(); // change later
            return null;
        }
    }
    // Parses through raw JSON weather data
    public void parseWeather(String response) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);

            String city = root.get("name").asText();
            String condition = root.get("weather").get(0).get("main").asText();
            String description = root.get("weather").get(0).get("description").asText();
            double temp = root.get("main").get("temp").asDouble();
            double tempFeel = root.get("main").get("feels_like").asDouble();
            double windSpeed = root.get("wind").get("speed").asDouble();
            int humidity = root.get("main").get("humidity").asInt();

            System.out.println("City: " + city);
            System.out.println("Condition: " + condition);
            System.out.println("Description: " + description);
            System.out.println("Temperature: " + temp);
            System.out.println("Feels Like: " + tempFeel);
            System.out.println("Humidity: " + humidity + "%");
            System.out.println("Wind Speed: " + windSpeed + " mph");

        } catch (Exception e) {
            e.printStackTrace(); // change later
        }
    }
}
