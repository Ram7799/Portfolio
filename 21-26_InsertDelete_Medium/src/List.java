/**
 * Singly Linked List implementation
 * @param <T> Its a Generic type
 */
public class List<T> {
    /**
     * This is the Node class; used for building a linked list
     * @param <T> Its a Generic type
     */
    class ListNode<T> {
        // package access members; List can access these directly
        /** This stores the date of the node*/
        T data; // data for this node
        /** This stores the nextNode */
        ListNode<T> nextNode; // reference to the next node in the list

        /**
         * Single parameter constructor creates a ListNode that refers to object
         * @param object
         */
        ListNode(T object) {
            this(object, null);
        }

        /**
         * constructor creates ListNode that refers to the specified object and to the next ListNode
         * @param object The data of the node
         * @param node This the reference to the enxt node
         */
        ListNode(T object, ListNode<T> node) {
            data = object;
            nextNode = node;
        }

        /**
         * return reference to data in node
         * @return refernce to the data
         */
        T getData() {
            return data;
        }

        /**
         * return reference to next node in list
         * @return Reference to the next node
         */
        ListNode<T> getNext() {
            return nextNode;
        }
    }

    /** This is the firstNode in the list AKA head*/
    private ListNode<T> firstNode;
    /** This is the lastNode aka Tail*/
    private ListNode<T> lastNode;
    /** Useful to print the list as a String*/
    private String name; // string like "list" used in printing
    /** Keeps track of size of the list*/
    private int size = 0;


    /** constructor creates empty List with "list" as the name */
    public List() {
        this("list");
    }

    /**
     * A single parameter constructor. constructor creates an empty List with a name
     * @param listName  Creating a list from the given one
     */
    public List(String listName) {
        name = listName;
        firstNode = lastNode = null;
    }

    /**
     *  insert item at front of List
     * @param insertItem The item to be inserted
     */
    public void insertAtFront(T insertItem) {
        if (isEmpty()) // firstNode and lastNode refer to same object
            firstNode = lastNode = new ListNode<T>(insertItem);
        else // firstNode refers to new node
            firstNode = new ListNode<T>(insertItem, firstNode);
        size++;
    }

    /**
     * insert item at end of List
     * @param insertItem The item to be inserted
     */
    public void insertAtBack(T insertItem) {
        if (isEmpty()) // firstNode and lastNode refer to same object
            firstNode = lastNode = new ListNode<T>(insertItem);
        else // lastNode's nextNode refers to new node
            lastNode = lastNode.nextNode = new ListNode<T>(insertItem);
        size++;
    }

    /**
     * remove first node from List
     * @return The removed element
     * @throws EmptyListException If the list is empty
     */
    public T removeFromFront() throws EmptyListException {
        if (isEmpty()) // throw exception if List is empt1y
            throw new EmptyListException(name);

        T removedItem = firstNode.data; // retrieve data being removed

        // update references firstNode and lastNode
        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else
            firstNode = firstNode.nextNode;
        size--;
        return removedItem; // return removed node data
    } // end method removeFromFront

    /** remove last node from List */
    /**
     * remove last node from List
     * @return The removed element
     * @throws EmptyListException If the list is empty
     */
    public T removeFromBack() throws EmptyListException {
        if (isEmpty()) // throw exception if List is empty
            throw new EmptyListException(name);

        T removedItem = lastNode.data; // retrieve data being removed

        // update references firstNode and lastNode
        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else // locate new last node
        {
            ListNode<T> current = firstNode;

            // loop while current node does not refer to lastNode
            while (current.nextNode != lastNode)
                current = current.nextNode;

            lastNode = current; // current is new lastNode
            current.nextNode = null;
        }
        size--;
        return removedItem; // return removed node data
    }

    /**
     * determine whether list is empty
     * @return A boolean. True if empty, else false.
     */
    public boolean isEmpty() {
        return firstNode == null; // return true if list is empty
    }

    /** output list contents */
    public void print() {
        if (isEmpty()) {
            System.out.printf("Empty %s%n", name);
            return;
        }

        System.out.printf("The %s is: ", name);
        ListNode<T> current = firstNode;

        // while not at end of list, output current node's data
        while (current != null) {
            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }

        System.out.println();
    }

    /**
     * This method is used to add a node at any position in the list.
     * @param insertItem The item to be added
     * @param position the poistion the items gonna go to
     * @throws IndexOutOfBoundsException It throw this when poistion is of the limits of the linked list
     */

    public void addAtPosition(T insertItem,int position) throws IndexOutOfBoundsException{
        checkIndex(position,size+1);
        ListNode newest = new ListNode<T>(insertItem);
        if (isEmpty()) {
            firstNode = newest;
            lastNode = newest;
        }
        else if (position == size) {
            lastNode.nextNode = newest;
            lastNode = newest;
        }
        else if (position == 0) {
            newest.nextNode=firstNode;
            firstNode = newest;
        }
        else {
            ListNode c = firstNode;
            int count = 1;
            while (count < position) {
                c = c.nextNode;
                count++;
            }
            ListNode c2 = c.nextNode;
            c.nextNode = newest;
            newest.nextNode = c2;
        }
        size++;

    }


    /**
     * This method is used to remove a node from any position in the list
     * @param i Its the index to be removed from the list
     * @return It returns the removed element
     * @throws IndexOutOfBoundsException If the index is out of bounds of the linked list
     */
    public T removeFromPostiton(int i) throws IndexOutOfBoundsException{
        checkIndex(i,size);
        ListNode temp;
        if (i == 0) {
            temp = new ListNode(firstNode.data);
            firstNode = firstNode.nextNode;
        }
        else {
            ListNode c= firstNode;
            int j=0;
            while(j<i-1){
                c=c.nextNode;
                j++;
            }
            temp = new ListNode(c.nextNode.data);
            if (c.nextNode.nextNode == null) {
                c.nextNode=null;
                lastNode = c;
            }
            else {
                ListNode c2 = c.nextNode.nextNode;
                c.nextNode = c2;
            }
            size--;
        }
        return (T) temp.getData();

    }

    /**
     * This is used to get any element in the list
     * @param i The index og the element
     * @return it returns the element
     * @throws IndexOutOfBoundsException If the givven index is out of bounds of the linked list.
     */
    public T get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        if (i == 0) {
            return firstNode.data;
        } else if (i == size - 1) {
            return lastNode.data;
        } else {
            ListNode c = firstNode.nextNode;
            int j=1;
            while(j<i){
                c=c.nextNode;
                j++;
            }
            return (T)c.data;
        }
    }

    /**
     * Checks if the given index for add,remove and get is legal
     * @param i The index
     * @param n The size of the list
     * @throws IndexOutOfBoundsException If the i is out of bounds
     */
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n)
            throw new IndexOutOfBoundsException("Illegal index: " + i);
    }


}