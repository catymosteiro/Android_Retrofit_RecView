package edu.upc.dsa.tracks.IO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("users/{username}")
    Call<Usuario>getUsuario(@Path("username") String username );

    @GET("users/{username}/repos")
    Call<List<Repositorio>>getRepositorios(@Path("username") String username);

}
