package testMusicNotebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.ranges.RangeException;

public class Notebook {

	private Map<Long, TrackRegister> registers = new HashMap<Long, TrackRegister>();
	private long nextId;
	private boolean trackAdd = false;

	private long getNextId() {
		if (nextId < Long.MAX_VALUE && !registers.containsKey(nextId)) {
			return nextId++;
		}
		nextId = 0;
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
		return (TrackRegister) register.clone();
	}

	public TrackRegister getTrack(long id) throws CloneNotSupportedException {
		if (registers.containsKey(id)) {
			return (TrackRegister) registers.get(id).clone();
		}
		return null;
	}

	public TrackRegister updateTrack(long id, String name, String surname,
			String phone) throws CloneNotSupportedException {
		TrackRegister register = new TrackRegister(id, name, surname, phone);
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
