package me.planttree.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lucifer on 2017/7/27.
 * Email: wpy1174555847@outlook.com
 */

public class Suggestion {

    @SerializedName("comf")
    public Comfort comfort;

    @SerializedName("cw")
    public CarWash carWash;

    public Sport sport;

    public class Comfort{
        @SerializedName("txt")
        public String info;
    }

    public class CarWash{
        @SerializedName("txt")
        public String info;
    }

    public class Sport{
        @SerializedName("txt")
        public String info;
    }
}
