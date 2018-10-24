package Lesson7HW;

public class Vertex {
    public char label;
    public boolean wasVisited;
    public  int parent;

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }
}
