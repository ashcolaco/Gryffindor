package com.example.sandramisquith.trafficrunfinal2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gpstracking.R;
import com.firebase.client.Firebase;

public class MainActivity extends Activity {

    Button btnShowLocation;

    // GPSTracker class
    gps gpst;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        btnShowLocation = (Button) findViewById(R.id.btnShowLocation);

        // show location button click event
        btnShowLocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // create class object
                gpst = new gps(MainActivity.this);

                // check if GPS enabled
                if(gpst.canGetLocation()){

                    double latitude = gpst.getLatitude();
                    double longitude = gpst.getLongitude();
                    Firebase ref = new Firebase(Config.FIREBASE_URL);
                    ref.child("Latitiude").setValue(latitude);
                    ref.child("Longitude").setValue(longitude);
                    // \n is for new line
                    Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                }else{
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    gpst.showSettingsAlert();
                }

            }
        });
    }

}