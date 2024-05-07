package net.protsenko;

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
