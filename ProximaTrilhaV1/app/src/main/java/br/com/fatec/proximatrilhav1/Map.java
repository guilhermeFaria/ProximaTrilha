package br.com.fatec.proximatrilhav1;

import android.graphics.Color;
import android.location.Location;
import android.util.Log;
import android.view.View;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Guilherme on 19/09/2017.
 *
 * Classe de gerenciamento do Mapa
 */

public class Map {
    protected GoogleMap map;
    private static final String DEBUG="[DEBUG]";
    private static final String ERROR="[ERROR]";
    private static final Integer ZOOM_DEFAULT= 17;
    private SupportMapFragment mapFragment;
    private GoogleApiClient mGoogleApiClient;

    
    public Map(GoogleMap map, GoogleApiClient mGoogleApiClient) {
        this.map = map;
        this.mGoogleApiClient = mGoogleApiClient;
    }

    public static void setMapMyLocation(GoogleMap map, GoogleApiClient mGoogleApiClient) {
        Location location = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);

        Log.d(DEBUG, "lastLocation: "+location);
        setMapLocation(map, location);
    }

    /**
     * Mostra no mapa a localização informada inserindo também m icone no ponto.
     *
     * @param location - localização para configuração da exibição no mapa
     */
    private static void setMapLocation(GoogleMap map, Location location) {
        if (map != null && location != null) {
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(latLng, ZOOM_DEFAULT);
            map.animateCamera(update);

            Log.d(DEBUG, "setMapLocation: " + location);
            //TextView text = (TextView) findViewById(R.id.text);
            //text.setText(String.format("Lat/Lnt %f/%f, provider: %s", l.getLatitude(), l.getLongitude(), l.getProvider()));

            // Insere um circulo no mapa identificando a localização do usuario
            CircleOptions circle = new CircleOptions().center(latLng);
            circle.fillColor(Color.BLACK);
            circle.radius(10); // Em metros
            map.clear();
            map.addCircle(circle);
        }
    }

}
