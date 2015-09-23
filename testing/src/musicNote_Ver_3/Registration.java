package musicNote_Ver_3;

/**
 * Created by alexander on 23.09.15.
 */
public interface Registration {

    boolean addTrack(String artist, String genre, String title);
    Track getTrack(int index);
    boolean removeTrack(int index);

}
