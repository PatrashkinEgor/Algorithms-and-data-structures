package Lesson4HW;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * algorithms and data structures. Lesson 3. Homework
 *
 * @author Egor Patrashkin
 * @version dated Oct 10, 2018
 */


/**
 *Задание:
 * 1. Реализовать все классы, рассмотренные в данном уроке.
 * 2. В методе main LinkIteratorApp проверить все методы итератора.
 */


public class LinkIteratorApp {


    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        LinkInterator itr = new LinkInterator(list);


        while (true) {
            int command = getCommand("1-insertAfter, 2-InsertBefore, 3-Reset, 4-Get current, 5-Delete Current, " +
                    "6-Next link, 7-Show all list, 8-Exit.", 8);
            switch (command) {
                case 1:
                    itr.insertAfter(getStr(),getInt());
                    break;
                case 2:
                    itr.insertBefore(getStr(),getInt());
                    break;
                case 3:
                    itr.reset();
                    break;
                case 4:
                    Link tempLink = itr.getCurrent();

                    System.out.println(tempLink == null? "Link is null": tempLink.toString());
                    break;
                case 5:
                    if (list.isEmpty()) {
                        System.out.println("List is Empty!");
                    } else {
                        itr.deleteCurrent();
                    }
                    break;
                case 6:
                    if (list.isEmpty()) {
                        System.out.println("List is Empty!");
                    } else if (itr.atEnd()){
                        System.out.println("Itr is at the end of the list!");
                    } else {
                        itr.nextLink();
                    }
                    break;
                case 7:
                    list.display();
                    break;
                case 8:
                    System.exit(0);

            }
        }
        /*itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);
        itr.insertAfter("J", 40);

        list.display();*/
    }

    /**
     * Метод из ДЗ 3. Выводит сообщение и получает номер команды из консоли, при жтом отлавливает эксепшены.
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


    /**
     * Метод из ДЗ 3. Предназначен для получения целочисленного значения из консоли и отлова исключений.
     * @return целочисленное значение введенное с консоли.
     */
    static int getInt(){
        int number;
        Scanner sc = new Scanner(System.in);
        while (true){

            try {
                System.out.println("Enter the age");
                number = sc.nextByte();
                return number;
            } catch (InputMismatchException ex) {
                System.out.println("Incorrect input format!");
                sc.next();
            }
        }
    }


    /**
     * Метод из ДЗ 3. Предназначен для получения строки из консоли и отлова исключений.
     * @return целочисленное значение введенное с консоли.
     */
    static String getStr(){
        String str;
        Scanner sc = new Scanner(System.in);
        while (true){

            try {
                System.out.println("Enter the name");
                str= sc.next();
                return str;
            } catch (InputMismatchException ex) {
                System.out.println("Incorrect input format!");
                sc.next();
            }
        }
    }

}


