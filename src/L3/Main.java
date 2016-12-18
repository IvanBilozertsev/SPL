package L3;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Ivan on 16.12.2016.
 */
public class Main {

    private static void bubbleSort(int length){
        int[] array = new int[length];
        Random random = new Random();
        for(int i = 0; i < array.length; i++)
            array[i] = random.nextInt(1000);
        System.out.println(Arrays.toString(array));
        int j;
        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;
            for(j = 0; j < array.length -1; j++) {
                if ( array[j] > array[j+1] ){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private static void one(){
        bubbleSort(new Random().nextInt(1000));
    }

    private static void two(){
        Random random = new Random();
        int[][] arr = new int[random.nextInt(20)][];
        System.out.println("UNSORTED MATRIX");
        for(int i = 0; i < arr.length; i++){
            arr[i] = new int[random.nextInt(10)];
            for(int j = 0; j < arr[i].length; j++)
                arr[i][j] = random.nextInt(50) - random.nextInt(50);
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("\nSORTED MATRIX");
        for(int i = 0; i < arr.length; i++){
            Arrays.sort(arr[i]);
            System.out.println(Arrays.toString(arr[i]));
        }


        System.out.println("\nSORTED MATRIX(only negative values)");
        for(int i = 0; i < arr.length; i++){
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++){
                if(arr[i][j] < 0)
                    System.out.print(arr[i][j] + " ");
                else
                    break;
            }
            System.out.println("]");
        }
    }

    private static void three(){
        Name Me = new Name("Ivan","Belozertsev");
        System.out.println(Me.name);
        //System.out.println(Me.surname);не доступен
    }

    private static void four(){
        Name SomeName = new Name();
        Name MyName = new Name("Ivan","Belozertsev");
        Name MyCloneName = new Name(MyName);
    }

    private static void five(){
        Sedan sedan1 = new Sedan("VW Passat CC", FuelType.PETROL, 70, 4, 300, 8, 150);
        Sedan sedan2 = new Sedan("VW Passat B5", FuelType.PETROL, 50, 4, 250, 6, 170);
        Lorry lorry1 = new Lorry("MAN TGX 18.480 4X2 BLS-EL", FuelType.DIESEL, 700, 2, 20, 18000, 800);
        ArrayList<Car> Parking = new ArrayList<>();
        Parking.add(sedan1);
        Parking.add(sedan2);
        Parking.add(lorry1);
        for(int i = 0; i < Parking.size(); i++){
            Parking.get(0).driveSomewhere(50);
            Parking.remove(0);
        }
    }

    public static void main(String[] args) {
        /*1).При помощи статического метода реализовать пузырьковую сортировку массива целых чисел
        (длина массива задается при вызове метода сортировки).*/
        one();

        /*2).Задана “неровная матрица” (или ступенчатый массив - двумерный массив,
        строки в котором имеют различную длину: int [][] arr; arr = new int[ 5 ][]; arr[ 0 ] = new int[ 3 ]; arr[ 1 ] = new int[ 7 ]; и т.д.).
        Матрица содержит целые значения. Отсортировать каждую строку (использовать Arrays.sort() ), распечатать матрицу на экране.
        Повторно распечатать матрицу, но выводить на экран только отрицательные значения (использовать цикл с break).*/
        two();

        /*3).Создать собственный класс с полями доступа public и private, проверить их доступность из другого класса текущего пакета.*/
        three();

        /*4).Сделать класс с перегруженными конструкторами (по умолчанию, с заданными параметрами, создание копии другого объекта).*/
        four();

        /*5.	Сделать абстрактный класс “автомобиль” и его наследников (“легковой”, “грузовой” и т.п.),
        продемонстрировать полиморфные методы (вывод названия автомобиля, перемещение за единицу времени, вывод потребленного топлива,
        перевезенного груза и пассажиров, загрязнение окружающей среды; предусмотреть возможности для электромобилей).*/
        five();

    }
}
