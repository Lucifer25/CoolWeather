package me.planttree.coolweather.gson;

/**
 * Created by Lucifer on 2017/7/27.
 * Email: wpy1174555847@outlook.com
 */

public class AQI {
    public AQICity city;

    public class AQICity{
        public String aqi;
        public String pm25;
    }
}
