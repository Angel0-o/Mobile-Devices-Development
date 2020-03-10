package com.example.templategooglemaps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    //Para almacenar las posiciones
    LatLng mexico,eiffelTower,bigBen;
    LatLng whiteHouse,pisaTower,gisPyramids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        //Se recupera el objeto fragemnt del mapa
        mapFragment.getMapAsync(this);
        //Asiganr los eventos de cada boton
        this.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.moveCamera(CameraUpdateFactory.newLatLng(eiffel));
            }
        });
        //Agregamos el id de los botones a la clase princiapl
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        //Agregar una lista de tipo latln para almacenar las longitudes de los sitios
    }

    void moveCamera(LatLng cameraPosition){
        mMap.animateCamera(CameraUpdateFactory.zoomTo(v:10),i:2000,canceledCallback)
    }
    //Checar la documentacion de google maps para mover la camera
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        initMarkers();
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);//Latitiud y longitud del lugar
        mMap.addMarker(new MarkerOptions().
                position(sydney).
                title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory
                .newLatLng(sydney));
    }
    
    void initMarkers(){
        //Add a marker for Eiffel Tower
        LatLng eiffel = new LatLng(-34, 151);//Latitiud y longitud del lugar
        mMap.addMarker(new MarkerOptions().position(eiffel).title("Marker in Sydney"));
        //Add a marker for Mexico
        LatLng mexico = new LatLng(-34, 151);//Latitiud y longitud del lugar
        mMap.addMarker(new MarkerOptions().position(mexico).title("Marker in Sydney"));
        //Add a marker for Big Ben
        //Add a marker for White House
        //Add a marker for Torre de pisa
        //Add a marker for Piramides de Giza
    }
}
