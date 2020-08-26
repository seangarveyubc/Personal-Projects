package LinkedList;

import Node.DoublyLinkedNode;

/**
 * Implementation of a Doubly Linked List that contains both head and tail references
 * @param <E> - Generic to handle different types of linked lists
 */

/**
 * Functions contained in this file
 *      Constructor ()
 *      Constructor (DoublyLinkedNode<E> node)
 *      add (DoublyLinkedNode<E> node)
 *      addFront (DoublyLinkedNode<E> node)
 *      addBack (DoublyLinkedNode<E> node)
 *      remove ()
 *      remove(DoublyLinkedNode<E> node)
 *      removeFront ()
 *      removeBack ()
 *      clear()
 *      cloneShallow()
 *      contains(DoublyLinkedNode<E> node)
 *      isSame(DoublyLinkedNode<E> list)
 *      isEmpty()
 *      length()
 *      toString()
 */

public class DoublyLinkedList<E> {

    /**
     * Rep Invariant
     *  This list contains a linked list of DoublyLinkedNode objects
     *  The head refers to the beginning of the list
     *  The head is only "pointed to" by the next DoublyLinkedNode in the list
     *  The tail refers to the end of the list
     *  The tail is only "pointed to" by the previous DoublyLinkedNode in the list
     *  The length is the number of DoublyLinkedNode objects in the DoublyLinkedList object
     */

    private DoublyLinkedNode<E> head;
    private DoublyLinkedNode<E> tail;
    private int length;

    /**
     * Constructor
     * Initializes a DoublyLinkedList object without a starting node
     */
    public DoublyLinkedList () {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /**
     * Constructor
     * @param node
     * Initializes a SinglyLinkedList object with a starting node
     */
    public DoublyLinkedList (DoublyLinkedNode<E> node) {
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    /**
     * add
     * @param node - node to be added
     * Adds node to the front of the list
     */
    public void add (DoublyLinkedNode<E> node) {
        addBack(node);
    }

    /**
     * addFront
     * @param node - node to be added
     * Adds node to the front of the list
     */
    public void addFront (DoublyLinkedNode<E> node) {
        this.head.setPrevious(node);
        node.setNext(this.head);
        node.setPrevious(null);
        this.head = node;
        this.length++;
    }

    /**
     * addBack
     * @param node - node to added
     * Adds node to the end of the list
     */
    public void addBack (DoublyLinkedNode<E> node) {
        this.tail.setNext(node);
        this.tail = node;
        this.length++;
        //preserving the rep invariant in the case where node is a part of a separate list
        while (this.tail.getNext() != null) {
            this.tail = this.tail.getNext();
            this.length++;
        }
    }

    /**
     * remove
     * Removes the first node in the list
     * If the list is empty, then no change occurs
     */
    public void remove () {
        removeFront();
    }

    /**
     * remove
     * @param node - node to be removed
     * Removes the first occurrence of the GenericNode<E> node
     * If node is not present in the list, the list is unchanged
     */
    public void remove(DoublyLinkedNode<E> node) {
        DoublyLinkedNode<E> current = this.head;
        if (current == node) {
            removeFront();
        }
        while (current.getNext() != null) {
            if (current == node) {
                DoublyLinkedNode<E> prev = current.getPrevious();
                DoublyLinkedNode<E> next = current.getNext();
                prev.setNext(next);
                next.setPrevious(prev);
                current.setNext(null);
                current.setPrevious(null);
                this.length--;
                return;
            }
            current = current.getNext();
        }
        if (current == node)
            removeBack();
    }

    /**
     * removeFront
     * Removes the first node in the list
     * If the list is empty, then no change occurs
     */
    public void removeFront () {
        if (this.isEmpty())
            return;
        else if (this.length == 1) {
            this.head = null;
            this.tail = null;
        }
        else {
            DoublyLinkedNode<E> temp = this.head;
            this.head = this.head.getNext();
            this.head.setPrevious(null);
            temp.setNext(null);
        }
        this.length--;
    }

    /**
     * removeBack
     * Removes the last node in the list
     * If the list has one node, the list is made empty
     */
    public void removeBack () {
        if (this.isEmpty())
            return;
        else if (this.length == 1) {
            this.head = null;
            this.tail = null;
        }
        else {
            DoublyLinkedNode<E> temp = this.tail;
            this.tail = this.tail.getPrevious();
            this.tail.setNext(null);
            temp.setPrevious(null);
        }
        this.length--;
    }

    /**
     * clear
     * Removes all DoublyLinkedNode from the DoublyLinkedList object
     */
    public void clear() {
        while (this.head != null)
            removeFront();
    }

    /**
     * cloneShallow
     * @return a shallow copy of the SinglyLinkedList
     */
    public DoublyLinkedList<E> cloneShallow() {
        DoublyLinkedNode<E> temp = this.head;
        DoublyLinkedList<E> returnList = new DoublyLinkedList<E>();
        while (temp != null) {
            returnList.addBack(temp);
            temp = temp.getNext();
        }
        return returnList;
    }

    /**
     * contains
     * @param node - node to be checked
     * @return true if node is found in this SinglyLinkedList
     */
    public boolean contains(DoublyLinkedNode<E> node) {
        DoublyLinkedNode<E> temp = this.head;
        while (temp != null){
            if (temp == node)
                return true;
        }
        return false;
    }

    /**
     * isSame
     * @param list - list to be compared against
     * @return true if this and list contain the same elements
     * Compares reference equality for each node
     */
    public boolean isSame(DoublyLinkedList<E> list) {
        if (list.length() != this.length)
            return false;
        DoublyLinkedNode<E> currentThis = this.head;
        DoublyLinkedNode<E> currentThat = list.head;
        while (currentThis != null) {
            if (currentThis != currentThat)
                return false;
            currentThis = currentThis.getNext();
            currentThat = currentThat.getNext();
        }
        return true;
    }

    /**
     * isEmpty
     * @return true if the SinglyLinkedList object contains no nodes
     */
    public boolean isEmpty() {
        return (this.length == 0);
    }

    /**
     * getLength
     * @return the number of nodes in the SinglyLinkedList object
     */
    public int length() {
        return this.length;
    }

    /**
     * toString
     * Prints the contents of the list
     */
    @Override
    public String toString() {
        return "SinglyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }
}
