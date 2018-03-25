package utils;

import java.io.Serializable;

/**
 * Created by Kamil on 2018-03-19.
 */

public class Weather implements Serializable {

    private String maxTemp;
    private String minTemp;
    private int humidity;
    private String date;
    private int wind;
    private int day;
    private String weekday;
    private String url;
    private String conditions;
    private String windDir;

    public Weather(String maxTemp, String minTemp, int humidity, String date,
                   int wind, int day, String weekday, String url, String conditions, String windDir) {
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.humidity = humidity;
        this.date = date;
        this.wind = wind;
        this.day = day;
        this.weekday = weekday;
        this.url = url;
        this.conditions = conditions;
        this.windDir = windDir;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public int getHumidity() {
        return humidity;
    }

    public String getDate() {
        return date;
    }

    public int getWind() {
        return wind;
    }

    public int getDay() {
        return day;
    }

    public String getWeekday() {
        return weekday;
    }

    public String getUrl() {
        return url;
    }

    public String getConditions() {
        return conditions;
    }

    public String getWindDir() {
        return windDir;
    }
}


