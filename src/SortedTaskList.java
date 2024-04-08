import java.util.NoSuchElementException;

public class SortedTaskList extends TaskList {

    public void add(Task aTask) throws NullPointerException, IllegalArgumentException {
        // check to see if task is null
        if (aTask == null) {
            throw new NullPointerException("Task to add can't be null");
        }
        // check to see if task to be added is already in list
        if (contains(aTask)) {
            throw new IllegalArgumentException("Task is already in list. Duplicate items are not " +
                    "allowed in this list.");
        }
        //if


    }

    public void addFirst(Task aTask) throws NullPointerException, IllegalStateException {
        // check to see if task is null
        if (aTask == null) {
            throw new NullPointerException("Task to add can't be null");
        }
        // check to see if task can be added to the head of this list
        if (!isEmpty() && aTask.compareTo(/*first element in task list */) > 0) {
            throw new IllegalStateException("Task can not be added to the head/start of this list");
        }

        if (aTask.compareTo())


    }

    public void add(int index, Task aTask) throws NullPointerException, IllegalStateException,
            IndexOutOfBoundsException {

        // check to see if task is null
        if (aTask == null) {
            throw new NullPointerException("Task to add can't be null");
        }
        //check if index is valid
        if (index < 0 || index > size()){
            throw new IndexOutOfBoundsException("Index was out of bounds of the list");
        }

        // check to see if task can be added with respect to surrounding indicies priority level
        //TODO: complete this part of method (checks to throw Illegal state exception)

        // TODO: need to get reference of index
        for (int i = 0; i < size(); i++) {

        }
        if (aTask.compareTo() {
            throw new IllegalStateException("Task can't be added to specified index.");
        }



    }

    public Task peekBest() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is already empty");
        }
        //return best task
    }
}
