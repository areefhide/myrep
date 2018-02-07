package com.myrep.rals.tehcnicianapps.Utility;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import static android.support.v4.app.ActivityCompat.requestPermissions;

/**
 * Created by raldeskrisnu on 1/4/2017.
 */

public class GpsLocation extends Service implements LocationListener {

    private LocationManager locationManager;
    private Location location;
    private final int REQUEST_LOCATION = 200;
    public double latitude; // latitude
    public double longitude; // longitude
    public GpsLocation() {
        super();
    }

    public void Gpsloc(Activity ctx,Context Mcontext)
    {
        locationManager = (LocationManager)ctx.getSystemService(Service.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(Mcontext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Mcontext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ctx, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        } else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 2, this);
            if (locationManager != null) {
                location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            }
        }
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            if (location != null) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
                Log.d("Latitude",String.valueOf(location.getLatitude()));
                Log.d("Longitude",String.valueOf(location.getLongitude()));

              //  latitudePosition.setText(String.valueOf(location.getLatitude()));
               // longitudePosition.setText(String.valueOf(location.getLongitude()));
              //  getAddressFromLocation(location, getApplicationContext(), new GeoCoderHandler());
            }
        } else {
            //showGPSDisabledAlertToUser();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        if(location != null){
            Log.e("Latitudedd :", "" + location.getLatitude());
            Log.e("liosad :", "" + location.getLongitude());
        }
    }
    @Override
    public void onProviderDisabled(String provider) {
    }
    @Override
    public void onProviderEnabled(String provider) {
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }
}
