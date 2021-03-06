package testMusicNotebookFile;

import java.io.Serializable;

public class TrackRegister implements Serializable, Cloneable {

	private final long ID;
	private String author;
	private String genre;
	private String track;

	public TrackRegister(long id, String name, String surname, String phone) {
		this.ID = id;
		this.author = name;
		this.genre = surname;
		this.track = phone;
	}

	@Override
	public String toString() {
		return "author: " + author + ", genre: " + genre + ", track: " + track;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final TrackRegister register = (TrackRegister) obj;
		if ((this.track == null) ? (register.track == null) : !this.track
				.equals(register.track)) {
			return false;
		}
		if ((this.author == null) ? (register.author == null) : !this.author
				.equals(register.author)) {
			return false;
		}
		if ((this.genre == null) ? (register.genre == null) : !this.genre
				.equals(register.genre)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 61 * hash + (int) (this.ID ^ (this.ID >>> 32));
		hash = 61 * hash + (this.track != null ? this.track.hashCode() : 0);
		hash = 61 * hash + (this.author != null ? this.author.hashCode() : 0);
		hash = 61 * hash + (this.genre != null ? this.genre.hashCode() : 0);
		return hash;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public long getId() {
		return ID;
	}

	public String getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	public String getTrack() {
		return track;
	}

}
