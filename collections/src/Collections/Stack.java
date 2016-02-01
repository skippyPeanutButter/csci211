/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

/**
 *
 * @author lortiz208
 */
public class Stack<E> {
    
    private LinkedList<E> list;
    private int top;
    private int maxSize;
    
    public Stack(int maxSize) {        
        this.maxSize = maxSize;
        list = new LinkedList<E>();
        top = -1;
    }
    
    public void push(E item) {
        if (isFull()) {
            System.out.println("Stack is full");
        }
        
        list.add(item);
        top++;
    }
    
    public E pop() {
        E item = list.removeLast();
        top--;
        
        return item;
    }
    
    public E peek() {
        E item = list.getLast();
        return item;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == maxSize - 1;
    }
    
    public int size() {
        return top + 1;
    }
}
