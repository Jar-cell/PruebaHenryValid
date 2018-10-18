package com.example.hninor.pruebahenry.features.topartist;

import com.example.hninor.pruebahenry.core.communication.entities.Artist;
import com.example.hninor.pruebahenry.features.topartist.domain.usecase.GetArtist;
import com.example.hninor.pruebahenry.features.topartist.domain.usecase.GetArtistContract;

import java.util.List;

public class TopArtistPresenter implements TopArtistContract.Presenter, GetArtistContract {

    private boolean mFirstLoad = true;
    private  TopArtistContract.View mView;
    private  GetArtist mGetArtist;
    public  TopArtistPresenter(TopArtistContract.View view, GetArtist getArtist) {
        mView = view;
        mGetArtist = getArtist;
        mGetArtist.setmCallback(this);
    }
    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void loadArtist(boolean forceUpdate, int page) {
        mGetArtist.run(forceUpdate || mFirstLoad, page);
        mFirstLoad = false;
    }

    @Override
    public void processTopArtist(List<Artist> artistList) {
        mView.showTopArtist(artistList);
    }
}
