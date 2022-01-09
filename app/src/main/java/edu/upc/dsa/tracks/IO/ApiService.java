package edu.upc.dsa.tracks.IO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("tracks")
    Call<ArrayList<Track>> getTracks();

}
