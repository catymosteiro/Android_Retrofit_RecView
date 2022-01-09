package edu.upc.dsa.tracks.IO;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import edu.upc.dsa.tracks.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<ArrayList<Track>> {
    ApiService apiInterface;
    ArrayList<Track> list = new ArrayList<Track>();
    RecyclerView rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Para que dure mas tiempo el splash_screen
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTheme(R.style.SplashTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Call<ArrayList<Track>> call = ApiAdapter.getApiService().getTracks();
        call.enqueue(this);

        RecycleAdapter adapter = new RecycleAdapter(this, list);
        rec = findViewById(R.id.MainRecycle);
        rec.setAdapter(adapter);
        rec.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onResponse(Call<ArrayList<Track>> call, Response<ArrayList<Track>> response) {
        if(response.isSuccessful()){
            list = response.body();
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Track>> call, Throwable t) {
    }

}