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
    this.toDoList = new TaskList();
    this.completedTasks = new TaskList();
  }

  /**
   * Appends a task to the end of the to-do list.
   *
   * @param task The task to be added to the to-do list.
   */
  public void appendTask(Task task) {
    this.toDoList.add(task);
  }

  /**
   * Moves a specified task to the top (head) of the to-do list.
   *
   * @param indexTaskToMove The index of the task to move to the top (head) of the to-do list.
   * @throws IndexOutOfBoundsException if indexTaskToMove is out of bounds with respect to the to-do
   *                                   list valid range of indexes.
   */
  public void movetoTop(int indexTaskToMove) {
    // checks if index is valid
    if (indexTaskToMove < 0 || indexTaskToMove >= toDoList.size()) {
      throw new IndexOutOfBoundsException("Index is out of bounds of the to-do list.");
    }

    // adds task to the beginning of the to-do list then removes it from the previous position
    toDoList.addFirst(toDoList.get(indexTaskToMove));
    toDoList.remove(indexTaskToMove + 1);
  }

  /**
   * Moves a specified task to the bottom (tail) of the to-do list.
   *
   * @param indexTaskToMove The index of the task to move to the bottom (tail) of the to-do list.
   * @throws IndexOutOfBoundsException if indexTaskToMove is out of bounds with respect to the to-do
   *                                   list valid range of indexes.
   */
  public void moveToBottom(int indexTaskToMove) {
    // checks if index is valid
    if (indexTaskToMove < 0 || indexTaskToMove >= toDoList.size()) {
      throw new IndexOutOfBoundsException("Index is out of bounds of the to-do list.");
    }

    // adds task to the end of the to-do list then removes it from the previous position
    toDoList.add(toDoList.get(indexTaskToMove));
    toDoList.remove(indexTaskToMove);
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
    // checks if index is valid
    if (indexTaskToMove < 0 || indexTaskToMove >= toDoList.size() || indexOtherTask < 0 || indexOtherTask >= toDoList.size()) {
      return false;
    }

    // create temporary task to be moved
    Task taskToMove = toDoList.get(indexTaskToMove);

    toDoList.remove(indexTaskToMove); // removes the task from og position
    toDoList.add(indexOtherTask - 1, taskToMove); // adds it before the other task
    return true;
  }

  /**
   * Moves a specified task to a position after another task in the to-do list, given their indexes.
   *
   * @param indexTaskToMove The index of the task to move.
   * @param indexOtherTask  The index of the other task after which the first task will be moved.
   * @return true if the task was successfully moved; false otherwise.
   */
  public boolean moveAfterOtherTask(int indexTaskToMove, int indexOtherTask) {
    // checks if index is valid
    if (indexTaskToMove < 0 || indexTaskToMove >= toDoList.size() || indexOtherTask < 0 || indexOtherTask >= toDoList.size()) {
      return false;
    }

    // create temporary task to be moved
    Task taskToMove = toDoList.get(indexTaskToMove);

    toDoList.remove(indexTaskToMove); // removes the task from og position
    toDoList.add(indexOtherTask + 1, taskToMove); // adds it before the other task
    return true;
  }

  /**
   * Removes a task from the to-do list based on its index.
   *
   * @param index The index of the task to remove.
   * @return true if the task was successfully removed; false if the index was invalid.
   */
  public boolean removeTask(int index) {
    // checks if index is valid
    if (index < 0 || index >= toDoList.size()) {
      return false;
    }

    toDoList.remove(index); // removes task from to-do list at index
    return true;
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
    // checks if index is valid
    if (index < 0 || index >= toDoList.size()) {
      return false;
    }

    toDoList.get(index).markCompleted(); // marks task in to-do list as completed
    completedTasks.add(toDoList.get(index)); // adds the completed task from to-do list to completedTasks list
    toDoList.remove(index); // removes the now completed task from to-do list
    return true;
  }

  /**
   * Returns a new TaskList that contains all tasks sorted in the increasing order
   * 
   * @return a new TaskList that contains all tasks sorted in the increasing order
   */
  public TaskList sortTasks() {
    // creates new master task list to be sorted
    TaskList sorted = new TaskList();

    // copies all tasks into sorted list
    for (int i = 0; i < toDoList.size(); i++) {
      sorted.add(toDoList.get(i));
    }

    for (int i = 0; i < completedTasks.size(); i++) {
      sorted.add(completedTasks.get(i));
    }

    boolean swap;
    // bubble sorts the task list
    for (int i = 0; i < sorted.size() - 1; i++) {
      swap = false;

      for (int j = 0; j < sorted.size() - i - 1; j++) {
        if (sorted.get(j).compareTo(sorted.get(j + 1)) > 0) {
          Task temp = sorted.get(j);
          sorted.remove(j);
          sorted.add(j + 1, temp);
          swap = true;
        }
      }

      if (!swap) {
        break;
      }
    }

    return sorted;
  }
}
