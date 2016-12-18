package L5;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Ivan on 17.12.2016.
 */
public class Main {

    private static void one() {
        System.out.println("STRINGBUILDER TEST\nEnter strings(enter \"stop\" to stop).");
        StringBuilder stringBuilder = new StringBuilder();
        Scanner in = new Scanner(System.in);
        while (true) {
            String s = in.next();
            if (!s.equals("stop")) {
                stringBuilder.append(s);
                System.out.println(stringBuilder.length());
            } else {
                break;
            }
        }
        System.out.println("Resulting string:" + stringBuilder.toString());

    }

    private static void two() {
        String s = "I hear the train is comming!";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c))
                    System.out.println("\'" + c + "\' " + "is an upper case letter.");
                else
                    System.out.println("\'" + c + "\' " + "is a lower case letter.");
            } else if (Character.isDigit(c)) {
                System.out.println("\'" + c + "\' " + "is a digit.");
            } else if (Character.isWhitespace(c)) {
                System.out.println("\'" + c + "\' " + "is a whitespace.");
            } else {
                System.out.println("\'" + c + "\' " + "is something uncommon.");
            }

        }
    }

    private static void four() {
        System.out.println("HEX DUMP TEST");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter file name:");
        String pathname = in.next();
        try {
            File file = new File(pathname);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            DataInputStream dis = new DataInputStream(bis);
            System.out.println("---DUMP---");
            int counter = 0;
            int n = 32;
            long length = file.length();
            while (counter < length) {
                byte[] buffer = new byte[n];
                bis.read(buffer);
                System.out.print("[ ");
                for (int i = 0; i < n; i++)
                    System.out.printf("0x%02x ", buffer[i]);
                System.out.println("]");
                counter += n;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("---||||---");
        }
    }

    private static void five(){
        try(SomeClosable five = new SomeClosable()){
            System.out.println("SomeClosable is up.");
        }catch (Exception e){
            System.out.println("Smth went wrong!");
        }
    }

    private static void six(){
        class FirstException extends Exception{
            public String toString(){
                return "First exception caught\n" + super.toString();
            }
        }

        class SecondException extends Exception{
            public String toString(){
                return "Second exception caught\n" + super.toString();
            }
        }

        class ThirdException extends Exception{
            Exception causedException;

            public ThirdException(Exception e){
                causedException = e;
            }

            public void react(){
                System.out.println("Third exception caused.\n");
                System.out.println("Stack:");
                causedException.printStackTrace();
            }
        }

        try{
            try {
                while(true){
                    System.out.println("Enter \"first\" of \"second\"");
                    Scanner in = new Scanner(System.in);
                    String s = in.next();
                    if(s.equals("first")){
                        throw new FirstException();
                    }else if(s.equals("second")){
                        throw new SecondException();
                    }
                }
            }catch (FirstException f){
                throw new ThirdException(f);
            }catch (SecondException s){
                throw new ThirdException(s);
            }
        }catch(ThirdException third){
            third.react();
            System.out.println();
        }

    }


    public static void main(String[] args) {
        /*1).С клавиатуры ввести несколько слов (фраз), объединить их через StringBuilder
        (каждый раз выводя на печать текущую емкость), распечатать итоговое значение.*/
        //one();
        /*2).Перебирая символы строки, распечатать информацию о каждом:
        является ли цифрой, символом (верхнего или нижнего регистра) или пробелом.*/
        //two();

        /*3).Реализовать программу, которая получает два имени текстовых файлов через параметр командной строки,
        затем выполняет копирование одного файла в другой, без использования системных функций копирования
        (открывать, читать и записывать данные - самостоятельно, через классы FileInputStream, FileOutputStream,  PrintWriter, FileWriter и т.п.).
        Использовать автозакрытие файлов через try(), обрабатывать ошибки ввода-вывода (печатать про них информацию).*/
        //В классе Three

        /*4).Разработать программу, запрашивающую имя файла у пользователя, затем печатающего содержимое файла как шестнадцатеричный дамп на экране.
        В случае возникновения ошибки (файл не найден, запрет доступа) программа также печатает сообщение об ошибке.
        В конце работы программа в любом случае выводит сообщение (любое) о завершении собственной работы.*/
        //four();

        /*5).Разработать класс, реализующий интерфейс Closeable. В конструкторе вывести сообщение о создании, в методе close() - о закрытии.
        Проверить функционирование блока try() с ресурсами.*/
        //five();

        /*6). Каскадирование: разработать три собственных класса, реализующих исключения.
        В блоке try {}, в зависимости от пользовательского ввода, выбросить одно из двух.
        Перехватывать оба возможных варианта, в обработчике выбросить третье исключение и позже перехватить его.
        На финальном этапе (перехвате третьего) распечатать стек вызовов каждого из перехваченных исключений.*/
        //six();
    }
}
