package musicNote_Ver_3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by alexander on 25.09.15.
 */
public class FileWriteProcess {

    private static File file;

    public void writeFile(String filename, String text) {

        file = new File(filename + ".txt");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file, true);
            if (file.exists()) {
                try {
                    fileWriter.write("\n" + text);
                } finally {
                    fileWriter.close();
                }
            } else {
                file.createNewFile();
                fileWriter.close();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
