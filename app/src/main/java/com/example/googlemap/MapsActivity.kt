package com.example.googlemap

import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.view.View
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.GeofencingRequest
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import java.util.ArrayList
import java.util.jar.Manifest

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var myPlace:LatLng

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap


       /* var myPlace = LatLng(16.866070, 96.195129)
        mMap.addMarker(MarkerOptions().position(myPlace).title("Yangon"))

        myPlace = LatLng(16.809249, 96.131538)
        mMap.addMarker(MarkerOptions().position(myPlace).title("My Location"))

        myPlace = LatLng(21.958828, 96.089104)
        mMap.addMarker(MarkerOptions().position(myPlace).title("Mandalay"))

        myPlace = LatLng(19.671480, 96.069893)
        mMap.addMarker(MarkerOptions().position(myPlace).title("Nay Pyi Taw"))

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myPlace, 12.0f))
*/
        var nameList= ArrayList<MapLocation>()

        nameList.add(MapLocation(40.712776,-74.005974,"New York"))
        nameList.add(MapLocation(35.689487,139.691711,"Tokyo"))
        nameList.add(MapLocation(35.693840,139.703552,"Shinjuku"))
        nameList.add(MapLocation(19.671480,96.069893,"Nay Pyi Taw"))
        nameList.add(MapLocation(16.866070,96.195129,"Yangon"))
        nameList.add(MapLocation(21.958828,96.089104,"Mandalay"))


        for(index in 0..nameList.size-1){
            myPlace = LatLng(nameList.get(index).latitude,nameList.get(index).longitude)
            mMap.addMarker(MarkerOptions().position(myPlace).title(nameList.get(index).name))
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myPlace, 12.0f))
    }


}