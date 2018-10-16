package Lesson5HW;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Algorithms and data structures.
 * Класс для работы с консолью
 * @author Egor Patrashkin
 * @version dated Oct 16, 2018
 */


public  class WorkWithConsole {
    /**
     * Метод предназначен для получения целочисленного значения из консоли и отлова исключений.
     * @param message Выводимое пользователю сообщение
     * @return целочисленное значение введенное с консоли.
     */
    static int getInt(String message){
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        while (true){

            try {
                System.out.println("Enter an integer");
                number = sc.nextByte();
                return number;
            } catch (InputMismatchException ex) {
                System.out.println("Incorrect input format!");
                sc.next();
            }
        }
    }


    /**
     * Метод выводит сообщение и получает номер команды из консоли, при жтом отлавливает эксепшены.
     * Нужен для выполнения "меню" при выполнении проверки написанных методов.
     * @param message Выводимое пользователю сообщение
     * @param numberOfOptions   количество вариантов отвта
     * @return  номер выбранного варианта
     */
    static int getCommand(String message, int numberOfOptions){
        int command;
        Scanner sc = new Scanner(System.in);
        while (true){
            try {
                System.out.println(message);
                command = sc.nextByte();
                if ((command > 0) && (command <= numberOfOptions)) {
                    return command;
                } else {
                    System.out.println("Incorrect input format!");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Incorrect input format!");
                sc.next();
            }
        }
    }


}
