package Lesson7HW;

/**
 * algorithms and data structures. Lesson 7. Homework
 *
 * @author Egor Patrashkin
 * @version dated Oct 24, 2018
 */


/**
 *Задание:
 * 1. Реализовать программу, в которой задается граф из 10 вершин. Задать ребра и попробовать найти минимальный
 * кратчайший путь с помощью поиска в ширину.
 */

public class LessonSevenHomeWork {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');   //  0
        graph.addVertex('B');   //  1
        graph.addVertex('C');   //  2
        graph.addVertex('D');   //  3
        graph.addVertex('E');   //  4
        graph.addVertex('F');   //  5
        graph.addVertex('G');   //  6
        graph.addVertex('H');   //  7
        graph.addVertex('I');   //  8
        graph.addVertex('J');   //  9

        graph.addEdge(0, 2); //AC
        graph.addEdge(2, 1); //CB
        graph.addEdge(2, 4); //CE
        graph.addEdge(2, 7); //CH
        graph.addEdge(1, 5); //BF
        graph.addEdge(4, 9); //EJ
        graph.addEdge(4, 9); //EI
        graph.addEdge(7, 3); //HD
        graph.addEdge(5, 6); //FG
        graph.addEdge(9, 6); //JG
        graph.addEdge(8, 9); //IJ



        graph.findShortestWayTo( 0, 9);
        graph.findShortestWayTo( 4, 5);
        graph.findShortestWayTo( 6, 3);
    
    }

}
