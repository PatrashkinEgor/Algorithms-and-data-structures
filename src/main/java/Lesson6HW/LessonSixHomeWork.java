package Lesson6HW;
import java.util.Random;

/**
 * Algorithms and data structures. Lesson 6. Homework
 *
 * @author Egor Patrashkin
 * @version dated Oct 20, 2018
 */

/**
 * 1. Создать программу для построения двоичного дерева. В цикле построить двадцать деревьев с глубиной в 6 уровней.
 * Данные, которыми необходимо заполнить узлы деревьев представляются в виде чисел типа int.
 * Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
 * Запустить программу.
 * 2. Проанализировать, какой процент созданных деревьев является несбалансированными.
 */


/**
 * Для выполнения задания в класс Tree были добавлены методы isTreeBalanced() и countNodes(), а также модернизирован
 * метод insert.
 */



public class LessonSixHomeWork {
    public  static void main(String[] args) {
        final int numbOfTrees = 20; // Количество деревьев
        final int numbOfLevels = 6; // Граничное число уровней
        final int delta = 3;        // Допустимое отклонение в размерах левой и правой ветви дерева

        int amountOfBalancedTrees = 0;  // Количество сбалансированных деревьев
        for (int i = 0; i < numbOfTrees ; i++) {
            Tree theTree = new Tree();
            while(theTree.insert(new Num(getRandom()))!=numbOfLevels){ } // Метод insert модернизирован и возвращает
            // уровень на который был вставлен элемент
            System.out.println("Tree number " + i);
            if(theTree.isTreeBalanced(delta)) {
                amountOfBalancedTrees++;
                System.out.println("Tree is balanced");
            } else {
                System.out.println("Tree is not balanced");
            }
            System.out.println("-------------------------------------------------");
        }
        System.out.println((amountOfBalancedTrees*100)/numbOfTrees  + "% of trees are balanced");

    }


private static int getRandom(){
    Random rand = new Random();
    return (100 - rand.nextInt(200));
}

}
