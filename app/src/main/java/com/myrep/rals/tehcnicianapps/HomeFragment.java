package com.myrep.rals.tehcnicianapps;


import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CameraPosition.Builder;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.myrep.rals.tehcnicianapps.Utility.GpsLocation;

public class HomeFragment extends Fragment {

    private GoogleMap gmaps;
    private SupportMapFragment mSupportMapFragment;
    GpsLocation gps;
    private static View view;
    private Marker marker;
    private MapView mapView;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
        View rootView = inflater.inflate(R.layout.home_fragment, container, false);
        mapView = (MapView) rootView.findViewById(R.id.mapView);
        gps = new GpsLocation();
        gps.Gpsloc(getActivity(), getActivity().getApplicationContext());
        final double lat = gps.latitude;
        final double longi = gps.longitude;
        final LatLng latLng = new LatLng(lat, longi);

        gps = new GpsLocation();
        gps.Gpsloc(getActivity(), getActivity().getApplicationContext());
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                gmaps = googleMap;
                if (ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                gmaps.setMyLocationEnabled(true);
                float zoomLevel = 16.0f;
                CameraPosition position  = new Builder().target(latLng).build();
                gmaps.animateCamera(CameraUpdateFactory.newCameraPosition(position));
//                gmaps.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel));
                gmaps.getUiSettings().setAllGesturesEnabled(true);
            }
        });



//                mSupportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
//                if (mSupportMapFragment == null) {
//                    FragmentManager fragmentManager = getFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    mSupportMapFragment = SupportMapFragment.newInstance();
//                    fragmentTransaction.replace(R.id.map, mSupportMapFragment).commit();
//                }
//
//                mSupportMapFragment.getMapAsync(new OnMapReadyCallback() {
//                    @Override
//                    public void onMapReady(GoogleMap googleMap) {
//
//                        float zoomLevel = 16.0f;
//                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel));
//                        googleMap.getUiSettings().setAllGesturesEnabled(true);
//
//                        if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//                            googleMap.setMyLocationEnabled(true);
//
//                        } else {
//
//                            if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//                                googleMap.setMyLocationEnabled(true);
//
//                            }
//                        }
//
//
//                    }
//                });

        return rootView;
    }


}