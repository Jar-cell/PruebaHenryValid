package com.example.hninor.pruebahenry.features.topartist.domain.usecase;

import com.example.hninor.pruebahenry.core.Constants;
import com.example.hninor.pruebahenry.core.communication.GEOService;
import com.example.hninor.pruebahenry.core.communication.entities.Artist;
import com.example.hninor.pruebahenry.core.communication.entities.TopArtistResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetArtist {

    private GetArtistContract mCallback;

    public GetArtist() {
    }

    public void run(boolean forceUpdate, int page) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GEOService service = retrofit.create(GEOService.class);
        final Call<TopArtistResponse> topArtist = service.listTopArtist(page);
        topArtist.enqueue(new Callback<TopArtistResponse>() {
            @Override
            public void onResponse(Call<TopArtistResponse> call, Response<TopArtistResponse> response) {
                if (response.isSuccessful()) {
                    TopArtistResponse topArtistResponse = response.body();
                    List<Artist> artistList = topArtistResponse.getTopartists().getArtist();
                    mCallback.processTopArtist(artistList);
                }
            }

            @Override
            public void onFailure(Call<TopArtistResponse> call, Throwable t) {

            }
        });
    }

    public void setmCallback(GetArtistContract mCallback) {
        this.mCallback = mCallback;
    }
}
