/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionsTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import Collections.LinkedList;
import java.util.NoSuchElementException;

/**
 *
 * @author Luis Ortiz`
 */
public class LinkedListTest {
    
    private LinkedList<String> list;
    
    @Before
    public void setup() {
        list = new LinkedList<String>();
    }// end setup
    
    @After
    public void tearDown() {
        list = null;
    }// tearDown
    
    @Test
    public void addShouldAppendNodeToEndOfList() {
        String node1 = "node1";
        String node2 = "node2";
        String node3 = "node3";
        
        list.add(node1);
        list.add(node2);
        list.add(node3);
        
        assertEquals(node3, list.getLast());
    }
    
    @Test
    public void addFirstShouldSetNewHead() {
        String firstHead = "first head";
        String newHead = "new head";
        
        list.addFirst(firstHead);
        assertEquals(firstHead, list.get(0));
        list.addFirst(newHead);
        assertEquals(newHead, list.get(0));
    }
    
    @Test
    public void getShouldReturnElementAtSpecifiedIndex() {
        String node1 = "node1";
        String node2 = "node2";
        String node3 = "node3";
        
        list.add(node1);
        list.add(node2);
        list.add(node3);
        
        assertEquals(node2, list.get(1));
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void getShouldThrowExceptionWhenInvalidIndex() {
        list.get(0);
    }
    
    @Test
    public void getFirstShouldReturnFirstElement() {
        String node1 = "node1";
        String node2 = "node2";
        String node3 = "node3";
        
        list.add(node2);
        list.add(node3);
        list.add(node1);
        
        assertEquals(node2, list.getFirst());
    }
    
    @Test(expected = NoSuchElementException.class)
    public void getFirstShouldThrowExceptionWhenEmptyList() {
        list.getFirst();
    }
    
    @Test
    public void getLastShouldReturnLastElement() {
        String node1 = "node1";
        String node2 = "node2";
        String node3 = "node3";
        
        list.add(node1);
        list.add(node3);
        list.add(node2);
        
        assertEquals(node2, list.getLast());
    }
    
    @Test(expected = NoSuchElementException.class)
    public void getLastShouldThrowExpectionWhenEmptyList() {
        list.getLast();
    }
    
    @Test
    public void removeFirstShouldRemoveHead() {
        String node1 = "node1";
        String node2 = "node2";
        String node3 = "node3";
        
        list.add(node1);
        list.add(node3);
        list.add(node2);
        
        String removedElement = list.removeFirst();
        assertEquals(node1, removedElement);
        assertEquals(2, list.size());
    }
    
    @Test(expected = NoSuchElementException.class)
    public void removeFirstShouldThrowExceptionWhenEmpty() {
        list.removeFirst();
    }
    
    @Test
    public void removeFirstShouldEmptyListWithOneElement() {
        String node1 = "node1";
        list.add(node1);
        String removedElement = list.removeLast();
        
        assertEquals(node1, removedElement);
        assertEquals(0, list.size());
    }
    
    @Test
    public void removeLastShouldRemoveLastElement() {
        String node1 = "node1";
        String node2 = "node2";
        String node3 = "node3";
        
        list.add(node1);
        list.add(node3);
        list.add(node2);
        
        String removedElement = list.removeLast();
        assertEquals(node2, removedElement);
        assertEquals(2, list.size());
    }
    
    @Test(expected = NoSuchElementException.class)
    public void removeLastShouldThrowExceptionWhenEmpty() {
        list.removeLast();
    }
    
    @Test
    public void sizeShouldReturnNumberOfNodes() {
        list.add("Node 1");
        list.add("Node 2");
        list.add("Node 3");
        list.add("Node 4");
        list.add("Node 5");
        list.add("Node 6");
        
        assertEquals(6, list.size());
    }
   
}// end LinkedListTest
