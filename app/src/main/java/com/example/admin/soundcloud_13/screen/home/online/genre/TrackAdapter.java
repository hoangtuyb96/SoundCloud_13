package com.example.admin.soundcloud_13.screen.home.online.genre;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.soundcloud_13.R;
import com.example.admin.soundcloud_13.data.model.Track;
import com.example.admin.soundcloud_13.screen.BaseRecyclerViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TrackAdapter extends BaseRecyclerViewAdapter<TrackAdapter.TrackViewHolder> {
    private List<Track> mTracks = new ArrayList<>();
    private LayoutInflater mLayoutInflater;

    protected TrackAdapter(@NonNull Context context) {
        super(context);
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TrackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_song, parent, false);
        return new TrackViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackViewHolder holder, int position) {
        holder.bindData(mTracks.get(position));
    }

    @Override
    public int getItemCount() {
        return mTracks.size();
    }

    public void updateTrack(ArrayList<Track> tracks) {
        if (tracks == null) {
            return;
        }
        mTracks.addAll(tracks);
        this.notifyDataSetChanged();
    }

    public class TrackViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTextView;
        private TextView mArtistTextView;
        private TextView mDescriptionTextView;
        private ImageView mImageView;

        public TrackViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitleTextView = itemView.findViewById(R.id.text_view_title);
            mArtistTextView = itemView.findViewById(R.id.text_view_artist);
            mDescriptionTextView = itemView.findViewById(R.id.text_view_description);
            mImageView = itemView.findViewById(R.id.image_view);
        }

        public void bindData(Track track) {
            mTitleTextView.setText(track.getTitle());
            mArtistTextView.setText(track.getArtist());
            mDescriptionTextView.setText(track.getDescription());
            Picasso.get().load(track.getArtworkUrl()).placeholder(R.drawable.image_default)
                    .fit().centerCrop().into(mImageView);
        }
    }
}
