package edu.upc.dsa.tracks.IO;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import edu.upc.dsa.tracks.R;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    public void inicio(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}