/**
 * @author Morteza Alizadeh
 */
package dsm.common.file;

import dsm.common.DSMManifest;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * DSMFileHelper class contains method to help working with files easier.
 * 
 * @version 0.1, April 15, 2012
 * @author Morteza Alizadeh
 */
public class DSMFileHelper extends DSMManifest {

    /**
     * DSMFileHelper constructor
     */
    public DSMFileHelper() {
        super("019abbef-b64b-4faf-91a6-0715d49f0c2c", "DSM File Helper");
    }

    public String readEntireTextFileContent(String szFilePath) throws Exception {
        FileInputStream fis = null;
        DataInputStream dis = null;
        BufferedReader br = null;
        
        try {
            fis = new FileInputStream(szFilePath);
            dis = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(dis));
            
            String szLineSeparator = System.getProperty("line.separator");
            String szFileContent = "";
            String szLine;

            while((szLine = br.readLine()) != null)
                szFileContent += szLine + szLineSeparator;
            
            return szFileContent;
        } finally {
            try {
                if (br != null)
                    br.close();
            }finally {
            }

            try {
                if (dis != null)
                    dis.close();
            }finally {
            }

            try {
                if (fis != null)
                    fis.close();
            }finally {
            }
        }
    }
}
