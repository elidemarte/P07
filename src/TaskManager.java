// TODO Add a complete file header
/**
 * This class models TaskManager objects. A TaskManager has a to do list of incomplete tasks, and a
 * list of completed tasks. This class allows the user to manage the tasks in the to do list.
 */
public class TaskManager {


  /**
   * to do list of incomplete tasks
   */
  protected TaskList toDoList; // list of incomplete tasks

  /**
   * TaskList of completed tasks
   */
  protected TaskList completedTasks; // list of completed tasks

  /**
   * Constructs a TaskManager with empty to-do and completed task lists.
   */
  public TaskManager() {
    // TODO implement this constructor
  }


  /**
   * Appends a task to the end of the to-do list.
   *
   * @param task The task to be added to the to-do list.
   */
  public void appendTask(Task task) {
    // TODO implement this method
  }

  /**
   * Moves a specified task to the top (head) of the to-do list.
   *
   * @param indexTaskToMove The index of the task to move to the top (head) of the to-do list.
   * @throws IndexOutOfBoundsException if indexTaskToMove is out of bounds with respect to the to-do
   *                                   list valid range of indexes.
   */
  public void movetoTop(int indexTaskToMove) {
    // TODO implement this method
  }

  /**
   * Moves a specified task to the bottom (tail) of the to-do list.
   *
   * @param indexTaskToMove The index of the task to move to the bottom (tail) of the to-do list.
   * @throws IndexOutOfBoundsException if indexTaskToMove is out of bounds with respect to the to-do
   *                                   list valid range of indexes.
   */
  public void moveToBottom(int indexTaskToMove) {
    // TODO implement this method
  }

  /**
   * Moves a specified task to a position before another task in the to-do list given their indexes.
   *
   * @param indexTaskToMove The index of the task to move within the to-do list.
   * @param indexOtherTask  The index of the other task before which the first task will be moved.
   * @return true if the task was successfully moved; false otherwise.
   *
   */
  public boolean moveBeforeOtherTask(int indexTaskToMove, int indexOtherTask) {
    // TODO implement this method
    return false;
  }

  /**
   * Moves a specified task to a position after another task in the to-do list, given their indexes.
   *
   * @param indexTaskToMove The index of the task to move.
   * @param indexOtherTask  The index of the other task after which the first task will be moved.
   * @return true if the task was successfully moved; false otherwise.
   */
  public boolean moveAfterOtherTask(int indexTaskToMove, int indexOtherTask) {
    // TODO implement this method
    return false;
  }

  /**
   * Removes a task from the to-do list based on its index.
   *
   * @param index The index of the task to remove.
   * @return true if the task was successfully removed; false if the index was invalid.
   */
  public boolean removeTask(int index) {
    // TODO implement this method
    return false;
  }

  /**
   * Marks the task at index in the to-do list as complete and moves it to the completed tasks list.
   * The completed task can be added to the beginning OR the end of the completedTasks list.
   *
   * @param index The index of the task to mark as complete.
   * @return true if the task was successfully marked as complete and moved; false if the index was
   *         invalid.
   */
  public boolean completeTask(int index) {
    // TODO implement this method
    return false;
  }

  /**
   * Returns a new TaskList that contains all tasks sorted in the increasing order
   * 
   * @return a new TaskList that contains all tasks sorted in the increasing order
   */
  public TaskList sortTasks() {
    // TODO implement this method
    return null;
  }
}
