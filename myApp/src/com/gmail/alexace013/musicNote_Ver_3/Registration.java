package com.gmail.alexace013.musicNote_Ver_3;

import java.util.ArrayList;

/**
 * @info interface indicating that the notepad can do.
 *
 * @author alexander on 23.09.15.
 */
public interface Registration {

    boolean addTrack(String artist, String genre, String title);
    Track getTrack(int index);
    boolean removeTrack(int index);
    StringBuilder getAllTracks();
    ArrayList getAllTracksList();

}
