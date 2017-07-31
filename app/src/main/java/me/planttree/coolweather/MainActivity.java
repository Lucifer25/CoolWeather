package me.planttree.coolweather;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    public LocationClient mLocationClient;
    private String countryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(new MyLocationListener());
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(prefs.getString("weather", null) != null){
            Intent intent = new Intent(this, WeatherActivity.class);
            startActivity(intent);
        }
    }


    public void requestLocation(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在定位...");
        progressDialog.show();
        LocationClientOption option = new LocationClientOption();
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
        mLocationClient.start();
    }

    public class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location){
            progressDialog.dismiss();
            if(location != null){
                countryId = "city=" + location.getDistrict();
                Toast.makeText(MainActivity.this, "定位成功！", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                intent.putExtra("weather_id", countryId);
                intent.putExtra("activity", "MainActivity");
                startActivity(intent);
            }else{
                /*SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                if(prefs.getString("weather", null) != null){
                    Toast.makeText(MainActivity.this, "定位失败！恢复上次浏览视图", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "定位失败！", Toast.LENGTH_SHORT).show();
                }*/
                Toast.makeText(MainActivity.this, "定位失败！", Toast.LENGTH_SHORT).show();

            }

        }
        public void onConnectHotSpotMessage(String connect, int hotSpotState){

        }

    }
}
