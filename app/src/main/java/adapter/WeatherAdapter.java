package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kamil.weather.MainActivity;
import com.example.kamil.weather.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import utils.Weather;

/**
 * Created by Kamil on 2018-03-20.
 */

public class WeatherAdapter extends ArrayAdapter<Weather> {


    public WeatherAdapter(Context context, ArrayList<Weather> weather) {
        super(context, 0, weather);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Weather currentWeather = getItem(position);

        TextView date = (TextView) listItemView.findViewById(R.id.month);
        date.setText(currentWeather.getDate());

        TextView minTemp = (TextView) listItemView.findViewById(R.id.low_temperature);
        minTemp.setText(String.valueOf(currentWeather.getMinTemp()) + " \u2103");

        TextView maxTemp = (TextView) listItemView.findViewById(R.id.high_temperature);
        maxTemp.setText(String.valueOf(currentWeather.getMaxTemp()) + " \u2103");

        ImageView image = (ImageView) listItemView.findViewById(R.id.weather_icon);
        Picasso.with(getContext()).load(currentWeather.getUrl()).into(image);

        TextView day = (TextView) listItemView.findViewById(R.id.day);
        day.setText(String.valueOf(currentWeather.getDay()));

        TextView weekday = (TextView) listItemView.findViewById(R.id.weekday);
        weekday.setText(String.valueOf(currentWeather.getWeekday()));

        TextView conditions = (TextView) listItemView.findViewById(R.id.conditions);
        conditions.setText(currentWeather.getConditions());

        TextView humidity = (TextView) listItemView.findViewById(R.id.humidity);
        humidity.setText(String.valueOf(currentWeather.getHumidity()) + " %");

        TextView wind = (TextView) listItemView.findViewById(R.id.wind);
        wind.setText(String.valueOf(currentWeather.getWind() + " kph"));

        TextView windDir = (TextView) listItemView.findViewById(R.id.windDir);
        windDir.setText(String.valueOf(currentWeather.getWindDir()));

        return listItemView;
    }

}
