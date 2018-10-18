package com.example.hninor.pruebahenry.core.communication;

import com.example.hninor.pruebahenry.core.communication.entities.TopArtistResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GEOService {

    @GET("2.0/?method=geo.gettopartists&country=spain&api_key=829751643419a7128b7ada50de590067&format=json")
    Call<TopArtistResponse> listTopArtist(@Query("page") int page);
}
