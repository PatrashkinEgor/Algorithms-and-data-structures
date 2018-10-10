package Lesson3HW;

public class Deque {
    private int maxSize;
    private int[] queue;
    private int left;
    private int right;
    private int items;

    public Deque(int s){
        maxSize = s;
        queue = new int[maxSize];
        left = 0;
        right = -1;
        items = 0;
    }
    public void insertRight(int i){
        if(right == maxSize-1){
            right = -1;
        }
        queue[++right] = i;
        items++;
    }

    public void insertLeft(int i){
        if(left == 0){
            left = maxSize;
        }
        queue[--left] = i;
        items++;
    }

    public int removeLeft(){
        int temp = queue[left++];
        if(left == maxSize){
            left = 0;
        }
        items--;
        return temp;
    }

    public int removeRight(){
        int temp = queue[right--];
        if(right == -1){
            right = maxSize-1;
        }
        items--;
        return temp;
    }

    public int peekLeft(){
        return queue[left];
    }

    public int peekRight(){
        return queue[right];
    }

    public boolean isEmpty(){
        return (items==0);
    }

    public boolean isFull(){
        return (items==maxSize);
    }

    public int size(){
        return items;
    }
}
