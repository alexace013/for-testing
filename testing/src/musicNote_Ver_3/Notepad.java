package musicNote_Ver_3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by alexander on 23.09.15.
 */
public class Notepad implements Registration {

    private Map<Long, Track> notepad = new LinkedHashMap<>();
    private boolean trackAdd = false;
    private Long ID;

    public Notepad() {
        ID = 0L;
    }

    private void bumpID() {
        ID++;
    }

    @Override
    public boolean addTrack(String artist, String genre, String title) {
        Track track = new Track(artist, genre, title);
        notepad.put(ID, track);
        bumpID();
        trackAdd = true;
        return trackAdd;
    }

    @Override
    public Track getTrack(int index) {
        if (notepad.containsKey(index)) {
            return notepad.get(index);
        }
        return null;
    }

    @Override
    public boolean removeTrack(int index) {
        notepad.remove(index);
        return true;
    }

    public StringBuilder getAllTracks() {
        ArrayList<Track> list = new ArrayList<>();
        for (Track track : this.notepad.values()) {
            list.add(track);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(String.valueOf(i + 1) + ". " + list.get(i) + "\n");
        }
        return sb;
    }

    public long getID() {
       return ID;
    }

}
