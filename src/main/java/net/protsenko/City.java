package net.protsenko;

import java.util.Comparator;
import java.util.Objects;

public class City {
    private final String name;
    private final String region;
    private final String district;
    private final Integer population;
    private final String foundation;

    public City(Builder builder) {
        this.name = builder.name;
        this.region = builder.region;
        this.district = builder.district;
        this.population = builder.population;
        this.foundation = builder.foundation;
    }

    public static class Builder {
        String name;
        String region;
        String district;
        Integer population;
        String foundation;

        public Builder(String name) {
            this.name = name;
        }

        public Builder region(String region) {
            this.region = region;
            return this;
        }

        public Builder district(String district) {
            this.district = district;
            return this;
        }

        public Builder population(Integer population) {
            this.population = population;
            return this;
        }

        public Builder foundation(String foundation) {
            this.foundation = foundation;
            return this;
        }

        public City build() {
            return new City(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public Integer getPopulation() {
        return population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name) && Objects.equals(region, city.region) && Objects.equals(district, city.district) && Objects.equals(population, city.population) && Objects.equals(foundation, city.foundation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, region, district, population, foundation);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation=" + foundation +
                '}';
    }
}
