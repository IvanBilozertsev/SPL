package L4;

import L3.Name;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Ivan on 16.12.2016.
 */
public class Main {

    private int testVar1;
    private int testVar2;
    private static int staticVar1;
    private static int staticVar2;

    private void testVoid() {
        System.out.println("I`m a non-static void");
    }

    private static void staticTestVoid() {
        System.out.println("I`m a static void");
    }

    private class InnerClass {
        public void testAccessibility() {
            System.out.println("These are non-static variables: " + testVar1 + "," + testVar2);
            System.out.println("These are static variables: " + staticVar1 + "," + staticVar2);
            System.out.println("This is a non-static method");
            testVoid();
            System.out.println("This is a static method");
            staticTestVoid();
        }
    }

    private static class StaticNestedClass {
        public void testAccessibility() {
            //System.out.println("These are non-static variables: " + testVar1 + "," + testVar2); не имеет доступа к не статическим полям
            System.out.println("These are static variables: " + staticVar1 + "," + staticVar2);
            //System.out.println("This is a non-static method");
            //estVoid(); //не имеет доступа к не статическим методам
            System.out.println("This is a static method");
            staticTestVoid();
        }
    }

    private static void someVoid(int p, int m, Name name, String s, Long l) {
        System.out.println("PARAMETERS TEST");
        System.out.println("int " + p);
        System.out.println("int " + m);
        System.out.println(name.getClass() + "\n" + name.toString());
        System.out.println(s.getClass() + s);
        System.out.println(l.getClass() + "\n" + l.toString());
        System.out.println();
    }

    private static void someVoid(Object[] args) {
        System.out.println("OBJECT[] TEST");
        for (int i = 0; i < args.length; i++)
            System.out.println(args[i].getClass() + "\n" + args[i].toString());
        System.out.println();
    }

    private static void someVoid(long... ll) {
        System.out.println("VARARGS TEST");
        long sum = 0;
        for (long L : ll) {
            sum += L;
        }
        System.out.println("sum:" + sum);
        System.out.println();
    }

    private static void one() {
        Name MyName = new Name("Ivan", "Belozertsev");
        System.out.println(MyName.toString());
    }

    private static void two() {
        someVoid(100, 101, new Name(), "\na string", 500L);
        Object[] arr = {new Long(1231), "blah-blah-blah", new Name("Ostap", "Vishnya"), new Double(8.5), new Integer(666)};
        someVoid(arr);
        someVoid(12312L, 13124L, 111L, 11111L, 94994L, 1L, 2L, 3L);
    }

    private void three() {
        InnerClass iC = new InnerClass();
        iC.testAccessibility();
        StaticNestedClass SiC = new StaticNestedClass();
        SiC.testAccessibility();
    }

    private static void four() {
        String localVariable = "I`m local.";
        final String finalVariable = "I`m final local.";
        //localVariable += "1213";
        class LocalClass {
            private void testAccessibility() {
                System.out.println("This is a local variable:" + localVariable); //Работает, если localVariable "effectively final", то есть не является константой, при этом не изменяется в методе
                System.out.println("This is a final variable:" + finalVariable);
            }
        }


    }

    private static void five() {
        Random random = new Random();
        PrimitiveStreamCipher cipher = new PrimitiveStreamCipher();
        byte[] message = new byte[32];
        byte[] key = new byte[8];
        random.nextBytes(message);
        random.nextBytes(key);
        System.out.println("key:" + Arrays.toString(key));
        System.out.println("message:" + Arrays.toString(message));
        byte[] ciphertext = cipher.encrypt(message, key);
        System.out.println("ciphertext:" + Arrays.toString(ciphertext));
        byte[] decrypted = cipher.decrypt(ciphertext, key);
        System.out.println("decrypted:" + Arrays.toString(decrypted));
    }

    private static void six() {
        Workable[] arr = new Workable[3];
        arr[0] = new Workable() {
            @Override
            public void work() {
                System.out.println("Some work in progress.");
            }

            @Override
            public void rework() {
                System.out.println("Reworking some work.");
            }
        };
        arr[1] = new Workable() {
            @Override
            public void work() {
                System.out.println("Some other work is in progress.");
            }

            @Override
            public void rework() {
                System.out.println("Reworking some other work.");
            }
        };
        arr[2] = new Workable() {
            @Override
            public void work() {
                System.out.println("Completely different work is in progress");
            }

            @Override
            public void rework() {
                System.out.println("Reworking completely different work");
            }
        };
        for (int i = 0; i < arr.length; i++) {
            arr[i].work();
            arr[i].rework();
        }

        new Workable() {
            @Override
            public void work() {
                System.out.println("Completely different work is in progress");
            }

            @Override
            public void rework() {
                System.out.println("Reworking completely different work");
            }
        }.work();

    }

    public static void main(String[] args) {
        /*1).Реализовать собственный класс с несколькими полями и методами, переопределить унаследованный метод toString().*/
        one();

        /*2).Реализовать метод, принимающий пять разнотипных параметров (в т.ч. собственных классов),
        тремя разными способами: с явным заданием пяти разных параметров, через массив object[] и varargs.
        Напечатать на экране тип параметра и его значение (для класса - основные поля).*/
        two();

        /*3).Реализовать вложенный класс, статический вложенный класс, продемонстрировать доступность полей и методов внешнего класса.*/
        new Main().three();

        /*4).Реализовать локальный класс, проверить доступность полей и методов внешнего класса,
        локальных переменных метода (изменяемых и нет), который создает локальный класс.*/
        four();

        /*5).Разработать собственный интерфейс шифрования, на его основе интерфейсы симметричного и асимметричного шифрования, на основе симметричного - блочного и поточного шифрования.
        Создать класс, реализующий интерфейс поточного шифрования (XOR с константой) со статическим методом, на вход принимающим байтовый массив и возвращающий его же на выходе.
        Задать начальное значение массива, зашифровать и расшифровать, напечатать каждый из результатов.*/
        five();

        /*6).Создать три анонимных класса на основе интерфейса,
         продемонстрировать полиморфизм. Создать анонимный класс, вызвать его методы без определения локальной переменной.*/
        six();

    }
}
