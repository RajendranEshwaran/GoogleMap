package com.example.rajayambigms.googlemap;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.graphics.Paint.Align.CENTER;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_Explore extends Fragment implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap googleMap;
    private LocationManager locationManager;


    private LatLng CENTER = null;

    private double longitude;
    private double latitude;

    private String snippet;
    private String title;
    private Location location;
    private String myAddress;

    private String LocationId;
    private String CityName;
    private String imageURL;

    private float lati =-34.0f;
    private float longt =151.0f;
    private String city ="";
    private String desc ="";

    public fragment_Explore() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment__explore, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapView = (MapView) view.findViewById(R.id.mapView);

        if(mapView != null)
        {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMapobj) {

        MapsInitializer.initialize(getContext());
        googleMap = googleMapobj;
        googleMapobj.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMapobj.addMarker(new MarkerOptions().position(new LatLng(lati,longt)).title(title).snippet(desc));
        CameraPosition Liberty = CameraPosition.builder().target(new LatLng(lati,longt)).zoom(4).bearing(0).tilt(45).build();
        googleMapobj.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));
    }
}
