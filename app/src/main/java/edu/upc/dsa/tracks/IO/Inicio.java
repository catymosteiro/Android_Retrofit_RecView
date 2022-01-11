package edu.upc.dsa.tracks.IO;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import edu.upc.dsa.tracks.R;

public class Inicio extends AppCompatActivity {

    public static final String usuario = "edu.upc.dsa.tracks.IO.usuario";
    private Button boton;
    private EditText TextBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        boton = findViewById(R.id.inicio);
        TextBox = findViewById(R.id.user);
        Alerta dialogo  = new Alerta(this);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = TextBox.getText().toString();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra(usuario,name);
                dialogo.showDialog();
                Handler handler  = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialogo.cancelDialog();
                        startActivity(i);
                    }
                },2000);
            }
        });
    }

    //public void inicio(View view){
    //Intent i = new Intent(this, MainActivity.class);
      //  startActivity(i);
    //}
}