package net.protsenko;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        List<City> cityDirectory = new ArrayList<>();
        Logger logger = Logger.getLogger("net.protsenko");

        try (InputStream inputStream = Main.class.getResourceAsStream("/listOfCities.csv");
             Scanner scanner = new Scanner(inputStream)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(";");

                if (split.length < 6) {
                    logger.warning("Invalid line: " + line);
                    continue;
                }

                String name = split[1];
                String region = split[2];
                String district = split[3];
                Integer population = Integer.parseInt(split[4]);
                String foundation = split[5];

                City city = new City.Builder(name)
                        .region(region)
                        .district(district)
                        .population(population)
                        .foundation(foundation)
                        .build();
                cityDirectory.add(city);
            }

        } catch (IOException e) {
            logger.warning("File not found: " + e.getMessage());
        }

//        System.out.println("-------------------------------");
//        System.out.println("-------------------------------");
//        Sort.sortByCityDsc(cityDirectory);
//        System.out.println("-------------------------------");
//        System.out.println("-------------------------------");
//        Sort.sortByDistrictAndCityDsc(cityDirectory);
//        System.out.println("-------------------------------");
//        System.out.println("-------------------------------");

        City[] cityArray = cityDirectory.toArray(new City[0]);
        int index = 0;
        int maxPopulation = 0;

        for (int i = 0; i < cityArray.length; i++) {
            int population = cityArray[i].getPopulation();

            if (population > maxPopulation) {
                maxPopulation = population;
                index = i;
            }
        }
        System.out.println("Наибольшее количество жителей (" + maxPopulation +
                ") в городе " + cityArray[index].getName() +
                " [" + index + "]");
    }
}