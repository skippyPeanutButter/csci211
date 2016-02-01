package StateTest;

import statedriver.State;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit tests using Junit 4.10
 * @author Luis Ortiz
 */
public class StateTest {
    
    private State state;
    
    @Before
    public void setup() {
        state = new State("Pennsylvania", "Harrisburg", 49188);
    }// end setup
    
    @After
    public void teardown() {
        state = null;
    }// end teardown
    
    @Test
    public void testGetName() {
        assertEquals("Pennsylvania", state.getName());
    }// end testGetName
    
    @Test
    public void testGetCapital() {
        assertEquals("Harrisburg", state.getCapital());
    }// end testGetCapital
    
    @Test
    public void testGetPopulation() {
        assertEquals(49188, state.getPopulation());
    }// end testGetPopulation
    
    @Test
    public void testSetName() {
        String newName = "Lousiana";
        state.setName(newName);
        assertEquals(newName, state.getName());
    }
    
    @Test
    public void testSetCapital() {
        String newCapital = "Derp";
        state.setCapital(newCapital);
        assertEquals(newCapital, state.getCapital());
    }// end testSetCapital
    
    @Test
    public void testSetPopulation() {
        int newPopulation = 5445641;
        state.setPopulation(newPopulation);
        assertEquals(newPopulation, state.getPopulation());
    }// end testSetPopulation
    
    @Test
    public void testToString() {
        String name = state.getName();
        String capital = state.getCapital();
        int population = state.getPopulation();
        
        String result = "Name: "+ name +
                        "\nCapital: " + capital +
                        "\nPopulation: " + population;
        
        assertEquals(result, state.toString());
    }// end testToString
    
}// end StateTest
