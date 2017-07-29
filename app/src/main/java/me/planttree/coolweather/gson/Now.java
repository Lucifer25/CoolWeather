package me.planttree.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lucifer on 2017/7/27.
 * Email: wpy1174555847@outlook.com
 */

public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }
}
