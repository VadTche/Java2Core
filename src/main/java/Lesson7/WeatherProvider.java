package Lesson7;

import java.io.IOException;

public interface WeatherProvider {
    void getWeather(Periods periods) throws IOException;
}
