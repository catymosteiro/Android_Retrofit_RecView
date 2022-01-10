package edu.upc.dsa.tracks.IO;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import edu.upc.dsa.tracks.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //Para que dure mas tiempo el splash_screen
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTheme(R.style.SplashTheme);
    }
}