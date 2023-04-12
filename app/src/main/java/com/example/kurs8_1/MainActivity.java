package com.example.kurs8_1;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.location.provider.ProviderProperties;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.location.LocationServices;
public class MainActivity extends Activity {
    LocationManager mLocationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLocationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
    }
    public void AddGPS(View view) {

        mLocationManager.addTestProvider(LocationManager.GPS_PROVIDER, false,
                false,
                false, false, true, true,
                true, Criteria.POWER_LOW, Criteria.ACCURACY_FINE);


        mLocationManager.setTestProviderEnabled(LocationManager.GPS_PROVIDER,
                true);
        Location newLocation = new
                Location(LocationManager.GPS_PROVIDER);
        newLocation.setLatitude(55.813790);
        newLocation.setLongitude(37.499169);
        newLocation.setTime(System.currentTimeMillis());
        newLocation.setAccuracy(25);

        34
        newLocation.setElapsedRealtimeNanos(System.nanoTime());

        mLocationManager.setTestProviderLocation(LocationManager.GPS_PROVIDER
                , newLocation);
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
            return;
        }

        LocationServices.getFusedLocationProviderClient(this).setMockMode(true);

        LocationServices.getFusedLocationProviderClient(this).setMockLocation
                (newLocation);
    }
    public void DelGPS(View view) {

        mLocationManager.removeTestProvider(LocationManager.GPS_PROVIDER);
    }
}