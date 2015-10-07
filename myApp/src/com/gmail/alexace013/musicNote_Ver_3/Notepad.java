package com.gmail.alexace013.musicNote_Ver_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @info class is responsible for the logic
 *       operation while the notebook.
 *
 * @author alexander on 23.09.15.
 */
public class Notepad implements Registration {

    private List<Track> notepad = new ArrayList<>();
    private boolean trackAdd = false;
    private Long ID;

    public Notepad() {
        ID = 0L;
    }

    private void upperID() {
        ID++;
    }

    private void lowerID() {
        ID--;
    }

    @Override
    public boolean addTrack(String artist, String genre, String title) {
        Track track = new Track(artist, genre, title);
        notepad.add(track);
        upperID();
        trackAdd = true;
        return trackAdd;
    }

    @Override
    public Track getTrack(int index) {
        if (notepad.size() > index) {
            return notepad.get(index);
        }
        return null;
    }

    @Override
    public boolean removeTrack(int index) {
        if (notepad.size() != 0 && index < notepad.size()) {
            notepad.remove(index);
            lowerID();
            return true;
        } else {
            return false;
        }
    }

    public StringBuilder getAllTracks() {
        ArrayList<Track> list = new ArrayList<>();
        for (Track track : notepad) {
            list.add(track);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(String.valueOf(i + 1) + ". " + list.get(i) + "\n");
        }
        return stringBuilder;
    }

    public ArrayList getAllTracksList() {
        ArrayList<Track> list = new ArrayList<>();
        for (Track track : notepad) {
            list.add(track);
        }
        return list;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Notepad note = new Notepad();
        return Objects.equals(notepad, note.notepad) && trackAdd == note.trackAdd && Objects.equals(ID, note.ID);
    }

    public long getID() {
        return ID;
    }

}
