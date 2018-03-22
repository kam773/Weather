package com.example.kamil.weather;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.WeatherAdapter;
import adapter.WeatherLoader;
import utils.Weather;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Weather>> {

    private TextView mEmptyState;
    private WeatherAdapter mAdapter;

    private static final String BASE_URL =
            "http://api.wunderground.com/api/771028ced1c5c1b6/forecast10day/q/GB/London.json";

    private static final int WEATHER_LOADER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        mEmptyState = (TextView) findViewById(R.id.text_no_data_found);
        listView.setEmptyView(mEmptyState);

        mAdapter = new WeatherAdapter(this,new ArrayList<Weather>());

        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);



            }
        });

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {

            LoaderManager loaderManager = getLoaderManager();

            loaderManager.initLoader(WEATHER_LOADER_ID, null, this);
        } else {

            View loadingIndicator = findViewById(R.id.pb_loading_indicator);
            loadingIndicator.setVisibility(View.GONE);

            mEmptyState.setText(R.string.no_internet_connection);
        }

    }

    private void openLocationInMap() {
        String uri = "http://maps.google.com/maps?saddr=";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.forecast, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {

            return true;
        }

        if (id == R.id.action_map) {
            openLocationInMap();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader<List<Weather>> onCreateLoader(int i, Bundle bundle) {
        return new WeatherLoader(this, BASE_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Weather>> loader, List<Weather> weathers) {
        View loadingIndicator = findViewById(R.id.pb_loading_indicator);
        loadingIndicator.setVisibility(View.GONE);
        mEmptyState.setText(R.string.no_weather);

        mAdapter.clear();

        if (weathers != null && !weathers.isEmpty()) {
            mAdapter.addAll(weathers);

        }

    }

    @Override
    public void onLoaderReset(Loader<List<Weather>> loader) {
        mAdapter.clear();
    }
}
