package Lesson5HW;

/**
 * Algorithms and data structures. Lesson 5. Homework
 *
 * @author Egor Patrashkin
 * @version dated Oct 16, 2018
 */

/**
 * Задание:
 * 1. Написать программу по возведению числа в степень с помощью рекурсии.
 */

public class Power {
    public static void main(String[] args){
        while(true){

            switch (WorkWithConsole.getCommand("1-Raise a number to a power, 2-Exit", 2)){
                case 1:
                    int base = WorkWithConsole.getInt("Enter the number");
                    int power = WorkWithConsole.getInt("Enter the power");
                    System.out.println(raiseToAPower(base,power));
                    break;
                case 2:
                    System.exit(0);
            }
        }
    }


    /**
     * Метод осуществляющий возведение числа в степень при помощи рекурсии. Переполнение не отлавливал.
     * В качестве идеи для реализации - считать в BigInteger, не додумал как реализоватью
     * @param base основание
     * @param power степень
     * @return результат возведения в степень
     */
    public static long raiseToAPower(int base, int power){

        if (power == 0){
            return 1;
        } else if (power == 1){
            return base;
        } else {
            return base*raiseToAPower(base,power-1);
        }
    }


}
