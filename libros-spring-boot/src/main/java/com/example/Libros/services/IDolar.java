package com.example.Libros.services;

import com.example.Libros.entities.DolarAPI;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IDolar {
    @GET("/api/dolarblue")
    Call<DolarAPI> dolarAPI ();
}
