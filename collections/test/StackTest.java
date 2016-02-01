import Collections.Stack;
import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author lortiz208
 */
public class StackTest {
    
    private Stack stack;
    
    @Before
    public void setup() {
        stack = new Stack(10);
    }
    
    @After
    public void tearDown() {
        stack = null;
    }
    
    @Test
    public void pushShouldAddElement() {
        stack.push(2);
        
        assertEquals(1, stack.size());
    }
    
    @Test
    public void popShouldRemoveElement() {
        stack.push(23);
        stack.push(32);
        stack.push(54);
        
        int item = (int) stack.pop();
        assertEquals(54, item);
    }
    
    @Test
    public void isEmptyShouldReturnTrueWhenSizeIsZero() {
        stack.push(23);
        stack.push(34);
        stack.pop();
        stack.pop();
        assertTrue(stack.isEmpty());
    }
    
    @Test
    public void isEmptyShouldReturnFalseWhenSizeIsGreaterThanZero() {
        stack.push(23);
        stack.push(34);
        assertFalse(stack.isEmpty());
    }
    
    @Test
    public void isFullShouldReturnTrueWhenStackIsFull() {
        for(int i = 0; i < 10; i++) {
            stack.push(i);
        }
        assertTrue(stack.isFull());
    }
    
    @Test
    public void isFullShouldReturnFalseWhenStackIsNotFull() {
        for(int i = 0; i < 9; i++) {
            stack.push(i);
        }
        assertFalse(stack.isFull());
    }
    
    @Test
    public void peekShouldReturnTopElementWithoutRemoval() {
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(9);
        
        int item = (int) stack.peek();
        assertEquals(5, stack.size());
        assertEquals(9, item);
    }
}
