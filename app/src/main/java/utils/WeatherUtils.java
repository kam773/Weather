package utils;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil on 2018-03-19.
 */

public class WeatherUtils {


    private static final String LOG_TAG = WeatherUtils.class.getSimpleName();


    public WeatherUtils() {

    }

    public static List<Weather> fetchNewsData(String requestUrl) throws JSONException {
        URL url = createUrl(requestUrl);
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpsRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }
        List<Weather> weather = extractFromJSONResponse(jsonResponse);

        return weather;
    }

    private static URL createUrl(String stringUrl) {

        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating URL", e);
        }

        return url;
    }

    private static String makeHttpsRequest(URL url) throws IOException {
        String jsonResponse = "";
        if (url == null) {

            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /*milliseconds*/);
            urlConnection.setConnectTimeout(15000 /*milliseconds*/);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);

            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving Book JSON results.", e);

        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {

        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader;
            inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }

        return output.toString();
    }

    private static List<Weather> extractFromJSONResponse(String JSONResponse) throws JSONException {
        if (TextUtils.isEmpty(JSONResponse)) {
            return null;
        }

        List<Weather> weather = new ArrayList<>();


        try {

            JSONObject jsonResponse = new JSONObject(JSONResponse);
            JSONObject forecast = jsonResponse.getJSONObject("forecast");
            JSONObject simpleForecast = forecast.getJSONObject("simpleforecast");
            JSONArray listArray = simpleForecast.getJSONArray("forecastday");
            for (int i = 0; i < listArray.length(); i++) {

                JSONObject currentWeather = listArray.getJSONObject(i);

                String iconUrl = currentWeather.getString("icon_url");

                double humidity = currentWeather.getDouble("avehumidity");

                JSONObject highTempObject = currentWeather.getJSONObject("high");
                String maxTemp = highTempObject.getString("celsius");

                JSONObject lowTempObject = currentWeather.getJSONObject("low");
                String minTemp = lowTempObject.getString("celsius");


                JSONObject dateObject = currentWeather.getJSONObject("date");
                String date = dateObject.getString("monthname");
                String weekday = dateObject.getString("weekday");
                int day = dateObject.getInt("day");
                int year = dateObject.getInt("year");


                Weather data = new Weather(maxTemp, minTemp, humidity, date, iconUrl, year, day, weekday);
                weather.add(data);

            }


        } catch(JSONException e){
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        return weather;

    }
}





