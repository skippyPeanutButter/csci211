package statedriver;

/**
 * A class to represent one of the 50 states of America.
 * @author Luis Ortiz
 */
public class State {
    
    private String name;    // name of state
    private String capital; // capital of state
    private int population; // population of state
    
    /*
      Default Contstructor
    */
    public State() {
        this.name = "";
        this.capital = "";
        this.population = 0;
    }// end State()
    
    /*
      Parameterized Constructor
    */
    public State(String name, String capital, int population) {
        this.name = name;
        this.capital = capital;
        this.population = population;
    }// end State(String name, String capital, int population)
    
    /*
      Accessor methods
    */

    public String getName() {
        return name;
    }// end getName()
    
    public String getCapital() {
        return capital;
    }// end getCapital()
    
    public int getPopulation() {
        return population;
    }// end getPopulation()
    
    /*
      Mutator methods
    */
    
    public void setName(String name) {
        this.name = name;
    }// end setName()
    
    public void setCapital(String capital) {
        this.capital = capital;
    }// end setCapital()
    
    public void setPopulation(int population) {
        this.population = population;
    }// end setPopulation
    
    @Override
    public String toString() {
        String result = "Name: "+ name +
                        "\nCapital: " + capital +
                        "\nPopulation: " + population;
        return result;
    }// end toString()
    
}// end class State
