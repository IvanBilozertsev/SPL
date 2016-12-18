package L5;

import java.io.*;

/**
 * Created by Ivan on 18.12.2016.
 */
public class Three {
    public static void main(String[] args) {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(args[0])));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(args[1])));) {
            byte[] buffer = new byte[16];
            long length = new File(args[0]).length();
            int count = 0;
            while (count < length) {
                bufferedInputStream.read(buffer);
                bufferedOutputStream.write(buffer);
                count += 16;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
