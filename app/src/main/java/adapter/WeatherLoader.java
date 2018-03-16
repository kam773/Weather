package adapter;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

import utils.Weather;

/**
 * Created by Kamil on 2018-03-16.
 */

public class WeatherLoader extends AsyncTaskLoader<List<Weather>> {

    private String mUrl;


    public WeatherLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    public List<Weather> loadInBackground() {



        return null;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

    }
}
