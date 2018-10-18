package com.example.hninor.pruebahenry.features.topartist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hninor.pruebahenry.R;
import com.example.hninor.pruebahenry.core.communication.entities.Artist;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TopArtistAdapter extends RecyclerView.Adapter<TopArtistAdapter.MyViewHolder> {
    private List<Artist> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mName;
        public TextView mListeners;
        public ImageView mImage;

        public MyViewHolder(View v) {
            super(v);
            mName = (TextView) itemView.findViewById(R.id.tvArtistName);
            mListeners = (TextView) itemView.findViewById(R.id.tvListeners);
            mImage = (ImageView) itemView.findViewById(R.id.ivArtist);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public TopArtistAdapter(List<Artist> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TopArtistAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // create a new view
        // Inflate the custom layout
        View artistView = inflater.inflate(R.layout.item_artist, parent, false);

        MyViewHolder vh = new MyViewHolder(artistView);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.mName.setText(mDataset.get(position).getName());
        holder.mListeners.setText(mDataset.get(position).getListeners());

        Picasso.get().load(mDataset.get(position).getImage().get(2).getText()).into(holder.mImage);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
