package Lesson2HW;

import java.util.Random;

/**
 * algorithms and data structures. Lesson 2. Homework
 *
 * @author Egor Patrashkin
 * @version dated Oct 08, 2018
 */


/**
 *Задание:
 * 1. Создать массив большого размера (миллион элементов).
 * 2. Написать методы удаления, добавления, поиска элемента массива.
 * 3. Заполнить массив случайными числами.
 * 4. Написать методы, реализующие рассмотренные виды сортировок и проверить скорость выполнения каждой.
 */

public class LessonTwoHomeWork {


    public static void main(String[] args){
        Random rand = new Random();
        final int SIZE = 1000000;
        NewArr myArr = new NewArr(SIZE);
        for (int i = 0; i < SIZE; i++) {
            myArr.addElement(rand.nextInt(10));
        }
        NewArr myArr1 = new NewArr(SIZE);
        for (int i = 0; i < SIZE; i++) {
            myArr1.addElement(rand.nextInt(10));
        }
        NewArr myArr2 = new NewArr(SIZE);
        for (int i = 0; i < SIZE; i++) {
            myArr2.addElement(rand.nextInt(10));
        }


        long startTime = System.currentTimeMillis();
        myArr.sortBubble();
        System.out.println("Время выполнения пузырьковой сортировки:");
        System.out.println((System.currentTimeMillis() - startTime) + " млС ");

        startTime = System.currentTimeMillis();
        myArr1.sortInsert();
        System.out.println("Время выполнения сортировки методом вставки:");
        System.out.println((System.currentTimeMillis() - startTime) + " млС ");

        startTime = System.currentTimeMillis();
        myArr2.sortSelect();
        System.out.println("Время выполнения сортировки методом выбора:");
        System.out.println((System.currentTimeMillis() - startTime) + " млС ");

    }
}
