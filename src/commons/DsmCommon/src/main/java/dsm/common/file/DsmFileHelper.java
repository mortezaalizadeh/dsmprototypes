/**
 * @author Morteza Alizadeh
 */
package dsm.common.file;

import dsm.common.DsmManifest;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * DsmFileHelper class contains method to help working with files easier.
 *
 * @version 0.1, April 15, 2012
 * @author Morteza Alizadeh
 */
public class DsmFileHelper extends DsmManifest {

    /**
     * DsmFileHelper constructor.
     */
    public DsmFileHelper() {
        super("019abbef-b64b-4faf-91a6-0715d49f0c2c", "Dsm File Helper");
    }

    /**
     * Reads the content of the passed text file.
     * @param filePath Path to text file to read the content
     * @return Content of the file
     * @throws IOException If an I/O error occurs
     */
    public final String readEntireTextFileContent(final String filePath) throws IOException {
        FileInputStream fileInputStream = null;
        DataInputStream dataInputStream = null;
        BufferedReader bufferedReader = null;

        try {
            fileInputStream = new FileInputStream(filePath);
            dataInputStream = new DataInputStream(fileInputStream);
            bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));

            final String lineSeparator = System.getProperty("line.separator");
            StringBuilder fileContent = new StringBuilder("");
            String line = bufferedReader.readLine();

            while (line != null) {
                fileContent = fileContent.append(line);
                fileContent = fileContent.append(lineSeparator);
                line = bufferedReader.readLine();
            }

            return fileContent.toString();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }

            if (dataInputStream != null) {
                dataInputStream.close();
            }

            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }
}
