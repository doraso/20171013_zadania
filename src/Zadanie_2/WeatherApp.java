package Zadanie_2;
import Zadanie_2.WeatherApi;

import java.io.IOException;
import java.util.ArrayList;

public class WeatherApp {
    public static void main(String[] args) {

        CitiesReadWrite citiesWeat = new CitiesReadWrite();
        ArrayList<String> city = new ArrayList<>();
        ArrayList<WeatherInfo> fullInfo = new ArrayList<>();

        city = citiesWeat.readFromFile();
        fullInfo = citiesWeat.getWeatherInfo(city);

        citiesWeat.writeToFile(fullInfo);

    }
}
