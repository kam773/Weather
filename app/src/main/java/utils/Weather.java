package utils;

/**
 * Created by Kamil on 2018-03-19.
 */

public class Weather {

    private String maxTemp;
    private String minTemp;
    private double humidity;
    private String date;
    private int year;
    private int day;
    private String weekday;
    private String url;


    public Weather(String maxTemp, String minTemp, double humidity, String date, String url, int year, int day, String weekday) {
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.humidity = humidity;
        this.date = date;
        this.day = day;
        this.year = year;
        this.weekday = weekday;
        this.url = url;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public double getHumidity() {
        return humidity;
    }

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }

    public String getWeekday() {
        return weekday;
    }
}



