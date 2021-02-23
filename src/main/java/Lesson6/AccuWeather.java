package Lesson6;

import java.io.IOException;
import java.util.Objects;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AccuWeather {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String LOCATIONS = "locations";
    private static final String TOP_CITIES = "topcities";
    private static final String CITIES_NUMBER = "50";
    private static final String API_VERSION = "v1";
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST_PERIOD = "5day";
    private static final String MOSCOW_KEY = "294021";
    private static final String API_KEY = "zqu43IhsAvRlIePV9xmp3AA9r1zRoVrV";

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        HttpUrl urlWeather = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST_TYPE)
                .addPathSegment(FORECAST_PERIOD)
                .addPathSegment(MOSCOW_KEY)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        HttpUrl urlCity = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(API_VERSION)
                .addPathSegment(TOP_CITIES)
                .addPathSegment(CITIES_NUMBER)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru-ru")
                .build();

//      System.out.println(urlWeather.toString());
//      System.out.println(urlCity.toString());

        Request requestWeather = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(urlWeather)
                .build();

        Request requestCity = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(urlCity)
                .build();

        Response response1 = client.newCall(requestWeather).execute();
        Response response2 = client.newCall(requestCity).execute();
        System.out.println(response1.code());
        System.out.println(response2.code());

        String jsonResponse1 = Objects.requireNonNull(client.newCall(requestWeather).execute().body()).string();
        String jsonResponse2 = Objects.requireNonNull(client.newCall(requestCity).execute().body()).string();
        System.out.println(jsonResponse1);
        System.out.println(jsonResponse2);
    }
}
