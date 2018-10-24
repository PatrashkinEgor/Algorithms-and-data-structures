package Lesson5HW;
/**
 * Algorithms and data structures. Lesson 5. Homework
 *
 * @author Egor Patrashkin
 * @version dated Oct 16, 2018
 */

/**
 * Задание:
 * 2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
 * Задача о рюкзаке относится к классическим задачам программирования. В простейшей
 * форме этой задачи рюкзак требуется заполнить предметами различного
 * веса для достижения заданного суммарного веса. Укладывать в рюкзак все предметы
 * не обязательно.
 *
 */
public class BackpackProblem {
    static  int[] weithOfItems = {11,8,7,6,5};
    static  int backpackVolume = 13;



    public static void main(String[] args){
        System.out.println(putItem(backpackVolume,0));


    }


    /**
     *
     * @param target Целевой вес. Уменьшается по мере укладки вещей.
     * @param pt "Указатель" на вещь с которой начинаем рассматривать последовательность.
     * @return true если есть комбинация из вещей с целевым весом, false если нет.
     */
    static boolean putItem(int target, int pt){
        for (int i = pt; i < weithOfItems.length; i++){
            if (weithOfItems[i]== target){
                    System.out.print(weithOfItems[i] + " ");
                    return true;
            } else {
                if (putItem( (target-weithOfItems[i]), (i+1))){
                    System.out.print(weithOfItems[i] + " ");
                    return true;
                }
            }
        }
        return false;
    }
}
