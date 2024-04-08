public class TaskList extends Object implements ListADT<Task> {

    private LinkedNode<Task> head;
    private LinkedNode<Task> tail;
    private int size;

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        // TODO might need to fix, but according to pre-assignment quiz this should work I think
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(Task newElement) throws NullPointerException {
        // check if new element is null
        if (newElement == null) {
            throw new NullPointerException("New task can't be null");
        }

        LinkedNode<Task> newTask = new LinkedNode<>(newElement);
        // check to see if current list is empty (cuz then the head gotta be changed too)
        if (this.isEmpty()) {
            head = newTask;
            tail = newTask;
        } else {  // List not empty so just adjust tail
            tail.setNext(newTask);
            newTask.setPrev(tail);
            tail = newTask;
        }
        size++;
    }

    @Override
    public void addFirst(Task newElement) throws NullPointerException {
        // check if new element is null
        if (newElement == null) {
            throw new NullPointerException("New task can't be null");
        }

        LinkedNode<Task> newNode = new LinkedNode<>(newElement);
        // check to see if current list is empty (cuz then the tail gotta be changed too)
        if (this.isEmpty()) {
            head = newNode;
            tail = newNode;
        } else { // List not empty so just adjust head
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, Task newElement) throws IndexOutOfBoundsException,
            NullPointerException {
        // check if new element is null
        if (newElement == null) {
            throw new NullPointerException("New task can't be null");
        }
        // check to see if index is valid
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds of list");
        }

        LinkedNode<Task> newTask = new LinkedNode<>(newElement);
        // check to see if current list is empty
        if (this.isEmpty())  {
            head = newTask;
            tail = newTask;
        } else {  // List not empty so insert element at index
            if (index == 0) {  // if index is 0, just like prepending so call .addFirst(Task)
                this.addFirst(newElement);
            } else if (index == size) { // if index == size, just like appending so call .add(Task)
                this.add(newElement);
            } else { // must be inserting between two elements so insert
                LinkedNode<Task> curNode = head;
                LinkedNode<Task> nextNode;
                LinkedNode<Task> newNode = new LinkedNode<>(newElement);
                for (int i = 0; i < index; i++) { // gets the reference of element currently at the
                                                  // target index
                    curNode = curNode.getNext();
                }
                curNode = curNode.getPrev(); // moves current node one position back to match
                                             // current node position used in insertAfter alg (from
                                             // Zybooks chapter 10.18)
                // below is the insert algorithm for a doubly linked list (Zybooks chapter 10.18)
                nextNode = curNode.getNext();
                newNode.setNext(nextNode);
                newNode.setPrev(curNode);
                curNode.setNext(newNode);
                nextNode.setPrev(newNode);
                size++;
            }
        }
    }

    @Override
    public Task get(int index) throws IndexOutOfBoundsException {
        // check to see if the index is valid (in-bounds of our list)
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds of list");
        }
        LinkedNode<Task> target = head;
        if (target.getNext() == null) { // Check to see if it is a one element list b/c then loop
                                        // below won't work
            return target.getData();
        }
        for (int i = 0; i < index; i++) {
            target = target.getNext();
        }
        return target.getData();
    }

    @Override
    public boolean contains(Task toFind) {
        LinkedNode<Task> target = head;
        if (toFind.equals(target.getData())) { // Check head element b/c loop below doesn't check
                                               // first element
            return true;
        } else if (target.getNext() == null) { // if list is one element and first element didn't
                                               // match, list doesn't contain --> return false
            return false;
        }
        for (int i = 0; i < size; i++) { // iterate through list
            target = target.getNext();
            if (toFind.equals(target.getData())){ // check to see if Tasks in list match task toFind
                return true;
            }
        }
        // if method reaches here, no match was found --> return false
        return false;
    }

    @Override
    public Task remove(int index) throws IndexOutOfBoundsException {
        // check to see if the index is valid
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds of list");
        }
        LinkedNode<Task> nextNode;
        LinkedNode<Task> prevNode;
        LinkedNode<Task> curNode = head;
        for (int i = 0; i < index; i++) { // gets the reference of element currently at the
                                          // target index, and assigns it to curNode
            curNode = curNode.getNext();
        }
        // below is the algorithm for removing from a doubly linked list (Zybooks chapter 10.19)
        nextNode = curNode.getNext();
        prevNode = curNode.getPrev();
        if (nextNode != null) {
            nextNode.setPrev(prevNode);
        }
        if (prevNode != null) {
            prevNode.setNext(nextNode);
        }
        if (curNode == head) { // check to see if head is being removed
            head = nextNode;
        }
        if (curNode == tail) { // check to see if tail is being removed
            tail = prevNode;
        }

        size--; // decrement size after element has been removed
        if (size == 0) { // If the list has become empty, reset head and tail to null
            head = null;
            tail = null;
        }
        return curNode.getData(); // return removed element
    }

    public String traverse (boolean forward) {
        LinkedNode<Task> curNodeF = head; // current node for forward traversing
        LinkedNode<Task> curNodeR = tail; // current node for reverse traversing
        String stringRepresentation = ""; // String to build string representation
        if (forward) {
            // case of forward traversing
            stringRepresentation += (curNodeF.getData().toString()) + "/n"; // get stringRep of head
            if (curNodeF.getNext() == null) {  // check to see if its a one element list
                return stringRepresentation;
            }
            for (int i = 0; i < size; i++) {
                if (curNodeF.getNext() == null) {  // check to stop a NullPointerException once
                                                   // reaching the last element in list
                    stringRepresentation += (curNodeF.getData().toString()) + "/n";
                    return stringRepresentation;
                }
                curNodeF = curNodeF.getNext(); // traverse forwards
                stringRepresentation += (curNodeF.getData().toString()) + "/n";
            }
            return stringRepresentation;
        } else {
            // case of backwards traversing
            stringRepresentation += (curNodeR.getData().toString()) + "/n"; // get stringRep of tail
            if (curNodeR.getNext() == null) {  // check to see if its a one element list
                return stringRepresentation;
            }
            for (int i = 0; i < size; i++) {
                if (curNodeR.getPrev() == null) {  // check to stop a NullPointerException once
                                                   // reaching the first element in list
                    stringRepresentation += (curNodeR.getData().toString()) + "/n";
                    return stringRepresentation;
                }
                curNodeR = curNodeR.getPrev(); // traverse backwards
                stringRepresentation += (curNodeR.getData().toString()) + "/n";
            }
            return stringRepresentation;
        }
    }

    protected String traverseBackward() {
        LinkedNode<Task> curNodeR = tail; // current node for reverse traversing
        String stringRepresentation = ""; // String to build string representation

        // case of backwards traversing
        stringRepresentation += (curNodeR.getData().toString()) + "/n"; // get stringRep of tail
        if (curNodeR.getNext() == null) {  // check to see if its a one element list
            return stringRepresentation;
        }
        for (int i = 0; i < size; i++) {
            if (curNodeR.getPrev() == null) {  // check to stop a NullPointerException once
                // reaching the first element in list
                stringRepresentation += (curNodeR.getData().toString()) + "/n";
                return stringRepresentation;
            }
            curNodeR = curNodeR.getPrev(); // traverse backwards
            stringRepresentation += (curNodeR.getData().toString()) + "/n";
        }
        return stringRepresentation;
    }

    protected String traverseForward() {
        LinkedNode<Task> curNodeF = head; // current node for forward traversing
        String stringRepresentation = ""; // String to build string representation

        // case of forward traversing
        stringRepresentation += (curNodeF.getData().toString()) + "/n"; // get stringRep of head
        if (curNodeF.getNext() == null) {  // check to see if its a one element list
            return stringRepresentation;
        }
        for (int i = 0; i < size; i++) {
            if (curNodeF.getNext() == null) {  // check to stop a NullPointerException once
                // reaching the last element in list
                stringRepresentation += (curNodeF.getData().toString()) + "/n";
                return stringRepresentation;
            }
            curNodeF = curNodeF.getNext(); // traverse forwards
            stringRepresentation += (curNodeF.getData().toString()) + "/n";
        }
        return stringRepresentation;
    }

}
