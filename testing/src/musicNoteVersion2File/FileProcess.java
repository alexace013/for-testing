package musicNoteVersion2File;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by alexander on 13.09.15.
 */
public class FileProcess {

    private File file;

    public void writeFile(String fileName, String text) {

        file = new File(fileName);
        FileWriter fileWriter;
        try {
            String strRes = fileName + ".txt";
            File file2 = new File(strRes);
            fileWriter = new FileWriter(file2, true);
            if(file.exists()) {
                try {
                    fileWriter.write("\n" + text);
                } finally {
                    fileWriter.close();
                }
            } else {
                file.createNewFile();
                fileWriter.close();
            }

//            PrintWriter writer = new PrintWriter(file.getAbsoluteFile());
//            try {
//                writer.print(text);
//            } finally {
//                writer.close();
//            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
