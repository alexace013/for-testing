package musicNote_Ver_3;

/**
 * Created by alexander on 23.09.15.
 */
public class ConsoleMainTest {

    public static void main(String[] args) {

        Notepad notepad = new Notepad();
        notepad.addTrack("one", "one", "one");
        notepad.addTrack("two", "two", "two");
        notepad.addTrack("two", "two", "two");
        System.out.println(notepad.getAllTracks());
        notepad.removeTrack(2);
        notepad.removeTrack(1);
        notepad.removeTrack(0);
        notepad.removeTrack(0);
        notepad.removeTrack(1);
        System.out.println(notepad.getAllTracks());
        System.out.println(notepad.getID());

    }

}
