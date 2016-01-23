package statedriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
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
    
    static void loadStatesFromFile(StateList stateList) {
        
        try {
            String fileName = "statedata.txt";
            File stateFile = new File(fileName);
            Scanner fileScan = new Scanner(stateFile);

            // this is assuming that the data file is structure so
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
    
    static String getStateFromUser() {
        // link scanner to the std input
        Scanner scan = new Scanner(System.in);
        
        // ask user for name of state
        System.out.print("\nEnter the name of a state: ");
        String stateName = scan.nextLine();
        
        return stateName;
    }// end getStateFromUser
    
    static void removeState(StateList stateList) {
        System.out.print("\nEnter a state to remove.");
        String stateName = getStateFromUser();
        stateList.delete(stateName);
    }// end removeState
    
    static void printState(StateList stateList, String stateName) {
        State state = stateList.search(stateName);
        if (state != null) {
            System.out.println(state);
        } else {
            System.out.println("State " + stateName + " was not in the list.");
        }// end if
    }// end printState
    
    static void printStates(StateList stateList) {
        // delegate printing the states to the stateList's toString method
        System.out.println(stateList);
    }// end printStates
    
}// end class StateDriver
