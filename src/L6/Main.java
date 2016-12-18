package L6;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Ivan on 18.12.2016.
 */
public class Main {


    private static short primitiveHash(char[] passwd) {
        short hash = 0;
        for (int i = 0; i < passwd.length; i++) {
            hash *= 5;
            hash += passwd[i];
            hash += 7;
        }
        return hash;
    }

    private static boolean checkPasswd(char[] passwd) {
        final int trueHash = 16416;
        if (primitiveHash(passwd) == trueHash)
            return true;
        else
            return false;
    }

    private static void one() {
        try {
            File from = new File("Lab6_1_from.txt");
            File to = new File("Lab6_1_to.txt");
            Scanner in = new Scanner(from);
            PrintWriter writer = new PrintWriter(to);
            Pattern pat = Pattern.compile("[a-zA-Z]{1,}");
            while (in.hasNext()) {
                Matcher mat = pat.matcher(in.nextLine());
                while (mat.find()) {
                    writer.write(mat.group() + " ");
                }
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void two() {
        Console cons = System.console();
        if (cons != null) {
            String login = cons.readLine("Login:");
            char[] passwd = cons.readPassword("%s", "Password:");
            if (checkPasswd(passwd))
                cons.writer().printf("ACCESS GRANTED");
            else
                cons.writer().printf("ACCESS DENIED");
            Arrays.fill(passwd, ' ');
        }
    }

    private static void three() throws IOException, ClassNotFoundException {
        class SomeClass implements Serializable {
            //private static final long serialVersionUID = 4050356936310708308L;
            private boolean aBoolean;
            private long aLong;
            private double aDouble;
            private String aString;

            public SomeClass(boolean b, long l, double d, String s) {
                aBoolean = b;
                aLong = l;
                aDouble = d;
                aString = s;
            }

            public String toString() {
                return "SomeClass instance fields:" + "\nboolean:" + aBoolean + "\nlong:" + aLong + "\ndouble:" + aDouble + "\nString:" + aString;
            }

        }

        File file = new File("Lab6_3.save");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        SomeClass someClass = new SomeClass(true, 111L, 111.111, "serialization in a nutshell");
        objectOutputStream.writeBoolean(false);
        objectOutputStream.writeInt(666);
        objectOutputStream.writeDouble(666.6);
        objectOutputStream.writeUTF("-a string with кирилик and latinic letters-");
        objectOutputStream.writeObject(someClass);
        objectOutputStream.flush();
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        boolean b = objectInputStream.readBoolean();
        int anInt = objectInputStream.readInt();
        double aDouble = objectInputStream.readDouble();
        String string = objectInputStream.readUTF();
        SomeClass someOtherClass = (SomeClass) objectInputStream.readObject();
        System.out.println("RESULT:\n" + "boolean " + b + "\nint " + anInt + "\ndouble " + aDouble + "\nString " + string + "\n" + someOtherClass.toString());
    }

    private static void four() throws IOException {
        File file = new File("Lab6_4.dat");
        int n = 64;
        byte[] buffer = new byte[n];
        Random random = new Random();
        random.nextBytes(buffer);
        System.out.println(Arrays.toString(buffer));
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.write(buffer);
        for (int i = 0; i < n; i += 2) {
            randomAccessFile.seek(i);
            byte b = randomAccessFile.readByte();
            randomAccessFile.seek(i);
            randomAccessFile.writeByte(b * -1);
        }
        byte[] modifiedBuffer = new byte[n];
        randomAccessFile.seek(0);
        randomAccessFile.read(modifiedBuffer);
        System.out.println(Arrays.toString(modifiedBuffer));
        randomAccessFile.close();
    }

    private static void five() throws IOException {
        System.out.println("ZIP TEST");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter new zip-file name:");
        String name = in.next();
        File file = new File(name + ".zip");
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(file));
        boolean nonstop = true;
        while (nonstop) {
            System.out.println("Enter new file name:");
            String newFileName = in.next();
            zos.putNextEntry(new ZipEntry(newFileName + ".txt"));
            PrintWriter printWriter = new PrintWriter(zos);
            System.out.println("Enter data strings\n(\"q!\" to stop writing to a file)\n(\"Q!\" to stop writing to an archive as well)");
            while (true) {
                String input = in.next();
                if (!input.substring(0, 2).equals("q!")) {
                    if (!input.substring(0, 2).equals("Q!")) {
                        printWriter.write(input);
                        printWriter.flush();
                    } else {
                        zos.closeEntry();
                        zos.close();
                        nonstop = false;
                        break;
                    }
                } else {
                    zos.closeEntry();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //one();
        //two();
        //three();
        //four();
        //five();
    }

}
