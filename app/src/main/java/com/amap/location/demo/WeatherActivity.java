package com.amap.location.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;

public class WeatherActivity extends AppCompatActivity implements WeatherSearch.OnWeatherSearchListener{
    WeatherSearchQuery mquery;
    WeatherSearch mweathersearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        mquery = new WeatherSearchQuery("广州", WeatherSearchQuery.WEATHER_TYPE_LIVE);
        mweathersearch=new WeatherSearch(this);
        mweathersearch.setOnWeatherSearchListener(this);
        mweathersearch.setQuery(mquery);
        mweathersearch.searchWeatherAsyn(); //异步搜索
    }
    LocalWeatherLive weatherlive;
    @Override
    public void onWeatherLiveSearched(LocalWeatherLiveResult weatherLiveResult , int rCode) {
        if (rCode == 1000) {
            if (weatherLiveResult != null&&weatherLiveResult.getLiveResult() != null) {
                weatherlive = weatherLiveResult.getLiveResult();
                Log.e("backinfo","weatherlive.getReportTime():"+weatherlive.getReportTime());
                Log.e("backinfo","weatherlive.getWeather():"+weatherlive.getWeather());
                Log.e("backinfo","weatherlive.getTemperature():"+weatherlive.getTemperature());
                Log.e("backinfo","weatherlive.getWindDirection():"+weatherlive.getWindDirection()+"风     "+weatherlive.getWindPower()+"级");
                Log.e("backinfo","湿度         "+weatherlive.getHumidity()+"%");
            }else {


            }
        }else {

        }
    }

    @Override
    public void onWeatherForecastSearched(LocalWeatherForecastResult localWeatherForecastResult, int rCode) {

    }
}
