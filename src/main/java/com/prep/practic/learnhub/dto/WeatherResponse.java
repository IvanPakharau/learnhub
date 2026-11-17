package com.prep.practic.learnhub.dto;

public class WeatherResponse {
    private Main main;
    private String name;

    public static class Main {
        private double temp;
        private int humidity;

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        @Override
        public String toString() {
            return "Main{" +
                    "temp=" + temp +
                    ", humidity=" + humidity +
                    '}';
        }
// getters/setters
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "main=" + main +
                ", name='" + name + '\'' +
                '}';
    }
// getters/setters
}