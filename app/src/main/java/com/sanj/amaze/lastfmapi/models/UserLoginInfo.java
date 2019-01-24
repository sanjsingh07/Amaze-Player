package com.sanj.amaze.lastfmapi.models;

import com.google.gson.annotations.SerializedName;
import com.sanj.amaze.lastfmapi.LastFmClient;

/**
 * Created by christoph on 17.07.16.
 */
public class UserLoginInfo {
    private static final String SESSION = "session";

    @SerializedName(SESSION)
    public LastfmUserSession mSession;


}
