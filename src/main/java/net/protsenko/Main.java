package net.protsenko;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        List<City> cityDirectory = new ArrayList<>();
        Logger logger = Logger.getLogger("net.protsenko");

        File file = new File("src/main/resources/listOfCities.csv");
        try (Scanner scanner = new Scanner(file)) {

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

        } catch (FileNotFoundException e) {
            logger.warning("File not found: " + e.getMessage());
        }

        for (City city : cityDirectory) {
            System.out.println(city);
        }
    }
}