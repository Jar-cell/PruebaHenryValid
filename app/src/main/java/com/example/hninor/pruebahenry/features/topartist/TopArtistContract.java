package com.example.hninor.pruebahenry.features.topartist;

import com.example.hninor.pruebahenry.core.communication.entities.Artist;

import java.util.List;

public interface TopArtistContract {

    interface View {

        void setLoadingIndicator(boolean active);

        void showTopArtist(List<Artist> artists);

        void showTaskDetailsUi(String artistId);

    }

    interface Presenter {

        void result(int requestCode, int resultCode);

        void loadArtist(boolean forceUpdate, int page);


    }
}
