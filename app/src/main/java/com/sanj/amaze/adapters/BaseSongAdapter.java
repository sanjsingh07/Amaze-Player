package com.sanj.amaze.adapters;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.images.WebImage;
import com.sanj.amaze.MusicPlayer;
import com.sanj.amaze.activities.BaseActivity;
import com.sanj.amaze.activities.MainActivity;
import com.sanj.amaze.cast.amazeCastHelper;
import com.sanj.amaze.cast.WebServer;
import com.sanj.amaze.models.Song;
import com.sanj.amaze.utils.NavigationUtils;
import com.sanj.amaze.utils.amazeUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sanj Singh on 7/12/17.
 */

public class BaseSongAdapter<V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<V> {

    @Override
    public V onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(V holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        public ItemHolder(View view) {
            super(view);
        }

    }

    public void playAll(final Activity context, final long[] list, int position,
                        final long sourceId, final amazeUtils.IdType sourceType,
                        final boolean forceShuffle, final Song currentSong, boolean navigateNowPlaying) {

        if (context instanceof BaseActivity) {
            CastSession castSession = ((BaseActivity) context).getCastSession();
            if (castSession != null) {
                navigateNowPlaying = false;
                amazeCastHelper.startCasting(castSession, currentSong);
            } else {
                MusicPlayer.playAll(context, list, position, -1, amazeUtils.IdType.NA, false);
            }
        } else {
            MusicPlayer.playAll(context, list, position, -1, amazeUtils.IdType.NA, false);
        }

        if (navigateNowPlaying) {
            NavigationUtils.navigateToNowplaying(context, true);
        }


    }
    public void removeSongAt(int i){}
    public void updateDataSet(List<Song> arraylist) {}

}
