package statedriver;

/**
 *
 * @author Luis Ortiz
 */
public class StateList {

    private State[] statesArray = new State[50]; // an array of 50 states
    private int size = 0;                        // hold the actual number of state objects

    public StateList() {

    }// end StateList()

    public int size() {
        return size;
    }// end size()

    public void add(State state) {
        // check if states array is full
        if (size == statesArray.length) {
            System.out.println("Can not add state " + state.getName());
            System.out.println("State array is full.");
            return;
        }// end if

        statesArray[size] = state;
        size++;
    }// end add(State state)

    public void delete(String name) {
        boolean found = false;
        int indexToDelete = 0;
        name = name.toLowerCase();

        for (int i = 0; i < size; i++) {
            if (statesArray[i].getName().toLowerCase().equals(name)) {
                indexToDelete = i;
                found = true;
            }// end if
        }// end for

        if (found) {
            // the state is the last item in the array
            if (indexToDelete == size) {
                statesArray[indexToDelete] = null;
            } else {
                // shift all of the states down by one index in the array
                while (indexToDelete < size - 1) {
                    statesArray[indexToDelete] = statesArray[indexToDelete + 1];
                    indexToDelete++;
                }// end while
            }//end if

            System.out.println("\nState: " + name + " removed.");
            size--;
        } else {
            System.out.println("Cannot remove " + name);
            System.out.println("State: " + name + " is not in the array.");
        }// end if

    }// end delete(String name)

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
