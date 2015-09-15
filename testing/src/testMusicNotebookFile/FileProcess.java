package testMusicNotebookFile;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileProcess {
	
	private File file;
	
	public void writeFile(String fileName, String text) {
		
		file = new File(fileName);
		try {
			if(!file.exists()) {
				file.createNewFile();
			}

			PrintWriter writer = new PrintWriter(file.getAbsoluteFile());
			try {
				writer.print(text);
			} finally {
				writer.close();
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}

}
