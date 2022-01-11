package edu.upc.dsa.tracks.IO;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import edu.upc.dsa.tracks.R;

public class Alerta {
    private Activity myActivity;
    private AlertDialog alertDialog;

    public Alerta(Activity myActivity){
        this.myActivity = myActivity;
    }

    public void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(myActivity);
        LayoutInflater layoutInflater = myActivity.getLayoutInflater();
        builder.setView(layoutInflater.inflate(R.layout.activity_splash,null));
        alertDialog = builder.create();
        alertDialog.show();

    }

    public void cancelDialog(){
        this.alertDialog.cancel();
    }
}
