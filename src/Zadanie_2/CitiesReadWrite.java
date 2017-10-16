package Zadanie_2;

import java.io.*;
import java.util.ArrayList;

public class CitiesReadWrite {

    public ArrayList<String> readFromFile() {
        String fileName = "cities.txt";
        ArrayList<String> info = new ArrayList<>();

        try (
                FileReader fileReader = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(fileReader);
        ) {
            String nextLine = null;

            while ((nextLine = reader.readLine()) != null) {
                info.add(nextLine);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }

    public ArrayList<WeatherInfo> getWeatherInfo(ArrayList<String> city) {

        ArrayList<WeatherInfo> weatherInfos = new ArrayList<>();
        try {
            WeatherApi api = new WeatherApi();

            for (int i = 0; i < city.size(); i++) {
                int temperature = api.getTemperature(city.get(i));
                String description = api.getDescription(city.get(i));
                WeatherInfo weatherInfo = new WeatherInfo(city.get(i), description, temperature);
                weatherInfos.add(weatherInfo);
                System.out.printf("Pogoda w mieście %s: %s\n", city.get(i), description);
                System.out.printf("Aktualna temperatura: %d stopni\n", temperature);
            }
        } catch (IOException e) {
            System.err.println("Nie udało się pobrać informacji dla miasta ");
        }
        return weatherInfos;
    }

    public void writeToFile(ArrayList<WeatherInfo> fullI) {
        String fileName = "cities.csv";
                try (
                FileWriter fileWriter = new FileWriter(fileName);
                BufferedWriter writer = new BufferedWriter(fileWriter);
        ) {
            for (int i = 0; i < fullI.size(); i++) {
                writer.write(fullI.get(i).getCity() + ";" + fullI.get(i).getDescription()+ ";"
                + fullI.get(i).getTemperature());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





