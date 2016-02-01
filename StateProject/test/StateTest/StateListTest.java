package StateTest;

import statedriver.StateList;
import statedriver.State;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit tests using Junit 4.10
 * @author Luis Ortiz
 */
public class StateListTest {
    
    private StateList stateList;
    
    @Before
    public void setup() {
        stateList = new StateList();
    }// end setup
    
    @After
    public void teardown() {
        stateList = null;
    }// end teardown
    
    @Test
    public void testSize() {
        int size = 0;
        assertEquals(size, stateList.size());
        
        stateList.add(new State());
        size++;
        assertEquals(size, stateList.size());
    }// end testSize
    
    @Test
    public void testAdd() {
        assertEquals(0, stateList.size());
        
        stateList.add(new State());
        stateList.add(new State());
        stateList.add(new State());
        stateList.add(new State());
        assertEquals(4, stateList.size());
    }// end testAdd
    
    @Test
    public void testDelete() {
        State state1 = new State("Pennsylvania", "Harrisburg", 500000);
        State state2 = new State("Massachusetts", "Boston", 430000);
        State state3 = new State("New York", "Albany", 1000000);
        State state4 = new State("Florida", "Tallahassee", 19000000);
        
        stateList.add(state1);
        stateList.add(state2);
        stateList.add(state3);
        stateList.add(state4);
        
        State deletedState = stateList.delete(state1.getName());
        State deletedState2 = stateList.delete(state4.getName());
        
        assertEquals(state1, deletedState);
        assertEquals(state4, deletedState2);
        assertEquals(2, stateList.size());
    }// end testDelete
    
    @Test
    public void testDeleteStateNotFound() {
        State state1 = new State("Pennsylvania", "Harrisburg", 500000);
        State state2 = new State("Massachusetts", "Boston", 430000);
        State state3 = new State("New York", "Albany", 1000000);
        State state4 = new State("Florida", "Tallahassee", 19000000);
        
        stateList.add(state1);
        stateList.add(state2);
        stateList.add(state3);
        stateList.add(state4);
        
        State deletedState = stateList.delete("Non Existant");
        
        assertEquals(null, deletedState);
    }// end testDeleteStateNotFound
    
    @Test
    public void testSearch() {
        State state1 = new State("Pennsylvania", "Harrisburg", 500000);
        State state2 = new State("Massachusetts", "Boston", 430000);
        State state3 = new State("New York", "Albany", 1000000);
        State state4 = new State("Florida", "Tallahassee", 19000000);
        
        stateList.add(state1);
        stateList.add(state2);
        stateList.add(state3);
        stateList.add(state4);
        
        State stateToSearch = stateList.search(state2.getName());
        
        assertEquals(state2, stateToSearch);
    }// end testSearch
    
    @Test
    public void testSearchStateNotFound() {
        State state1 = new State("Pennsylvania", "Harrisburg", 500000);
        State state2 = new State("Massachusetts", "Boston", 430000);
        State state3 = new State("New York", "Albany", 1000000);
        State state4 = new State("Florida", "Tallahassee", 19000000);
        
        stateList.add(state1);
        stateList.add(state2);
        stateList.add(state3);
        stateList.add(state4);
        
        State stateToSearch = stateList.search("Not existant state");
        
        assertEquals(null, stateToSearch);
    }// end testSearchStateNotFound
    
    @Test
    public void testToString() {
        State state1 = new State("Pennsylvania", "Harrisburg", 500000);
        State state2 = new State("Massachusetts", "Boston", 430000);
        State state3 = new State("New York", "Albany", 1000000);
        State state4 = new State("Florida", "Tallahassee", 19000000);
        
        stateList.add(state1);
        stateList.add(state2);
        stateList.add(state3);
        stateList.add(state4);
        
        String result = "[\n";
        result += state1.toString() + "\n";
        result += state2.toString() + "\n";
        result += state3.toString() + "\n";
        result += state4.toString() + "\n";
        result += "]";
        
        assertEquals(result, stateList.toString());
    }// end testToString
    
}// end StateListTest