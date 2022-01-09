package edu.upc.dsa.tracks.IO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {

    private static ApiService API_SERVICE;

    public static ApiService getApiService() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        String BASE_URL = "http://localhost:8080/dsaApp/";

        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            API_SERVICE = retrofit.create(ApiService.class);
        }
        return API_SERVICE;
    }

}
