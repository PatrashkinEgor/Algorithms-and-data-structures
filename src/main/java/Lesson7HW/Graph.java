package Lesson7HW;

import Lesson3HW.Queue;
import Lesson3HW.Stack;

public class Graph {
    private final int MAX_VERTS = 32;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int size;
    private Stack stack;
    private Queue queue;

    public Graph(){
        stack = new Stack(MAX_VERTS);
        queue = new Queue(MAX_VERTS);
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }

        }
    }

    /**
     *  Метод для ДЗ к уроку 7.  Ищет минимальный путь от vertToStart до vertToFind, при помощи обхода в ширину.
     * @param vertToStart точка старта
     * @param vertToFind    точка поиска
     */
    public void findShortestWayTo(int vertToStart, int vertToFind){
        vertexList[vertToFind].wasVisited = true;
        //displayVertex(0);
        queue.insert(vertToFind); // Вставка в конец очереди
        int v2 = vertToFind;
        int way = 0;

        while(!queue.isEmpty()){
            int v1 = queue.remove();

            while((v2=getAdjUnvisitedVertex(v1)) != -1){

                if (vertexList[v2].wasVisited != true){
                    vertexList[v2].parent = v1;
                    vertexList[v2].wasVisited = true; // Пометка
                    queue.insert(v2);
                }

                if (v2 == vertToStart){
                    System.out.println("The shortest way from "
                            + vertexList[vertToStart].label + " to " + vertexList[vertToFind].label+ " is:");
                    int temp = v2;
                    while (temp !=vertToFind){
                        way++;
                        System.out.print(vertexList[temp].label + " -> ");
                        temp = vertexList[temp].parent;
                    }
                    System.out.println(vertexList[temp].label + ".");
                    System.out.println("Way lenght = " + way);
                    queue.reset();
                    break;
                }
            }
        }

        for(int i=0; i<size; i++) { // Сброс флагов
            vertexList[i].wasVisited = false;
            vertexList[i].parent= 0;
        }

    }
    private int getAdjUnvisitedVertex(int ver){
        for (int i = 0; i < size; i++) {
            if(adjMat[ver][i] == 1 && vertexList[i].wasVisited == false){
                return i;
            }
        }

        return -1;
    }

    public void dfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1){
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }

        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }






    public void addVertex(char label){
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex){
        System.out.println(vertexList[vertex].label);
    }
}
