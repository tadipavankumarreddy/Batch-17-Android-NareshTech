package in.nareshtech.googlemaps;

import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import in.nareshtech.googlemaps.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // We are requesting the user to grant location permissions
        if(checkCallingOrSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},123);
        }
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
        // Add a marker in Sydney and move the camera
        LatLng nareshIt = new LatLng(17.4375, 78.4456);
        mMap.addMarker(new MarkerOptions().position(nareshIt).title("Marker in Naresh Tech"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(nareshIt));

        LatLng tajmahal = new LatLng(27.1751, 78.0421);
        mMap.addMarker(new MarkerOptions().position(tajmahal).title("Marker in Tajmahal"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tajmahal));

        if (checkCallingOrSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            // Logic to fetch the current location from the user
            LocationManager manager = (LocationManager) getSystemService(LOCATION_SERVICE);
            Location l = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            double lat = l.getLatitude();
            double lang = l.getLongitude();

            LatLng myLoc = new LatLng(lat,lang);
            mMap.addMarker(new MarkerOptions().position(myLoc).title("My Location"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLoc,18));

            mMap.getUiSettings().setMyLocationButtonEnabled(true);
        }

        mMap.getUiSettings().setZoomControlsEnabled(true);


    }
}