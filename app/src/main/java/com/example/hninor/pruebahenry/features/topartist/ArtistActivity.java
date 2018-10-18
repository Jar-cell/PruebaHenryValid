package com.example.hninor.pruebahenry.features.topartist;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.hninor.pruebahenry.R;
import com.example.hninor.pruebahenry.core.communication.entities.Artist;
import com.example.hninor.pruebahenry.features.topartist.domain.usecase.GetArtist;

import java.util.List;

public class ArtistActivity extends AppCompatActivity implements TopArtistContract.View {

    private TopArtistPresenter mTopArtistPresenter;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private FloatingActionButton fabNext;
    private FloatingActionButton fabPrevious;
    private int mPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_artist);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fabNext = (FloatingActionButton) findViewById(R.id.fabNext);
        fabPrevious = (FloatingActionButton) findViewById(R.id.fabPrevious);
        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPage++;
                if ( mPage > 1) {
                    fabPrevious.setEnabled(true);
                }
                mTopArtistPresenter.loadArtist(false, mPage);
            }
        });
        fabPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPage--;
                if (mPage == 1) {
                    fabPrevious.setEnabled(false);
                    fabPrevious.setBackgroundColor(Color.GRAY);
                }
                mTopArtistPresenter.loadArtist(false, mPage);

            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mTopArtistPresenter = new TopArtistPresenter(this, new GetArtist());
        mPage = 1;
        fabPrevious.setEnabled(false);

        mTopArtistPresenter.loadArtist(false, mPage);

    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showTopArtist(List<Artist> artists) {
        // specify an adapter (see also next example)
        mAdapter = new TopArtistAdapter(artists);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showTaskDetailsUi(String artistId) {

    }
}
