package statedriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A driver program to test the State and StateList classes.
 * The program reads in a list of states from a data file and loads
 * them into the StateList class as instances of a State object.
 * It then prints out the list of states it loaded, asks the user for 
 * a state to display and a state to remove from the list. Finally
 * it prints out the list of states after removing the requested state
 * from the list.
 * 
 * @author Luis Ortiz
 */
public class StateDriver {

    public static void main(String[] args) {
        StateList stateList = new StateList();
        
        // load the list of states into the stateList collection
        loadStatesFromFile(stateList);
        
        // print the list of states
        printStates(stateList);
        
        // print out the state data for the state entered by a user
        String state = getStateFromUser();
        printState(stateList, state);
        
        // remove a state specified by the user from the list if it is present
        removeState(stateList);
        
        // print out the states to show state was removed
        printStates(stateList);
    }// end main
    
    /**
     * Reads in a list of states from a data file into the stateList
     * object. The file is expected to be formatted with
     * it's name, capital and population on separate, consecutive lines.
     * 
     * @param stateList The stateList object to load the states into.
     */
    static void loadStatesFromFile(StateList stateList) {
        
        try {
            String fileName = "statedata.txt";
            File stateFile = new File(fileName);
            Scanner fileScan = new Scanner(stateFile);

            // this is assuming that the data file is structured so
            // that three contiguous lines of data compose a full state object
            while (fileScan.hasNextLine()) {
                // create a new state object and set the properties
                // from the next three lines of data
                State state = new State();
                state.setName(fileScan.nextLine());
                state.setCapital(fileScan.nextLine());
                state.setPopulation(Integer.parseInt(fileScan.nextLine()));
                // add the state to the states array.
                stateList.add(state);
            }// end while
        } catch (FileNotFoundException e) {
            // capture case where the file specified does not exist
            System.err.println("FileNotFoundException: " + e.getMessage());
        } catch (Exception e) {
            // fallback to a more general exception
            System.err.println("Exception loading states: " + e.getMessage());
        }// end try catch
        
    }// end loadStatesFromFile
    
    /**
     * A helper method that asks the user for the name of a state.
     * 
     * @return A string containing the name entered by a user.
     */
    static String getStateFromUser() {
        // link scanner to the std input
        Scanner scan = new Scanner(System.in);
        
        // ask user for name of state
        System.out.print("\nEnter the name of a state: ");
        String stateName = scan.nextLine();
        
        return stateName;
    }// end getStateFromUser
    
    /**
     * This method demonstrates the ability of a stateList to remove
     * a state from its collection.
     * 
     * @param stateList The stateList object to remove a state from
     */
    static void removeState(StateList stateList) {
        // get a state from the user
        System.out.print("\nEnter a state to remove.");
        String stateName = getStateFromUser();
        
        stateList.delete(stateName);
    }// end removeState
    
    /**
     * This accepts a stateList object and a state and prints out
     * the state's properties if it exists in the stateList's collection,
     * otherwise it prints an error string.
     * 
     * @param stateList The state list to search
     * @param stateName The state name to search for
     */
    static void printState(StateList stateList, String stateName) {
        State state = stateList.search(stateName);
        if (state != null) {
            System.out.println(state);
        } else {
            System.out.println("State " + stateName + " was not in the list.");
        }// end if
    }// end printState
    
    /**
     * Prints out all the states of a stateList collection.
     * 
     * @param stateList The state list containing the states to print
     */
    static void printStates(StateList stateList) {
        // delegate printing the states to the stateList's toString method
        System.out.println(stateList);
    }// end printStates
    
}// end class StateDriver
