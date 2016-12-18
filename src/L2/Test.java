package L2;

import java.util.*;

/**
 * Created by Ivan on 14.12.2016.
 */
public class Test {

    private int A;

    private static void one(){
        Random random = new Random();

        boolean b0;
        boolean b1 = true;
        boolean b2 = random.nextBoolean();
        System.out.println("BOOLEAN:");
        System.out.println(b1);
        System.out.printf("%b\n", b1);
        System.out.println();

        char c0;
        char c1 = 'c';
        char c2 = Character.toChars(111)[0];
        System.out.println("CHAR:");
        System.out.println(c1);
        System.out.printf("%c\n", c1);
        System.out.println();

        byte byte0;
        byte byte1 = 123;
        byte byte2 = (byte) random.nextInt(256);
        System.out.println("BYTE:");
        System.out.println(byte1);
        System.out.printf("%d\n", byte1);
        System.out.printf("hex:%x\n", byte1);
        System.out.println();

        short s0;
        short s1 = 1234;
        short s2 = (short) random.nextInt(16000);
        System.out.println("SHORT:");
        System.out.println(s1);
        System.out.printf("%d\n", s1);
        System.out.printf("hex:%x\n", s1);
        System.out.println();

        int i0;
        int i1 = 12345;
        int i2 = random.nextInt();
        System.out.println("INTEGER:");
        System.out.println(i1);
        System.out.printf("%d\n", i1);
        System.out.printf("hex:%x\n", i1);
        System.out.println();

        long l0;
        long l1 = 123456;
        long l2 = random.nextLong();
        System.out.println("LONG:");
        System.out.println(l1);
        System.out.printf("%d\n", l1);
        System.out.printf("hex:%x\n", l1);
        System.out.println();

        float f0;
        float f1 = 123.123f;
        float f2 = random.nextFloat();
        System.out.println("FLOAT:");
        System.out.println(f1);
        System.out.printf("%f\n", f1);
        System.out.println();

        double d0;
        double d1 = 1234.1234;
        double d2 = random.nextDouble();
        System.out.println("DOUBLE:");
        System.out.println(d1);
        System.out.printf("%f\n", d1);
        System.out.println();
    }

    private static void two(){
        //приведение целочисленных типов с допустимым расширением диапазона
        byte b = 127;
        int i = b;
        //приведение double к float, float к int с некорректным преобразованием (переполнением)
        double d = 1.91123421423646462341319647162304;
        float f = (float)d;
        int I = (int)f;
        System.out.println(Double.toString(d));
        System.out.println(Float.toString(f));
        System.out.println(I);
    }

    private void three() {
        int a;
        //System.out.println(a);
        System.out.println(A);

    }

