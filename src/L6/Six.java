package L6;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/**
 * Created by Ivan on 18.12.2016.
 */
public class Six {
    public static void main(String[] args) {
        try{
            //String s = "zipfile.zip";
            //ZipInputStream zis = new ZipInputStream(new FileInputStream(new File(s)));
            ZipInputStream zis = new ZipInputStream(new FileInputStream(new File(args[0])));
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null){
                PrintWriter writer = new PrintWriter(new File(entry.getName()));
                while(zis.available() != 0){
                    writer.write(zis.read());
                }
                writer.flush();
                writer.close();
                zis.closeEntry();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
