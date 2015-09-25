package musicNote_Ver_3;

import java.util.ArrayList;

/*
   * @info  Class responsible for the registration of a musical track.
   *        Use : artist name , genre, artist and track title.
   *
   * Created by Alexander Bakhin on 23.09.15.
   * */
public class Track {

    private String artistName;  // имя исполнителя
    private String trackGenre;  // жанр исполнтеля
    private String trackTitle;   // название песни исполнителя

    public Track(String artistName, String trackGenre, String trackTitle) {

        this.artistName = artistName;
        this.trackGenre = trackGenre;
        this.trackTitle = trackTitle;

    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final Track track = (Track) obj;

        if ((this.artistName == null) ? (track.artistName == null) : !this.artistName.equals(track.artistName)) {
            return false;
        }
        if ((this.trackGenre == null) ? (track.trackGenre == null) : !this.trackGenre.equals(track.trackGenre)) {
            return false;
        }
        if ((this.trackTitle == null) ? (track.trackTitle == null) : !this.trackTitle.equals(track.trackTitle)) {
            return false;
        }

        return true;

    }

    @Override
    public int hashCode() {

        int result = 7;
        result = 31 * result + this.artistName.hashCode();
        result = 31 * result + this.trackGenre.hashCode();
        result = 31 * result + this.trackTitle.hashCode();
        return result;

    }

    @Override
    public String toString() {

        return "ARTIST: " + this.artistName + "\n\tGENRE: " + this.trackGenre + "\n\t\tTRACK TITLE: " + this.trackTitle;

    }

}
