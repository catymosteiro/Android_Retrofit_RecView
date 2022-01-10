package edu.upc.dsa.tracks.IO;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.upc.dsa.tracks.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiService apiInterface;
    List<Track> list = new ArrayList<Track>();
    RecyclerView rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Call<List<Track>> call = ApiAdapter.getApiService().getTracks();
        Context context = this;
        call.enqueue(new Callback<List<Track>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Track>> call, Response<List<Track>> response) {
                Log.d("Response","Response: " + response.body());
                if(response.isSuccessful()){
                    list = response.body();
                    RecycleAdapter adapter = new RecycleAdapter(context, list);
                    rec = findViewById(R.id.MainRecycle);
                    rec.setAdapter(adapter);
                    rec.setLayoutManager(new LinearLayoutManager(context));
                }
            }


            @Override
            public void onFailure(Call<List<Track>> call, Throwable t) {

                Log.d("DEBUG", t.getMessage());
            }
        });
    }
/*
    @Override
    public void onResponse(Call<ArrayList<Track>> call, Response<ArrayList<Track>> response) {
        Log.d("Response","Response: " + response.code());
        if(response.isSuccessful()){
            list = response.body();
            RecycleAdapter adapter = new RecycleAdapter(this, list);
            rec = findViewById(R.id.MainRecycle);
            rec.setAdapter(adapter);
            rec.setLayoutManager(new LinearLayoutManager(this));
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Track>> call, Throwable t) {
    }
*/
}