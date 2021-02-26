package Lesson7;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {

        @JsonProperty("LocalDate")
        private String localDate;
        @JsonProperty("Text")
        private String text;
        @JsonProperty("TemperatureOut")
        private double temperatureOut;

        public WeatherResponse() {
        }

        public WeatherResponse(String localDate, String text, double temperatureOut) {
            this.localDate = localDate;
            this.text = text;
            this.temperatureOut = temperatureOut;
        }

        public String getLocalDate() {
            return localDate;
        }
        public void setLocalDate(String localDate) {
            this.localDate = localDate;
        }

        public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }

        public double getTemperatureOut() {
            return temperatureOut;
        }
        public void setTemperatureOut(double temperatureOut) {
            this.temperatureOut = temperatureOut;
        }

        @Override
        public String toString() {
            return "Прогноз на " + localDate + ": ожидается " + text + " и " + temperatureOut + " C";
        }
    }

