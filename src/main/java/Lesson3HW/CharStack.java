package Lesson3HW;

public class CharStack {
    private int maxSize;
    private char[] stack;
    private int top;

    public CharStack(int size){
        this.maxSize = size;
        this.stack = new char[this.maxSize];
        this.top = -1;
    }

    public void push(char c){
        this.stack[++this.top] = c;
    }

    public char pop(){
        return this.stack[this.top--];
    }

    public char peek(){
        return this.stack[this.top];
    }

    public boolean isEmpty(){
        return (this.top == -1);
    }

    public boolean isFull(){
        return (this.top == this.maxSize-1);
    }

    @Override
    public String toString() {
        return getClass().getName() + " Number of elements ="  + (top+1) ;
    }
}
