package cursoandroid.mapas.com;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(1);

        // Add a marker na prefeitura de campina and move the camera
        LatLng prefeitura = new LatLng(-7.2192037, -35.8828192);
        //-7.2192037, -35.8828192
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                Double latitude = latLng.latitude;
                Double longitude = latLng.longitude;

                Toast.makeText(MapsActivity.this,
                        "onClick Lat: "+latLng.latitude+ " Long: "+latLng.longitude, Toast.LENGTH_SHORT).show();

                mMap.addMarker(
                        new MarkerOptions()
                                .position(latLng)
                                .title("Local")
                                .snippet("Lat: "+latLng.latitude+ " Long: "+latLng.longitude)

                                .icon(
                                        BitmapDescriptorFactory.fromResource(R.drawable.icone_loja)
                                )

                );

            }
        });

        mMap.setOnMapLongClickListener(
                new GoogleMap.OnMapLongClickListener() {
                    @Override
                    public void onMapLongClick(LatLng latLng) {

                        Double latitude = latLng.latitude;
                        Double longitude = latLng.longitude;

                        Toast.makeText(MapsActivity.this,
                                "onLong Lat: "+latLng.latitude+ " Long: "+latLng.longitude, Toast.LENGTH_SHORT).show();

                        mMap.addMarker(
                                new MarkerOptions()
                                        .position(latLng)
                                        .title("Local")
                                        .snippet("Lat: "+latLng.latitude+ " Long: "+latLng.longitude)

                                        .icon(
                                                BitmapDescriptorFactory.fromResource(R.drawable.icone_carro_roxo_48px)
                                        )

                        );
                    }
                }

        );

        mMap.addMarker(
                new MarkerOptions()
                        .position(prefeitura)
                        .title("Prefeitura")
                       /* .icon(
                               BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)
                       )*/
                        .icon(
                                BitmapDescriptorFactory.fromResource(R.drawable.carro)
                        )

        );
        mMap.moveCamera(//2.0 ate 21.0
                CameraUpdateFactory.newLatLngZoom(prefeitura,18)
        );


    }
}
