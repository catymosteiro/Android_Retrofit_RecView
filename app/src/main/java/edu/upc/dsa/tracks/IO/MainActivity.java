package edu.upc.dsa.tracks.IO;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import edu.upc.dsa.tracks.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiService apiInterface;
    RecyclerView rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String mensajeRespuesta = intent.getStringExtra(Inicio.usuario);

        ImageView imagen = findViewById(R.id.imagenUsuario);
        TextView nombre = findViewById(R.id.username);
        TextView followers = findViewById(R.id.numfollowers);
        TextView following = findViewById(R.id.numfollowing);
        TextView repos = findViewById(R.id.numrepositorios);
        rec = findViewById(R.id.MainRecycle);

        Context context = this;

        Call<Usuario> call = ApiAdapter.getApiService().getUsuario(mensajeRespuesta);
        call.enqueue(new Callback<Usuario>() {
            //@RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Log.d("Response","Respuesta usuario: " + response.body());
                if(response.isSuccessful()){
                    Usuario u = response.body();
                    Picasso.get().load(u.getAvatar_url()).into(imagen);
                    nombre.setText(u.getName());
                    followers.setText(u.getFollowers());
                    following.setText(u.getFollowing());
                    repos.setText(u.getRepositorios());

                    Call<List<Repositorio>> call2 = ApiAdapter.getApiService().getRepositorios(mensajeRespuesta);
                    call2.enqueue(new Callback<List<Repositorio>>() {
                        @Override
                        public void onResponse(Call<List<Repositorio>> call, Response<List<Repositorio>> response) {
                            Log.d("Response","Respuesta repositorios: " + response.body());
                            List<Repositorio> list = response.body();
                            RecycleAdapter adapter = new RecycleAdapter(context, list);
                            rec.setAdapter(adapter);
                            rec.setLayoutManager(new LinearLayoutManager(context));
                        }

                        @Override
                        public void onFailure(Call<List<Repositorio>> call, Throwable t) {
                        }
                    });
                }
                else{
                    Intent intent = new Intent(getApplicationContext(),Inicio.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Intent intent = new Intent(getApplicationContext(),Inicio.class);
                startActivity(intent);
                Log.d("DEBUG", t.getMessage());
            }
        });
    }
}