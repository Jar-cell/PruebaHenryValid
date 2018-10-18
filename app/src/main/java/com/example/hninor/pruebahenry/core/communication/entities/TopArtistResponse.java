
package com.example.hninor.pruebahenry.core.communication.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopArtistResponse {

    @SerializedName("topartists")
    @Expose
    private Topartists topartists;

    public Topartists getTopartists() {
        return topartists;
    }

    public void setTopartists(Topartists topartists) {
        this.topartists = topartists;
    }

}
