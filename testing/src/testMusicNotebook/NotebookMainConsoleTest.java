package testMusicNotebook;

public class NotebookMainConsoleTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Notebook phonebook = new Notebook();
		phonebook.addTrack("Red Hot Chili Peppers", "funk", "Taste the Pain");
		phonebook.addTrack("Die Antwoord", "zef", "Pitbull Terrier");
		phonebook.addTrack("Kasabian", "indie rock", "Cutt Off");
		System.err.println(phonebook.allTracks());

	}

}
