package com.example.hninor.pruebahenry.features.topartist.domain.usecase;

import com.example.hninor.pruebahenry.core.communication.entities.Artist;

import java.util.List;

public interface GetArtistContract {

    void processTopArtist(List<Artist> artistList);
}