    private static void four(){
        int[] array = {22, 333, 44, 55, 66, 7, 7, 73, 123, 83838383};
        String[] week = {"monday", "tuesday", "wednesday", "thursday", "friday"};

        System.out.println("Loop:");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
        for (int i = 0; i < week.length; i++)
            System.out.print(week[i] + " ");
        System.out.println();
        System.out.println("Arrays.toString:");
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(week));
        System.out.println();
        System.out.println("Arrays.asList:");
        System.out.println(Arrays.asList(array) + "\\_(*-*)_/");
        Integer[] Array = {22, 333, 44, 55, 66, 7, 7, 73, 123, 83838383};
        System.out.println(Arrays.asList(Array));
        System.out.println(Arrays.asList(week));
        System.out.println();
    }

    private static void five() {
        System.out.println("ENUM TEST!\nLets decide on your soviet workout uniform today.\nWhat is the temperature like outside?");
        Scanner in = new Scanner(System.in);
        try {
            int i = in.nextInt();
            if (i >= -5 & i < 40) {
                if (i > 25)
                    i = 25;
                if (i > 5 & i < 25)
                    i = 15;
                if (i > -5 & i < 5)
                    i = 0;
            } else if (i <= -5 & i > -30) {
                if (i < -5 & i > -25)
                    i = -15;
                if (i < -25)
                    i = -25;
            }
            WorkoutUniform uniform;
            switch (i) {
                case 25:
                    uniform = WorkoutUniform.N1;
                    break;
                case 15:
                    uniform = WorkoutUniform.N2;
                    break;
                case 0:
                    uniform = WorkoutUniform.N3;
                    break;
                case -15:
                    uniform = WorkoutUniform.N4;
                    break;
                case -25:
                    uniform = WorkoutUniform.N5;
                    break;
                default:
                    uniform = WorkoutUniform.NONE;
                    break;
            }
            if (uniform == WorkoutUniform.NONE)
                System.out.println("Weather is too bad for workout, comrade.\n\n");
            else
                System.out.println("Okay, let it be:" + "\"" + uniform.getValue() + "\"\n" + "NA ZARYADKU, comrade!\n\n");
        } catch (Exception e) {
            System.out.println("Something went wrong, it might probably be incorrect input.\n");
        }
    }

    private static void six(){

    }

    private static void seven(){
        int a = 0xFFFFAA;
        int b = 0xAAAAFF;
        int c = 0xFFFFFFFA;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("-----a-----");
        System.out.println("a << 2 = " + (a << 2));
        System.out.println("a >> 3 = " + (a >> 3));
        System.out.println("a >>> 3 = " + (a >>> 3));
        System.out.println();
        System.out.println("-----b-----");
        System.out.println("b << 2 = " + (b << 2));
        System.out.println("b >> 3 = " + (b >> 3));
        System.out.println("b >>> 3 = " + (b >>> 3));
        System.out.println();
        System.out.println("-----c-----");
        System.out.println("c << 2 = " + (c << 2));
        System.out.println("c >> 3 = " + (c >> 3));
        System.out.println("c >>> 3 = " + (c >>> 3));
        System.out.println();
    }

    private static void eight(){
        try {
            final int MaxStoreys = 9;
            Scanner in = new Scanner(System.in);
            System.out.println("INPUT TEST!\nWhat storey do you live on?\n");
            String decision = "";
            int answer = in.nextInt();
            if (answer > MaxStoreys)
                decision += "It`s impossible! The building only has 9 storeys.";
            else if (answer < 0)
                decision += "It`s impossible! The building only has 9 storeys.";
            else
                decision += "Ok.";
            System.out.println(decision);
        } catch (Exception e) {
            System.out.println("Incorrect input!\n");
        }
    }

    private static void nine(){
        int num = 1;
        int multiplication = 1;
        ArrayList<Integer> set = new ArrayList<>();
        while((multiplication *= num) < 10000){
            set.add(num);
            num += 2;
        }
        System.out.println(set.toString());
    }

    private static void ten(){
        System.out.println("Sieve of Eratosthenes!\nEnter number limit:");
        try{
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            if(n > 0){
                int[] array = new int[n];
                for(int j = 0; j < n; j++)
                    array[j] = j;
                long time = System.currentTimeMillis();
                int sqrtN = (int)Math.sqrt(n);
                for(int j1 = 2; j1 <= sqrtN; j1++){
                    if(array[j1] != 0)
                        for(int j2 = j1+j1; j2 < n; j2 += j1){
                            array[j2] = 0;
                        }
                }
                long time1 = System.currentTimeMillis();
                System.out.println(time1-time);
                //for(int i = 0; i < array.length; i++)
                //    if(array[i] != 0)
                //        System.out.print(array[i] + " ");
            }else{
                System.out.println("Incorrect input!");
            }

        }catch (Exception e){
            System.out.println("Incorrect input!");
        }

    }

    private enum WorkoutUniform {
        NONE("---"),
        N1("трусы"),
        N2("брюки,голый торс"),
        N3("брюки, нательная рубаха"),
        N4("брюки, гимнастерка с расстегнутым воротником и ослабленным поясом"),
        N5("брюки, гимнастерка, шапка и перчатки");
        private final String value;

        WorkoutUniform(String s) {
            value = s;
        }

        public String getValue() {
            return value;
        }
    }


    public static void main(String[] args) {
        /*1).Объявить переменные всех примитивных типов: без инициализации, инициализацией и с вычислением при инициализации.
        Распечатать их значения (System.out.println(), System.out.printf()).
        Целочисленные значения вывести в десятичном и шестнадцатеричном формате.*/
        //one();

        /*3). Объявить две переменные без инициализации: как поле класса и как локальную переменную в методе.
        Вывести их на печать и пояснить отличие.*/
        //new Test().three();
        /*Отличие состоит в том, что из-за неинициализированной локальной переменной программа выдаст ошибку на этапе компиляции,
        * а в слечае с полем класса - напечатает "0" */

        /*4). Объявить массивы целых значений и строк. Вывести их на печать минимум двумя разными способами.*/
        //four();

        /*5). Создать собственное перечисление (enum).
        Ввести с клавиатуры целое число ( Scanner in = new Scanner( System.in ); int i = in.nextInt(); ),
        сопоставить введенное целое со значением перечисления (использовать switch),
        значение перечисления распечатать на экране.*/
        //five();

        /*6).Объявить константы (по собственному выбору).
        Сделать консольный мини-калькулятор (перевод дюймов в сантиметры,
        увеличение скорости в вакууме в зависимости от времени свободного падения и т.п. )*/
        //six();

        /*7).Объявить целые, инициализировать их шестнадцатеричными значениями,
         распечатать, выполнить знаковые и беззнаковые сдвиги, результат тоже распечатать. Пояснить разницу.*/
        //seven();
        /*Разница в том, что знаковый сдвиг производится с сохранением знака(т.е. с заполнением нулями для отрицательного значения),
        * в беззнаковом сдвиге знак игнорируется, отрицательные значения после такого сдвига становятся положительными.*/

        /*8).Ввести целое значение с клавиатуры и проверить допустимость в рамках разрешенного диапазона
        (например, количества этажей в доме, которые объявлены константой). Напечатать, корректно ли введенное значение.*/
        //eight();

        /*9). Напечатать множество неотрицательных нечетных чисел максимальной мощности, чье произведение меньше 10 000 (while)*/
        //nine();

        /*10.	Реализовать решето Эратосфена: найти все простые числа от 2 до n (которое ввести с клавиатуры).*/
        ten();

    }
}
