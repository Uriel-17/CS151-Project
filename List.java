/**
 * List.java
 * @author Uriel Garcia
 */

import java.util.NoSuchElementException;

public class List<T extends Comparable<T>> {

    private class Node {
        private T data;
        private Node next;
        private Node prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private int length;
    private Node first;
    private Node last;
    private Node iterator;

    /****CONSTRUCTOR****/

    /**
     * Instantiates a new List with default values
     * @postcondition A new empty list is created
     */
    public List() {

        first = null;

        last = null;

        iterator = null;

        length = 0;
    }

    /**
     * Instantiates a new List by copying another List
     * @param original the List to make a copy of
     * @postcondition a new List object, which is an identical
     * but separate copy of the List original
     */
    public List(List original) {

        if (original == null) {

            return;

        } else if (original.length == 0) {

            length = 0;

            first = null;

            last = null;

            iterator = null;

        } else {

            Node temp = original.first;

            while (temp != null) {

                addLast(temp.data);

                temp = temp.next;
            }

            iterator = null;

        }
    }

    /****ACCESSORS****/                                             //Accessors

    /**
     * Returns the index of the iterator
     * from 1 to n. Note that there is
     * no index 0. Does not use recursion.
     * @precondition
     * @return the index of the iterator
     * @throws NullPointerException when
     * the precondition is violated
     */
    public int getIndex() throws NullPointerException{

        if(iterator == null) {

            throw new NullPointerException("getIndex(): cannot get index when iterator is null");

        }

        int n = 1;

        Node temp = first;

        while(!temp.equals(iterator)) {

            temp = temp.next;
            n++;
        }

        return n;
    }


    /**
     * Uses the iterative linear search
     * algorithm to locate a specific
     * element in the list
     * @param element the value to search for
     * @return the location of value in the
     * List or -1 to indicate not found
     * Note that if the List is empty we will
     * consider the element to be not found
     * @postcondition: position of the iterator remains
     * unchanged!
     */
    public int linearSearch(T element) {

        Node temp = first;

        for(int i = 0; i < length; i++) {

            if(temp.data == getIterator()) {

                return getIndex();
            }
            temp = temp.next;


        }

        return -1;

    }

    /**
     * Returns the value stored in the first node
     * @precondition length != 0
     * @return the value stored at node first
     * @throws NoSuchElementException when precondition is violated
     */
    public T getFirst() throws NoSuchElementException{ // check

        if (length == 0) {

            throw new NoSuchElementException("getFirst: List is Empty. No data to access!");

        }

        return first.data;
    }

    /**
     * Returns the value stored in the last node
     * @precondition length != 0
     * @return the value stored in the node last
     * @throws NoSuchElementException when precondition is violated
     */
    public T getLast() throws NoSuchElementException {
        if (length == 0) {

            throw new NoSuchElementException("getLast: List is Empty. No data to access!");

        }
        return last.data;
    }

    /**
     * Returns the current length of the list
     * @return the length of the list from 0 to n
     */
    public int getLength() {
        return length;
    }

    /**
     * Returns whether the list is currently empty
     * @return whether the list is empty
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Returns the element currently pointed to by the iterator
     * @precondition iterator != null
     * @return the value pointed at by the iterator
     * @throws NullPointerException when the precondition is violated
     */
    public T getIterator() throws NullPointerException {

        if(offEnd()) {

            throw new NoSuchElementException("getIterator(): the iterator is off end of the List." +
                    "Can not return data.");

        }

        return iterator.data;

    }

    /**
     * Determines wheter the 2 Lists have the same data in the same order
     * @param o the Object to compare in this List
     * @return whether the 2 lists are equal
     */
    @SuppressWarnings("unchecked")
    @Override public boolean equals(Object o) {

        if (o == this) {

            return true;

        } else if (!(o instanceof List)) {

            return false;

        } else {

            List L = (List) o;

            if(this.length != L.length) {

                return false;

            } else {

                Node temp1 = this.first;

                Node temp2 = L.first;

                while(temp1 != null) {

                    if(!(temp1.data.equals(temp2.data))) {

                        return false;

                    }
                    temp1 = temp1.next;

                    temp2 = temp2.next;

                }
                return true;
            }
        }
    }

    /****MUTATORS****/                                          // mutators

