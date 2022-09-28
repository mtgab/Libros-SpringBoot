package com.example.Libros.services;

import com.example.Libros.entities.DolarAPI;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class DolarService {
    private static final String apiURL = "https://api-dolar-argentina.herokuapp.com/";
    private Retrofit retrofit;

    public DolarService() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(apiURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public DolarAPI libroDolar() throws IOException {
        IDolar iDolar = this.retrofit.create(IDolar.class);

        Call<DolarAPI> requestDolarAPI = iDolar.dolarAPI();

        Response<DolarAPI> dolarAPIResponse = requestDolarAPI.execute();

        return dolarAPIResponse.body();
    }
}
