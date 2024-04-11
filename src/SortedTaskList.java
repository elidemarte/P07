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

        // TODO this only works if sortingOrder is for PRIORITY... idk how to call setSortingOrderByPriority
        // finds index where the new task should be inserted
        int index = 0;
        while (this.get(index).compareTo(aTask) < 0) {
            index++;
        }

        // inserts new task at the correct index
        super.add(index, aTask);
    }

    public void addFirst(Task aTask) throws NullPointerException, IllegalStateException {
        // check to see if task is null
        if (aTask == null) {
            throw new NullPointerException("Task to add can't be null");
        }
        // check to see if task can be added to the head of this list
        if (!isEmpty() && aTask.compareTo(this.get(0)) > 0) {
            throw new IllegalStateException("Task can not be added to the head/start of this list");
        }

        // iterates through tasklist checking if aTask is less than all other elements
        boolean smallest = true;
        for (int i = 1; i < this.size(); i++) {
            if (aTask.compareTo(this.get(i)) > 0) {
                smallest = false;
                break;
            }
        }

        // if less than all other elements, adds to first
        if (smallest) {
            super.add(0, aTask);
        }
    }

    public void add(int index, Task aTask) throws NullPointerException, IllegalStateException,
            IndexOutOfBoundsException {

        // check to see if task is null
        if (aTask == null) {
            throw new NullPointerException("Task to add can't be null");
        }
        // check if index is valid
        if (index < 0 || index > size()){
            throw new IndexOutOfBoundsException("Index was out of bounds of the list");
        }

        // checks to see if task can be added with respect to surrounding indicies priority level
        // if before task exists, check if aTask is greater than it
        if (index - 1 >= 0 && this.get(index - 1).compareTo(aTask) > 0) {
            throw new IllegalStateException("Task cannot be added at the incorrectly sorted index.");
        }

        // if following task exists, check if aTask is smaller than it
        if (index + 1 <= this.size() - 1 && this.get(index + 1).compareTo(aTask) < 0) {
            throw new IllegalStateException("Task cannot be added at the incorrectly sorted index.");
        }

        // otherwise add it to the tasklist
        super.add(index, aTask);
    }

    public Task peekBest() throws NoSuchElementException {
        // check if list is empty
        if (isEmpty()) {
            throw new NoSuchElementException("List is already empty");
        }

        // otherwise return index 0 task
        return this.get(0);
    }

    public Task removeBest() throws NoSuchElementException {
        // check if list is empty
        if (isEmpty()) {
            throw new NoSuchElementException("List is already empty");
        }

        // makes temporary best task then removes
        Task best = this.get(0);
        this.remove(0);

        return best;
    }
}