    /**
     * Places the iterator at first
     * and then iteratively advances
     * it to the specified index
     * no recursion
     * @param index the index where
     * the iterator should be placed
     * @precondition 1 <= index <= length
     * @throws IndexOutOfBoundsException
     * when precondition is violated
     */
    public void advanceToIndex(int index) throws IndexOutOfBoundsException{

        if(index < 1 || index > length) {

            throw new IndexOutOfBoundsException("advanceToIndex() " + "cannot return index when it is out of bounds");
        }

        pointIterator();

        for(int i = 1; i < index; i++) {

            advanceIterator();
        }

    }
    /**
     * Creates a new first element
     * @param data the data to insert at the
     * front of the list
     * @postcondition a new first node is created and length is increased by 1
     */
    public void addFirst(T data) {

        if (length == 0) {

            first = last = new Node(data);

        } else {

            Node N = new Node(data);

            N.next = first;

            first.prev = N;

            first = N;

        }

        length++;
    }

    /**
     * Creates a new last element
     * @param data the data to insert at the
     * end of the list
     * @postcondition a new last node is created and length is increased by 1
     */
    public void addLast(T data) {

        Node N = new Node(data);

        if (length == 0) {

            first = last = N;

        } else {

            last.next = N;

            N.prev = last;

            last = N;
        }

        length++;
    }

    /**
     * Removes the element at the front of the list
     * @precondition first != null
     * @postcondition assign a new first node and decrease the length by 1 or error message is displayed
     * @throws NoSuchElementException when precondition is violated
     */
    public void removeFirst() throws NoSuchElementException{

        if (length == 0) {

            throw new NoSuchElementException("removeFirst(): Cannot remove from an empty List!");

        } else if (length == 1) {

            first = last = null;

        } else {

            first = first.next;

            first.prev = null;

        }

        length--;
    }

    /**
     * Removes the element at the end of the list
     * @precondition last != null
     * @postcondition assign a new last node and decrease the length by 1 or error message is displayed
     * @throws NoSuchElementException when precondition is violated
     */
    public void removeLast() throws NoSuchElementException {

        if(length == 0) {

            throw new NoSuchElementException("removeLast(): Cannot remove from an empty List!");
        }
        else if (length == 1) {

            first = last = null;

        } else {
            last = last.prev;

            last.next = null;
        }

        length--;
    }

    /**
     * Return whether the iterator is off the end of the list
     * @return whether iterator equals null
     */
    public boolean offEnd() {

        return iterator == null;

    }

    /**
     * Remove the node pointed to by the Iterator
     * @precondition iterator != null
     * @postcondition set the Iterator = null
     * @throws NullPointerException when the precondition is violated
     */

    public void removeIterator() throws NullPointerException {

        if(iterator == null) {

            throw new NullPointerException("removeIterator(): cannot remove Iterator from an empty list "

                    + "or Iterator has not been initialized");

        } else if(iterator == last) {

            removeLast();

        } else if(iterator == first) {

            removeFirst();

        } else {

            iterator.prev.next = iterator.next;
            iterator.next.prev = iterator.prev;
            length--;

        }

        iterator = null;
    }

    /**
     * Inserts a node following the one currently being referenced by the iterator
     * @param data the new data to insert
     * @precondition iterator != null
     * @throws NullPointerException when precondition is violated
     */
    public void addIterator(T data) throws NullPointerException {

        Node N = new Node(data);

        if (offEnd()) {

            throw new NullPointerException("addIterator(): iterator is off end of the list."

                    + " Cannot insert new data.");

        } else if (iterator == last) {

            addLast(data);

        } else {

            N.next = iterator.next;

            N.prev = iterator;

            iterator.next.prev = N;
            iterator.next = N;

            length++;

        }
    }

    /**
     *  Moves the iterator to point to the first Node of the List
     */
    public void pointIterator() {

        iterator = first;

    }

    /**
     * Advances the iterator by one Node in the List towards the last node
     * @precondition iterator != null
     * @throws NullPointerException when the precondition is violated
     */
    public void advanceIterator() throws NullPointerException {

        if (offEnd()) {

            throw new NullPointerException("advanceIterator(): iterator is off end of the List."

                    + "Can not advance.");
        }

        iterator = iterator.next;
    }

    /**
     * Reverses the iterator by one Node in the List towards the first node
     * @precondition iterator != null
     * @throws NullPointerException when the precondition is violated
     */
    public void reverseIterator() throws NullPointerException {

        if (offEnd()) {

            throw new NullPointerException("advanceIterator(): iterator is off end of the List."

                    + "Can not reverse.");

        }

        iterator = iterator.prev;
    }



    /****ADDITIONAL OPERATIONS****/                             //Additional Operations


    /**
     * List with each value separated by a space
     * At the end of the List is a new line
     * @return the List as a String for display
     *
     */
    @Override public String toString() { // String builder would save space

        String result = "";

        Node temp = first;

        while(temp != null) {

            result += temp.data + " ";

            temp = temp.next;
        }

        System.out.println();

        return result;
    }
}