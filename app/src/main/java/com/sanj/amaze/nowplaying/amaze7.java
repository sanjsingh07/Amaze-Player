/*
 * Copyright (C) 2018 Sanj Singh
 *
 * Licensed under the GNU General Public License v3
 *
 * This is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 */

package com.sanj.amaze.nowplaying;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sanj.amaze.MusicPlayer;
import com.sanj.amaze.MusicService;
import com.sanj.amaze.R;
import com.sanj.amaze.adapters.SlidingQueueAdapter;
import com.sanj.amaze.dataloaders.QueueLoader;
import com.sanj.amaze.utils.ImageUtils;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;

public class amaze7 extends BaseNowplayingFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_amaze1, container, false);

        setMusicStateListener();
        setSongDetails(rootView);
        initGestures(rootView.findViewById(R.id.album_art));

        return rootView;
    }



}
