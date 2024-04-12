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
    // Test scenario #1
    {
      // Check with the default constructor
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a total mess");
      int actual = aTask.compareTo(anotherTask);
      int expected = 0;
      if (actual != expected) {
        System.out.println("testTaskCompareTo; test 1: should've returned " + expected + ", but " +
                "returned " + actual);
        return false;
      }
      //TODO might be necessary to test by setting different kinds of sorting (Idk what the
      // default sorting is: title or priority)
    }

    // Test scenario #2
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      int actual = aTask.compareTo(aTask);
      int expected = 0;
      if (actual != expected) {
        System.out.println("testTaskCompareTo; test 1: should've returned " + expected + ", but " +
                "returned " + actual);
        return false;
      }
    }

    // Test scenario #3
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a total mess", true);
      int actual = aTask.compareTo(anotherTask);
      int expected = -1;
      if (actual != expected) {
        System.out.println("testTaskCompareTo; test 1: should've returned " + expected + ", but " +
                "returned " + actual);
        return false;
      }
    }

    // Test scenario #4
    {
      Task aTask = new Task("laundry", "got no clean clothes :(", true);
      Task anotherTask = new Task("make bed", "bed is a total mess");
      int actual = aTask.compareTo(anotherTask);
      int expected = 1;
      if (actual != expected) {
        System.out.println("testTaskCompareTo; test 1: should've returned " + expected + ", but " +
                "returned " + actual);
        return false;
      }
    }

    // All tests must have passed
    return true;
  }

  /**
   * Checks the correctness of the implementation of the equals() method defined in the Task class.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testTaskEquals() {
    // Check with null
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = null;
      boolean actual = aTask.equals(anotherTask);
      boolean expected = false;
      if (actual != expected) {
        System.out.println("testTaskEquals; test 1: should've returned " + expected + ", but" +
                " " + "returned " + actual);
        return false;
      }
    }

    // Check with different titles
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a total mess");
      boolean actual = aTask.equals(anotherTask);
      boolean expected = false;
      if (actual != expected) {
        System.out.println("testTaskEquals; test 2: should've returned " + expected + ", but" +
                " " + "returned " + actual);
        return false;
      }
    }

    // Check with same titles
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("laundry", "hamper is overflowing");
      boolean actual = aTask.equals(anotherTask);
      boolean expected = true;
      if (actual != expected) {
        System.out.println("testTaskEquals; test 3: should've returned " + expected + ", but" +
                " " + "returned " + actual);
        return false;
      }
    }

    // Check with different object types
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Integer difObjType = Integer.valueOf(1);
      boolean actual = aTask.equals(difObjType);
      boolean expected = false;
      if (actual != expected) {
        System.out.println("testTaskEquals; test 4: should've returned " + expected + ", but" +
                " " + "returned " + actual);
        return false;
      }
    }

    // All tests must have passed
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
    // Test for isEmpty() when empty
    {
      TaskList toDo = new TaskList();
      boolean actual = toDo.isEmpty();
      boolean expected = true;
      if (actual != expected) {
        System.out.println("testAddIsEmptySize; test 1: should've returned " + expected + ", " +
                "but " + "returned " + actual);
        return false;
      }
    }

    // Test for isEmpty() when not empty
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      TaskList toDo = new TaskList();
      toDo.add(aTask);
      toDo.add(anotherTask);
      boolean actual = toDo.isEmpty();
      boolean expected = false;
      if (actual != expected) {
        System.out.println("testAddIsEmptySize; test 2: should've returned " + expected + ", " +
                "but " + "returned " + actual);
        return false;
      }
    }

    // Test for size with some tasks in list
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      TaskList toDo = new TaskList();
      toDo.add(aTask);
      toDo.add(anotherTask);
      int actual = toDo.size();
      int expected = 2;
      if (actual != expected) {
        System.out.println("testAddIsEmptySize; test 3: should've returned " + expected + ", "
                + "but " + "returned " + actual);
        return false;
      }
    }

    // Test for size when list empty
    {
      TaskList toDo = new TaskList();
      int actual = toDo.size();
      int expected = 0;
      if (actual != expected) {
        System.out.println("testAddIsEmptySize; test 4: should've returned " + expected + ", " +
                "but " + "returned " + actual);
        return false;
      }
    }

    // Test for add with one element, check element is correct
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      TaskList toDo = new TaskList();
      toDo.add(aTask);
      boolean actual = toDo.get(0).equals(aTask);
      boolean expected = true;
      if (actual != expected) {
        System.out.println("testAddIsEmptySize; test 5: should've returned " + expected + ", " +
                "but " + "returned " + actual);
        return false;
      }
    }

    // Test for add with multiple elements, check elements are added where expected
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      TaskList toDo = new TaskList();
      toDo.add(aTask);
      toDo.add(anotherTask);
      boolean actual = toDo.get(1).equals(anotherTask) && toDo.get(0).equals(aTask);
      boolean expected = true;
      if (actual != expected) {
        System.out.println("testAddIsEmptySize; test 6: should've returned " + expected + ", " +
                "but " + "returned " + actual);
        return false;
      }
    }

    // Test for add when exception should be thrown
    {
      Task aTask = null;
      TaskList toDo = new TaskList();
      try {
        toDo.add(aTask);
      } catch (NullPointerException e) {
        return true;
      }
    }

    // Exception test must have failed
    return false;
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
    // Test for addFirst, empty list
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      TaskList toDo = new TaskList();
      toDo.addFirst(aTask);
      boolean actual = toDo.get(0).equals(aTask);
      boolean expected = true;
      if (actual != expected) {
        System.out.println("testAddToTaskList; test 1: should've returned " + expected + ", " +
                "but " + "returned " + actual);
        return false;
      }
    }

    // Test for addFirst, non-empty list (1 other element)
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      TaskList toDo = new TaskList();
      toDo.add(anotherTask);
      toDo.addFirst(aTask);
      boolean actual = toDo.get(1).equals(anotherTask) && toDo.get(0).equals(aTask);
      boolean expected = true;
      if (actual != expected) {
        System.out.println("testAddToTaskList; test 2: should've returned " + expected + ", " +
                "but " + "returned " + actual);
        return false;
      }
    }

    // Test for addFirst, non-empty list (2 other elements)
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");
      TaskList toDo = new TaskList();
      toDo.add(anotherTask);
      toDo.add(anotherTask1);
      toDo.addFirst(aTask);
      boolean actual = toDo.get(1).equals(anotherTask) && toDo.get(0).equals(aTask)
              && toDo.get(1).equals(anotherTask1);
      boolean expected = true;
      if (actual != expected) {
        System.out.println("testAddToTaskList; test 3: should've returned " + expected + ", " +
                "but " + "returned " + actual);
        return false;
      }
    }

    // Test for add(index), empty list
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      TaskList toDo = new TaskList();
      toDo.add(0, aTask);
      boolean actual = toDo.get(0).equals(aTask);
      boolean expected = true;
      if (actual != expected) {
        System.out.println("testAddToTaskList; test 4: should've returned " + expected + ", " +
                "but " + "returned " + actual);
        return false;
      }
    }

    // Test for add(index), adding to non-empty list at beginning
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");
      TaskList toDo = new TaskList();
      toDo.add(anotherTask);
      toDo.add(anotherTask1);
      toDo.add(0, aTask);
      boolean actual =
              toDo.get(0).equals(aTask) && toDo.get(1).equals(anotherTask)
                      && toDo.get(2).equals(anotherTask);
      boolean expected = true;
      if (actual != expected) {
        System.out.println("testAddToTaskList; test 5: should've returned " + expected + ", " +
                "but " + "returned " + actual);
        return false;
      }
    }

    // Test for add(index), adding to non-empty list in middle
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");
      TaskList toDo = new TaskList();
      toDo.add(anotherTask);
      toDo.add(anotherTask1);
      toDo.add(1, aTask);
      boolean actual =
              toDo.get(0).equals(anotherTask) && toDo.get(1).equals(aTask)
                      && toDo.get(2).equals(anotherTask1);
      boolean expected = true;
      if (actual != expected) {
        System.out.println("testAddToTaskList; test 6: should've returned " + expected + ", " +
                "but " + "returned " + actual);
        return false;
      }
    }

    // Test for add(index), adding to non-empty list at end
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");
      TaskList toDo = new TaskList();
      toDo.add(anotherTask);
      toDo.add(anotherTask1);
      toDo.add(2, aTask);
      boolean actual =
              toDo.get(0).equals(anotherTask) && toDo.get(1).equals(anotherTask1)
                      && toDo.get(2).equals(aTask);
      boolean expected = true;
      if (actual != expected) {
        System.out.println("testAddToTaskList; test 4: should've returned " + expected + ", " +
                "but " + "returned " + actual);
        return false;
      }
    }

    // All tests must have passed
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
    // Test for remove(index), various positions
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");
      TaskList toDo = new TaskList();
      toDo.add(aTask);
      toDo.add(anotherTask);
      toDo.add(anotherTask1);
      toDo.remove(1);
      toDo.remove(1);
      boolean actual =
              toDo.get(0).equals(aTask) && toDo.size() == 1;
      boolean expected = true;
      if (actual != expected) {
        System.out.println("testRemoveClear; test 1: should've returned " + expected + ", " +
                "but " + "returned " + actual);
        return false;
      }
    }

    // Test for clear()
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");
      TaskList toDo = new TaskList();
      toDo.add(aTask);
      toDo.add(anotherTask);
      toDo.add(anotherTask1);
      toDo.clear();
      boolean actual = toDo.isEmpty();
      boolean expected = true;
      if (actual != expected) {
        System.out.println("testRemoveClear; test 3: should've returned " + expected + ", " +
                "but " + "returned " + actual);
        return false;
      }
    }

    // Test for remove(index), invalid index
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      TaskList toDo = new TaskList();
      toDo.add(aTask);
      try {
        toDo.remove(6);
      } catch (IndexOutOfBoundsException e) {
        return true;
      }
    }

    // Exception test must have failed
    return false;
  }

  /**
   * Tests the add() method of the SortedTaskList class.
   *
   * Test scenarios: <BR>
   * 1. Test adding a task to an empty TaskList <BR>
   * 2. Test adding tasks to a non-empty sorted task list such that the task should be added to the
   * beginning, middle, and end of a non-empty TaskList.
   *
   * @return true if all test scenarios pass, false otherwise.
   *
   */
  public static boolean testAddToSortedTaskList() {
    // Test adding to an empty taskList
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      SortedTaskList taskList = new SortedTaskList();
      taskList.add(aTask);
      boolean actual = taskList.get(0).equals(aTask);
      boolean expected = true;
      if (actual != expected) {
        System.out.println("testAddToSortedTaskList; test 1: should've returned " + expected + "," +
                " " +
                "but " + "returned " + actual);
        return false;
      }
    }

    // Test adding to a non-empty taskList sorted by Title
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");
      SortedTaskList taskList = new SortedTaskList();
      Task.setSortingOrderByTitle();
      taskList.add(aTask);
      taskList.add(anotherTask1);
      taskList.add(anotherTask);
      boolean actual = taskList.get(0).equals(aTask) && taskList.get(1).equals(anotherTask)
              && taskList.get(2).equals(anotherTask1);
      boolean expected = true;
      if (actual != expected) {
        System.out.println("testAddToSortedTaskList; test 2: should've returned " + expected + "," +
                " " +
                "but " + "returned " + actual);
        return false;
      }
    }

    // Test adding to a non-empty taskList sorted by Title (middle)
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");
      SortedTaskList taskList = new SortedTaskList();
      Task.setSortingOrderByTitle();
      taskList.add(aTask);
      taskList.add(anotherTask1);
      taskList.add(anotherTask);
      boolean actual = taskList.get(0).equals(aTask) && taskList.get(1).equals(anotherTask)
              && taskList.get(2).equals(anotherTask1);
      boolean expected = true;
      if (actual != expected) {
        System.out.println("testAddToSortedTaskList; test 2: should've returned " + expected + "," +
                " " +
                "but " + "returned " + actual);
        return false;
      }
    }

    // Test adding to a non-empty taskList sorted by Title (beginning)
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");
      SortedTaskList taskList = new SortedTaskList();
      Task.setSortingOrderByTitle();
      taskList.add(anotherTask1);
      taskList.add(anotherTask);
      taskList.add(aTask);
      boolean actual = taskList.get(0).equals(aTask) && taskList.get(1).equals(anotherTask)
              && taskList.get(2).equals(anotherTask1);
      boolean expected = true;
      if (actual != expected) {
        System.out.println("testAddToSortedTaskList; test 2: should've returned " + expected + "," +
                " " +
                "but " + "returned " + actual);
        return false;
      }
    }

    // Test adding to a non-empty taskList sorted by Title (end)
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");
      SortedTaskList taskList = new SortedTaskList();
      Task.setSortingOrderByTitle();
      taskList.add(aTask);
      taskList.add(anotherTask);
      taskList.add(anotherTask1);
      boolean actual = taskList.get(0).equals(aTask) && taskList.get(1).equals(anotherTask)
              && taskList.get(2).equals(anotherTask1);
      boolean expected = true;
      if (actual != expected) {
        System.out.println("testAddToSortedTaskList; test 2: should've returned " + expected + "," +
                " " +
                "but " + "returned " + actual);
        return false;
      }
    }

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
    // Test for remove task (1 work)
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");

      // creates task manager and adds tasks to to-do list
      TaskManager taskManager = new TaskManager();
      taskManager.appendTask(aTask);
      taskManager.appendTask(anotherTask);
      taskManager.appendTask(anotherTask1);

      boolean actual = taskManager.removeTask(0); // should remove aTask
      boolean expected = true;

      // creating what should be the end to-do list
      TaskList expectedToDo = new TaskList();
      expectedToDo.add(anotherTask);
      expectedToDo.add(anotherTask1);

      // creating what should be the end completed task list
      TaskList expectedCompleted = new TaskList();

      // checks if expected vs. actual is accurate
      if (expected != actual || expectedToDo != taskManager.toDoList || expectedCompleted != taskManager.completedTasks) {
        System.out.println("testRemove1Task; test 1: should've returned " + expectedToDo + ", " + expectedCompleted +
                " but " + "returned " + taskManager.toDoList + ", " + taskManager.completedTasks);
        return false;
      }
    }

    // Test for remove task (3 all work)
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");
      Task anotherTask2 = new Task("eat food", "hungry");
      Task anotherTask3 = new Task("walk dog", "rip nilla. fly high king.");

      // creates task manager and adds tasks to to-do list
      TaskManager taskManager = new TaskManager();
      taskManager.appendTask(aTask);
      taskManager.appendTask(anotherTask);
      taskManager.appendTask(anotherTask1);
      taskManager.appendTask(anotherTask2);
      taskManager.appendTask(anotherTask3);

      boolean actual = taskManager.removeTask(0); // should remove aTask
      boolean actual1 = taskManager.removeTask(2); // should remove anotherTask2
      boolean actual2 = taskManager.removeTask(1); // should remove anotherTask1

      boolean expected = true;
      boolean expected1 = true;
      boolean expected2 = true;

      // creating what should be the end to-do list
      TaskList expectedToDo = new TaskList();
      expectedToDo.add(anotherTask3);

      // creating what should be the end completed task list
      TaskList expectedCompleted = new TaskList();

      // checks if expected vs. actual is accurate
      if (actual != expected || actual1 != expected1 || actual2 != expected2 || expectedToDo != taskManager.toDoList || expectedCompleted != taskManager.completedTasks) {
        System.out.println("testComplete3Task; test 1: should've returned " + expectedToDo + ", " + expectedCompleted +
                " but " + "returned " + taskManager.toDoList + ", " + taskManager.completedTasks);
        return false;
      }
    }

    // Test for remove task (2/3 work)
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");
      Task anotherTask2 = new Task("eat food", "hungry");
      Task anotherTask3 = new Task("walk dog", "rip nilla. fly high king.");

      // creates task manager and adds tasks to to-do list
      TaskManager taskManager = new TaskManager();
      taskManager.appendTask(aTask);
      taskManager.appendTask(anotherTask);
      taskManager.appendTask(anotherTask1);
      taskManager.appendTask(anotherTask2);
      taskManager.appendTask(anotherTask3);

      boolean actual = taskManager.removeTask(0); // should remove aTask
      boolean actual1 = taskManager.removeTask(8); // should return false
      boolean actual2 = taskManager.removeTask(1); // should remove anotherTask1

      boolean expected = true;
      boolean expected1 = false;
      boolean expected2 = true;

      // creating what should be the end to-do list
      TaskList expectedToDo = new TaskList();
      expectedToDo.add(anotherTask);
      expectedToDo.add(anotherTask2);
      expectedToDo.add(anotherTask3);

      // creating what should be the end completed task list
      TaskList expectedCompleted = new TaskList();

      // checks if expected vs. actual is accurate
      if (actual != expected || actual1 != expected1 || actual2 != expected2 || expectedToDo != taskManager.toDoList || expectedCompleted != taskManager.completedTasks) {
        System.out.println("testComplete2/3Task; test 1: should've returned " + expectedToDo + ", " + expectedCompleted +
                " but " + "returned " + taskManager.toDoList + ", " + taskManager.completedTasks);
        return false;
      }
    }

    // Test for remove task (all)
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");

      // creates task manager and adds tasks to to-do list
      TaskManager taskManager = new TaskManager();
      taskManager.appendTask(aTask);
      taskManager.appendTask(anotherTask);
      taskManager.appendTask(anotherTask1);

      boolean actual = taskManager.removeTask(0); // should remove aTask
      boolean actual1 = taskManager.removeTask(0); // should remove anotherTask
      boolean actual2 = taskManager.removeTask(0); // should remove anotherTask1

      boolean expected = true;
      boolean expected1 = true;
      boolean expected2 = true;

      // creating what should be the end to-do list
      TaskList expectedToDo = new TaskList();

      // creating what should be the end completed task list
      TaskList expectedCompleted = new TaskList();

      // checks if expected vs. actual is accurate
      if (actual != expected || actual1 != expected1 || actual2 != expected2 || expectedToDo != taskManager.toDoList || expectedCompleted != taskManager.completedTasks) {
        System.out.println("testCompleteAllTask; test 1: should've returned " + expectedToDo + ", " + expectedCompleted +
                " but " + "returned " + taskManager.toDoList + ", " + taskManager.completedTasks);
        return false;
      }
    }

    // Test for remove task (all invalid indices)
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");

      // creates task manager and adds tasks to to-do list
      TaskManager taskManager = new TaskManager();
      taskManager.appendTask(aTask);
      taskManager.appendTask(anotherTask);
      taskManager.appendTask(anotherTask1);

      boolean actual = taskManager.removeTask(9); // should return false
      boolean actual1 = taskManager.removeTask(7); // should return false
      boolean actual2 = taskManager.removeTask(3); // should return false

      boolean expected = false;
      boolean expected1 = false;
      boolean expected2 = false;

      // creating what should be the end to-do list
      TaskList expectedToDo = new TaskList();
      expectedToDo.add(aTask);
      expectedToDo.add(anotherTask);
      expectedToDo.add(anotherTask1);

      // creating what should be the end completed task list
      TaskList expectedCompleted = new TaskList();

      // checks if expected vs. actual is accurate
      if (actual != expected || actual1 != expected1 || actual2 != expected2 || expectedToDo != taskManager.toDoList || expectedCompleted != taskManager.completedTasks) {
        System.out.println("testComplete0Task; test 1: should've returned " + expectedToDo + ", " + expectedCompleted +
                " but " + "returned " + taskManager.toDoList + ", " + taskManager.completedTasks);
        return false;
      }
    }

    // Test for remove task (some invalid indices)
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");

      // creates task manager and adds tasks to to-do list
      TaskManager taskManager = new TaskManager();
      taskManager.appendTask(aTask);
      taskManager.appendTask(anotherTask);
      taskManager.appendTask(anotherTask1);

      boolean actual = taskManager.removeTask(0); // remove aTask
      boolean actual1 = taskManager.removeTask(7); // should return false
      boolean actual2 = taskManager.removeTask(3); // should return false

      boolean expected = true;
      boolean expected1 = false;
      boolean expected2 = false;

      // creating what should be the end to-do list
      TaskList expectedToDo = new TaskList();
      expectedToDo.add(anotherTask);
      expectedToDo.add(anotherTask1);

      // creating what should be the end completed task list
      TaskList expectedCompleted = new TaskList();

      // checks if expected vs. actual is accurate
      if (actual != expected || actual1 != expected1 || actual2 != expected2 || expectedToDo != taskManager.toDoList || expectedCompleted != taskManager.completedTasks) {
        System.out.println("testCompleteSomeTask; test 1: should've returned " + expectedToDo + ", " + expectedCompleted +
                " but " + "returned " + taskManager.toDoList + ", " + taskManager.completedTasks);
        return false;
      }
    }

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
    // Test for complete task (1 work)
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");

      // creates task manager and adds tasks to to-do list
      TaskManager taskManager = new TaskManager();
      taskManager.appendTask(aTask);
      taskManager.appendTask(anotherTask);
      taskManager.appendTask(anotherTask1);

      boolean actual = taskManager.completeTask(0); // should complete aTask
      boolean expected = true;

      // creating what should be the end to-do list
      TaskList expectedToDo = new TaskList();
      expectedToDo.add(anotherTask);
      expectedToDo.add(anotherTask1);

      // creating what should be the end completed task list
      TaskList expectedCompleted = new TaskList();
      expectedCompleted.add(aTask);

      // checks if expected vs. actual is accurate
      if (expected != actual || expectedToDo != taskManager.toDoList || expectedCompleted != taskManager.completedTasks) {
        System.out.println("testComplete1Task; test 1: should've returned " + expectedToDo + ", " + expectedCompleted +
                " but " + "returned " + taskManager.toDoList + ", " + taskManager.completedTasks);
        return false;
      }
    }

    // Test for complete task (3 all work)
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");
      Task anotherTask2 = new Task("eat food", "hungry");
      Task anotherTask3 = new Task("walk dog", "rip nilla. fly high king.");

      // creates task manager and adds tasks to to-do list
      TaskManager taskManager = new TaskManager();
      taskManager.appendTask(aTask);
      taskManager.appendTask(anotherTask);
      taskManager.appendTask(anotherTask1);
      taskManager.appendTask(anotherTask2);
      taskManager.appendTask(anotherTask3);

      boolean actual = taskManager.completeTask(0); // should complete aTask
      boolean actual1 = taskManager.completeTask(2); // should complete anotherTask2
      boolean actual2 = taskManager.completeTask(1); // should complete anotherTask1

      boolean expected = true;
      boolean expected1 = true;
      boolean expected2 = true;

      // creating what should be the end to-do list
      TaskList expectedToDo = new TaskList();
      expectedToDo.add(anotherTask);
      expectedToDo.add(anotherTask3);

      // creating what should be the end completed task list
      TaskList expectedCompleted = new TaskList();
      expectedCompleted.add(aTask);
      expectedCompleted.add(anotherTask2);
      expectedCompleted.add(anotherTask1);

      // checks if expected vs. actual is accurate
      if (actual != expected || actual1 != expected1 || actual2 != expected2 || expectedToDo != taskManager.toDoList || expectedCompleted != taskManager.completedTasks) {
        System.out.println("testComplete3Task; test 1: should've returned " + expectedToDo + ", " + expectedCompleted +
                " but " + "returned " + taskManager.toDoList + ", " + taskManager.completedTasks);
        return false;
      }
    }

    // Test for complete task (2/3 work)
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");
      Task anotherTask2 = new Task("eat food", "hungry");
      Task anotherTask3 = new Task("walk dog", "rip nilla. fly high king.");

      // creates task manager and adds tasks to to-do list
      TaskManager taskManager = new TaskManager();
      taskManager.appendTask(aTask);
      taskManager.appendTask(anotherTask);
      taskManager.appendTask(anotherTask1);
      taskManager.appendTask(anotherTask2);
      taskManager.appendTask(anotherTask3);

      boolean actual = taskManager.completeTask(0); // should complete aTask
      boolean actual1 = taskManager.completeTask(8); // should return false
      boolean actual2 = taskManager.completeTask(1); // should complete anotherTask1

      boolean expected = true;
      boolean expected1 = false;
      boolean expected2 = true;

      // creating what should be the end to-do list
      TaskList expectedToDo = new TaskList();
      expectedToDo.add(anotherTask);
      expectedToDo.add(anotherTask2);
      expectedToDo.add(anotherTask3);

      // creating what should be the end completed task list
      TaskList expectedCompleted = new TaskList();
      expectedCompleted.add(aTask);
      expectedCompleted.add(anotherTask1);

      // checks if expected vs. actual is accurate
      if (actual != expected || actual1 != expected1 || actual2 != expected2 || expectedToDo != taskManager.toDoList || expectedCompleted != taskManager.completedTasks) {
        System.out.println("testComplete2/3Task; test 1: should've returned " + expectedToDo + ", " + expectedCompleted +
                " but " + "returned " + taskManager.toDoList + ", " + taskManager.completedTasks);
        return false;
      }
    }

    // Test for complete task (all)
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");

      // creates task manager and adds tasks to to-do list
      TaskManager taskManager = new TaskManager();
      taskManager.appendTask(aTask);
      taskManager.appendTask(anotherTask);
      taskManager.appendTask(anotherTask1);

      boolean actual = taskManager.completeTask(0); // should complete aTask
      boolean actual1 = taskManager.completeTask(0); // should complete anotherTask
      boolean actual2 = taskManager.completeTask(0); // should complete anotherTask1

      boolean expected = true;
      boolean expected1 = true;
      boolean expected2 = true;

      // creating what should be the end to-do list
      TaskList expectedToDo = new TaskList();

      // creating what should be the end completed task list
      TaskList expectedCompleted = new TaskList();
      expectedCompleted.add(aTask);
      expectedCompleted.add(anotherTask);
      expectedCompleted.add(anotherTask1);

      // checks if expected vs. actual is accurate
      if (actual != expected || actual1 != expected1 || actual2 != expected2 || expectedToDo != taskManager.toDoList || expectedCompleted != taskManager.completedTasks) {
        System.out.println("testCompleteAllTask; test 1: should've returned " + expectedToDo + ", " + expectedCompleted +
                " but " + "returned " + taskManager.toDoList + ", " + taskManager.completedTasks);
        return false;
      }
    }

    // Test for complete task (all invalid indices)
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");

      // creates task manager and adds tasks to to-do list
      TaskManager taskManager = new TaskManager();
      taskManager.appendTask(aTask);
      taskManager.appendTask(anotherTask);
      taskManager.appendTask(anotherTask1);

      boolean actual = taskManager.completeTask(9); // should return false
      boolean actual1 = taskManager.completeTask(7); // should return false
      boolean actual2 = taskManager.completeTask(3); // should return false

      boolean expected = false;
      boolean expected1 = false;
      boolean expected2 = false;

      // creating what should be the end to-do list
      TaskList expectedToDo = new TaskList();
      expectedToDo.add(aTask);
      expectedToDo.add(anotherTask);
      expectedToDo.add(anotherTask1);

      // creating what should be the end completed task list
      TaskList expectedCompleted = new TaskList();

      // checks if expected vs. actual is accurate
      if (actual != expected || actual1 != expected1 || actual2 != expected2 || expectedToDo != taskManager.toDoList || expectedCompleted != taskManager.completedTasks) {
        System.out.println("testComplete0Task; test 1: should've returned " + expectedToDo + ", " + expectedCompleted +
                " but " + "returned " + taskManager.toDoList + ", " + taskManager.completedTasks);
        return false;
      }
    }

    // Test for complete task (some invalid indices)
    {
      Task aTask = new Task("laundry", "got no clean clothes :(");
      Task anotherTask = new Task("make bed", "bed is a mess");
      Task anotherTask1 = new Task("take out trash", "trash bin starting to smell");

      // creates task manager and adds tasks to to-do list
      TaskManager taskManager = new TaskManager();
      taskManager.appendTask(aTask);
      taskManager.appendTask(anotherTask);
      taskManager.appendTask(anotherTask1);

      boolean actual = taskManager.completeTask(0); // should complete aTask
      boolean actual1 = taskManager.completeTask(7); // should return false
      boolean actual2 = taskManager.completeTask(3); // should return false

      boolean expected = true;
      boolean expected1 = false;
      boolean expected2 = false;

      // creating what should be the end to-do list
      TaskList expectedToDo = new TaskList();
      expectedToDo.add(anotherTask);
      expectedToDo.add(anotherTask1);

      // creating what should be the end completed task list
      TaskList expectedCompleted = new TaskList();
      expectedCompleted.add(aTask);

      // checks if expected vs. actual is accurate
      if (actual != expected || actual1 != expected1 || actual2 != expected2 || expectedToDo != taskManager.toDoList || expectedCompleted != taskManager.completedTasks) {
        System.out.println("testCompleteSomeTask; test 1: should've returned " + expectedToDo + ", " + expectedCompleted +
                " but " + "returned " + taskManager.toDoList + ", " + taskManager.completedTasks);
        return false;
      }
    }

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