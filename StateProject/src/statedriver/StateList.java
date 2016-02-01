package statedriver;

/**
 * A class representing a collection of State objects.
 * 
 * @author Luis Ortiz
 */
public class StateList {

    private State[] statesArray = new State[50]; // an array of 50 states
    private int size = 0; // actual number of state objects in the collection

    /**
    * Default Constructor
    */
    public StateList() {

    }// end StateList()

    public int size() {
        return size;
    }// end size()

    /**
     * A method which adds a state to its collection.
     * 
     * @param state The state to add
     * @return      A boolean determining if the state was successfully added
     */
    public boolean add(State state) {
        boolean added = true;
        
        // check if states array is full
        if (size == statesArray.length) {
            System.out.println("Can not add state " + state.getName());
            System.out.println("State array is full.");
            // added is false because the array is full
            added = false;
        }// end if

        // add state to collection
        statesArray[size] = state;
        size++;
        return added;
    }// end add(State state)

    /**
     * A method to remove a state from the State array.
     * 
     * @param name The name of the state to remove
     * @return     The state object removed, or null if the state was not found
     */
    public State delete(String name) {
        State stateToDelete = null;
        boolean found = false;
        int indexToDelete = 0;
        name = name.toLowerCase();

        // search for the state in the collection
        for (int i = 0; i < size; i++) {
            if (statesArray[i].getName().toLowerCase().equals(name)) {
                stateToDelete = statesArray[i];
                indexToDelete = i;
                found = true;
            }// end if
        }// end for

        if (found) {
            // if the state is the last item in the array
            // there is no need to search the collection
            if (indexToDelete == size - 1) {
                statesArray[indexToDelete] = null;
            } else {
                // shift all of the states down by one index in the array
                while (indexToDelete < size - 1) {
                    statesArray[indexToDelete] = statesArray[indexToDelete + 1];
                    indexToDelete++;
                }// end while

                // remove last element after shifting, this prevents having
                // two instances of the same state in size - 1 and size - 2
                statesArray[size - 1] = null;
            }//end if
            
            System.out.println("\nState: " + name + " removed.");
            size--;
        } else {
            // the name of the state could not be located
            System.out.println("Cannot remove " + name);
            System.out.println("State: " + name + " is not in the array.");
        }// end if

        return stateToDelete;
    }// end delete(String name)

    /**
     * Search each element in the State array.
     * 
     * @param name  The name of the state to search for
     * @return      A state object if located, otherwise null
     */
    public State search(String name) {
        State searchState = null;
        name = name.toLowerCase();

        for (int i = 0; i < size; i++) {
            if (statesArray[i].getName().toLowerCase().equals(name)) {
                searchState = statesArray[i];
            }// end if
        }// end for

        return searchState;
    }// end search(String name)

    /**
     * A string representation of the State array.
     * 
     * @return A string containing the contents of the state array.
     */
    @Override
    public String toString() {
        String result = "[\n";
        for (int i = 0; i < size; i++) {
            result += statesArray[i].toString() + "\n";
        }// end for
        result += "]";

        return result;
    }// end toString

}// end class StateList
