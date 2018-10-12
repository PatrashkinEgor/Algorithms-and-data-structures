package Lesson3HW;

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
 * 1. Реализовать рассмотренные структуры данных в консольных программах.
 * 2. Создать программу, которая переворачивает вводимые строки (Читает справа налево).
 * 3. Создать класс для реализации дека.
 */
public class LessonThreeHomeWork {
    public static void main(String[] args) {
        int command = getCommand("1-Stack, 2-Queue, 3-Deck, 4-String reverse", 4);
        switch (command){
            case 1:
                runStack();
                break;
            case 2:
                runQueue();
                break;
            case 3:
                runDeque();
                break;
            case 4:
                runStringReverse();
                break;
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

    /**
     * Метод предназначен для получения целочисленного значения из консоли и отлова исключений.
     * @return целочисленное значение введенное с консоли.
     */
    static int getInt(){
        int number;
        Scanner sc = new Scanner(System.in);
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
     * Метод заполняет дек и забирает из него значения при помощи консоли
     */
    static  void runDeque(){
        Deque deque = new Deque(10);
        while (true){
            int dequeCommand = getCommand("1-Insert left Element, 2-Remove left element, 3-Insert right Element, 4-Remove right element, 5 - Exit", 5);
            switch (dequeCommand){
                case 1:
                    if (!deque.isFull()) {
                        deque.insertLeft(getInt());
                    } else {
                        System.out.println("Deque is full!");
                    }
                    break;
                case 2:
                    if (!deque.isEmpty()) {
                        System.out.println(deque.removeLeft());
                    } else {
                        System.out.println("Deque is empty!");
                    }
                    break;
                case 3:
                    if (!deque.isFull()) {
                        deque.insertRight(getInt());
                    } else {
                        System.out.println("Deque is full!");
                    }
                    break;
                case 4:
                    if (!deque.isEmpty()) {
                        System.out.println(deque.removeRight());
                    } else {
                        System.out.println("Deque is empty!");
                    }
                    break;
                case 5:
                    System.exit(0);
            }
            System.out.println(deque.toString());
        }
    }
    /**
     * Метод заполняет очередь и забирает из нее значения при помощи консоли
     */
    static  void  runQueue(){
        Queue queue = new Queue(10);
        while (true){
            int queueCommand = getCommand("1-Insert Element, 2-Remove element, 3 - Exit", 3);
            switch (queueCommand){
                case 1:
                    if (!queue.isFull()){
                        queue.insert(getInt());
                    } else {
                        System.out.println("Queue is full!");
                    }
                    break;
                case 2:
                    if (!queue.isEmpty()) {
                        System.out.println(queue.remove());
                    } else {
                        System.out.println("Queue is empty!");
                    }
                    break;
                case 3:
                    System.exit(0);
            }
            System.out.println(queue.toString());
        }
    }

    /**
     * Метод заполняет стек и забирает из него значения при помощи консоли
     */
    static void runStack(){
        Stack stack = new Stack(10);
        while (true){
            int stackCommand = getCommand("1-Push Element, 2-Pop element, 3 - Exit", 3);
            switch (stackCommand){
                case 1:
                    if (!stack.isFull()) {
                        stack.push(getInt());
                    } else {
                        System.out.println("Stack is full!");
                    }
                    break;
                case 2:
                    if (!stack.isEmpty()){
                        System.out.println(stack.pop());
                    }
                    else {
                        System.out.println("Stack is empty!");
                    }
                    break;
                case 3:
                    System.exit(0);
            }
            System.out.println(stack.toString());
        }
    }

    /**
     * Метод переворасивает строку при помощи класса CharStack. Можно было все сделать при помощи StringBuilder,
     * но ,если я правильно понял, смысл урока был именно в использовании стека.
     */
    static void runStringReverse(){
        while (true) {
            int command = getCommand("1-Reverse string, 2 - Exit", 2);
            switch (command) {
                case 1:
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter the string");
                    String string = new String(sc.nextLine());
                    CharStack charStack = new CharStack(string.length());
                    for (int i = 0; i < string.length(); i++) {
                        charStack.push(string.charAt(i));
                    }
                    for (int i = 0; i < string.length(); i++) {
                        System.out.print(charStack.pop());
                    }
                    System.out.println();
                    break;

                case 2:
                    System.exit(0);
            }
        }
    }
}
