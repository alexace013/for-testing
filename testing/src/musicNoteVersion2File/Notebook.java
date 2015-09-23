package musicNoteVersion2File;

import org.w3c.dom.ranges.RangeException;
import testMusicNotebookFile.TrackRegister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexander on 13.09.15.
 */
public class Notebook {

    private Map<Long, TrackRegister> registers = new HashMap<Long, TrackRegister>();
    private long nextId = 0;
    private boolean trackAdd = false;

    private long getNextId() {
        if (nextId < Long.MAX_VALUE && !registers.containsKey(nextId)) {
            return nextId++;
        }
        while (nextId < Long.MAX_VALUE) {
            if (!registers.containsKey(nextId)) {
                return nextId;
            }
            ++nextId;
        }
        throw new RangeException((short) 111, "No more IDs availiable");
    }

    public TrackRegister addTrack(String author, String genre, String track)
            throws CloneNotSupportedException {
        long registerId = getNextId();
        TrackRegister register = new TrackRegister(registerId, author, genre,
                track);
            registers.put(registerId, register);
            trackAdd = true;
        return (TrackRegister) register;
    }

    public TrackRegister getTrack(long id) throws CloneNotSupportedException {
        if (registers.containsKey(id)) {
            return (TrackRegister) registers.get(id).clone();
        }
        return null;
    }

    public TrackRegister updateTrack(long id, String author, String genre,
                                     String track) throws CloneNotSupportedException {
        TrackRegister register = new TrackRegister(id, author, genre, track);
        registers.put(id, register);
        return getTrack(id);
    }

    public void removeTrack(long id) {
        registers.remove(id);
    }

    public ArrayList<TrackRegister> allTracks() {
        ArrayList<TrackRegister> list = new ArrayList<TrackRegister>();
        for (TrackRegister reg : this.registers.values()) {
            list.add(reg);
        }
        return list;
    }

    public String addTrackInfo() {
        if (trackAdd == true) {
            return new String("track save.");
        }
        return new String("track is not saved.");
    }

}
