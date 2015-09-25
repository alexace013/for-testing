package musicNote_Ver_3;

/**
 * Created by alexander on 23.09.15.
 */
public class ConsoleMainTest {

    public static void main(String[] args) {

        Notepad notepad = new Notepad();
        notepad.addTrack("Red Hot Chili Peppers", "funk", "Taste the Pain");
        notepad.addTrack("Die Antwoord", "zef", "Pitbull Terrier");
        notepad.addTrack("Kasabian", "indie rock", "Cutt Off");
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
