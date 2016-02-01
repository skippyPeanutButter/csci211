package Collections;

import java.util.NoSuchElementException;

/**
 *
 * @author Luis Ortiz
 */
public class LinkedList<E> {

    private Node<E> head = null;
    private int size = 0;

    public void add(E data) {
        // add it as first element in list
        if (empty()) {
            addFirst(data);
        } else {
            Node<E> temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<E>(data);
            size++;
        }
    }// end add
    
    public void addFirst(E data) {
        head = new Node<E>(data, head);
        size++;
    }// end addFirst
    
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }// end if
        
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }// end for
        
        return node.data;
    }// end get
    
    public E getFirst() {
        if (empty()) {
            throw new NoSuchElementException();
        }
        return head.data;
    }// end getFirst
    
    public E getLast() {
        if (empty()) {
            throw new NoSuchElementException();
        }
        
        Node<E> temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }// end getLast
    
    public E removeFirst() {
        if (empty()) {
            throw new NoSuchElementException();
        }
        
        Node<E> removedElement = head;
        head = head.next;
        size--;
        return removedElement.data;
    }
    
    public E removeLast() {
        if (empty()) {
            throw new NoSuchElementException();
        }
        // head is the only element
        Node<E> removedElement;
        if (head.next == null) {
            removedElement = head;
            head = null;
        } else {
            Node<E> current = head.next;
            Node<E> previous = head;
            while(current.next != null) {
                previous = current;
                current = current.next;
            }// end while
            previous.next = current.next;
            removedElement = current;
        }// end if
        
        size--;
        return removedElement.data;
    }
    
    public int size() {
        return size;
    }// end size
    
    public String toString() {
        String result = "[";
        Node<E> temp = head;
        while(temp != null) {
            result += temp.data.toString() + ",";
            temp = temp.next;
        }
        result.replace(",]", "]");
        return result;
    }// end toString
    
    public void clearList() {
        head = null;
    }// end clearList
    
    private boolean empty() {
        return head == null;
    }// end empty
    
    /**
     * Node is the building block for a linked list.
     * It holds data and a link to another node object.
     */
    private static class Node<E> {
        // 
        private E data;
        private Node<E> next;
        
        /**
         * Constructor that accepts data and
         * sets the next reference to null.
         * @param data The data to hold
         */
        private Node(E data) {
            this.data = data;
            this.next = null;
        }// end Node
        
        /**
         * Constructor that accepts data and a
         * node to reference.
         * @param data The data to hold
         * @param next The next node in the link
         */
        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }// end Node
        
    }// end class Node<E>
    
}// end LinkedList
