package net.protsenko;

import java.util.Comparator;
import java.util.List;

public class Sort {
    public static void sortByCityDsc(List<City> cities) {
        cities.sort(Comparator
                .comparing(City::getName)
                .thenComparing(City::getName));

        cities.forEach(System.out::println);
    }

    public static void sortByDistrictAndCityDsc(List<City> cities) {
        cities.sort(Comparator
                .comparing(City::getDistrict)
                .thenComparing(City::getName));

        cities.forEach(System.out::println);
    }
}
