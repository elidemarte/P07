// TODO complete file header comes here
/**
 * This class tests the TaskManager, TaskList, and SortedTaskList classes.
 */
public class TaskManagerTester {

  /**
   * Checks the correctness of the implementation of the method compareTo() defined in the Task
   * class. Consider different test scenarios including each of the SortingOrder values: TITLE and
   * PRIORITY
   * 
   * Test scenarios: <BR>
   * aTask and anotherTask references any Task objects you can create.<BR>
   * 1. aTask.compareTo(anotherTask) is expected to return 0 if they are equal with respect to the
   * comparison criteria. <BR>
   * 2. aTask.compareTo(aTask) is expected to return 0 <BR>
   * 3. aTask.compareTo(anotherTask) is expected to return a negative integer (less than zero) if
   * aTask is less than another Task with respect to the comparison criteria. <BR>
   * 4.aTask.compareTo(anotherTask) is expected to return a positive integer (greater than zero) if
   * aTask is greater than another Task with respect to the comparison criteria.
   * 
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testTaskCompareTo() {
    // TODO: Implement test scenarios
    return true;
  }

  /**
   * Checks the correctness of the implementation of the equals() method defined in the Task clas.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testTaskEquals() {
    // TODO: Implement test scenarios
    return true;
  }

  /**
   * Tests the add(), isEmpty(), and size() methods of the TaskList class.
   * 
   * Test scenarios: <BR>
   * 1. Create a new empty TaskList and verify that isEmpty() returns true.<BR>
   * 2. Add a few tasks to the end of the TaskList and verify that isEmpty() returns false.<BR>
   * 3. Verify that size() returns the expected size after adding each Task.
   *
   * @return true if all test scenarios pass, false otherwise.
   *
   */
  public static boolean testAddIsEmptySize() {
    // TODO: Implement test scenarios
    return true;
  }

  /**
   * Tests the addFirst(), and add(index, element) methods of the TaskList class.
   * 
   * Test scenarios: <BR>
   * 1. Test adding elements to an empty TaskList <BR>
   * 2. Test adding elements to the beginning, middle, and end of a non-empty TaskList.
   *
   * @return true if all test scenarios pass, false otherwise.
   *
   */
  public static boolean testAddToTaskList() {
    // TODO: Implement test scenarios
    return true;
  }

  /**
   * Tests and remove(index) and clear() methods of the TaskList class.
   * 
   * Test scenarios: <BR>
   * 1. Test removing elements from various positions in the TaskList using remove(index). <BR>
   * 2. Test removing elements from an empty TaskList or at invalid indices. <BR>
   * 3. Test clear() method and verify that the TaskList is empty after calling it.
   *
   * @return true if all test scenarios pass, false otherwise.
   *
   */
  public static boolean testRemoveClear() {
    // TODO: Implement test scenarios
    return true;
  }

  /**
   * Tests the add() method of the SortedTaskList class.
   * 
   * Test scenarios: <BR>
   * 1. Test adding a task to an empty TaskList <BR>
   * 2. Test adding tasks to a non-mepty sorted task list such that the task should be added to the
   * beginning, middle, and end of a non-empty TaskList.
   *
   * @return true if all test scenarios pass, false otherwise.
   *
   */
  public static boolean testAddToSortedTaskList() {
    // TODO: Implement test scenarios
    return true;
  }

  /**
   * Tests the appendTask() method of the TaskManager class.
   * 
   * Test scenarios: <BR>
   * 1. Test appending a task to an empty TaskManager. <BR>
   * 2. Test appending multiple tasks to the TaskManager.
   *
   * @return true if all test scenarios pass, false otherwise.
   *
   */
  public static boolean testAppendTask() {
    // TODO: Implement test scenarios
    return true;
  }

  /**
   * Tests the moveToTop(), moveToBottom(), moveBeforeOtherTask(), and moveAfterOtherTask() methods
   * of the TaskManager class.
   *
   * Test scenarios: <BR>
   * 1. Test moving tasks to various positions in the toDoList and completedTasks lists. <BR>
   * 2. Test moving tasks relative to other tasks (before/after).
   * 
   * @return true if all test scenarios pass, false otherwise.
   *
   */
  public static boolean testMoveTasks() {
    // TODO: Implement test scenarios
    return true;
  }

  /**
   * Tests the removeTask() method of the TaskManager class.
   * 
   * Test scenarios: <BR>
   * 1. Test removing tasks from various positions in the toDoList and completedTasks lists. <BR>
   * 2 Test removing tasks at invalid indices return false.
   *
   * 
   * @return true if all test scenarios pass, false otherwise.
   *
   */
  public static boolean testRemoveTask() {
    // TODO: Implement test scenarios
    return true;
  }

  /**
   * Tests the completeTask() method of the TaskManager class.
   * 
   * Test scenarios: <BR>
   * 1. Test completing tasks from various positions in the toDoList. <BR>
   * 2. Test completing tasks at invalid indices.
   *
   * @return true if all test scenarios pass, false otherwise.
   *
   */
  public static boolean testCompleteTask() {
    // TODO: Implement test scenarios
    return true;
  }

  /**
   * Main method
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testTaskCompareTo(): " + testTaskCompareTo());
    System.out.println("testTaskEquals(): " + testTaskEquals());
    System.out.println("testAddIsEmptySize(): " + testAddIsEmptySize());
    System.out.println("testAddToTaskList(): " + testAddToTaskList());
    System.out.println("testRemoveClear(): " + testRemoveClear());
    System.out.println("testAddToSortedTaskList(): " + testAddToSortedTaskList());
    System.out.println("testAppendTask(): " + testAppendTask());
    System.out.println("testMoveTasks(): " + testMoveTasks());
    System.out.println("testRemoveTask(): " + testRemoveTask());
    System.out.println("testCompleteTask(): " + testCompleteTask());
  }
}
