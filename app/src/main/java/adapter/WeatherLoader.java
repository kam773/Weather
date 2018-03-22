package adapter;

import android.content.AsyncTaskLoader;
import android.content.Context;

import org.json.JSONException;

import java.util.List;


import utils.Weather;
import utils.WeatherUtils;

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
        if (mUrl == null) {
            return null;
        }
        List<Weather> weathers = null;
        try {
            weathers = WeatherUtils.fetchNewsData(mUrl);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return weathers;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        forceLoad();
    }
}
