package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.kamil.weather.R;

import java.util.ArrayList;

import utils.Weather;

/**
 * Created by Kamil on 2018-03-16.
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






        return listItemView;
    }
}
