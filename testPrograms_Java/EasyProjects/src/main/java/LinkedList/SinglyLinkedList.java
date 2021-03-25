package LinkedList;

import Exceptions.EmptyListException;
import Exceptions.NodeNotFoundException;
import Node.SinglyLinkedNode;

/**
 * Implementation of a Singly Linked List that contains both head and tail references
 * @param <E>
 *     Generic to handle different types of linked lists
 */

/**
 * Functions contained in this file
 *      Constructor ()
 *      addFront (SinglyLinkedNode<E> node)
 *      addBack (SinglyLinkedNode<E> node)
 *      remove(SinglyLinkedNode<E> node)
 *      removeFront ()
 *      removeBack ()
 *      get(SinglyLinkedNode node)
 *      clear()
 *      cloneShallow()
 *      contains(SinglyLinkedNode<E> node)
 *      isSame(SinglyLinkedList<E> list)
 *      isEmpty()
 *      length()
 *      toString()
 */

public class SinglyLinkedList<E> {

    /**
     * Rep Invariant
     *  This list contains a linked list of SinglyLinkedNode objects
     *  The head refers to the beginning of the list
     *  The head is not "pointed to" by any other SinglyLinkedNode
     *  The tail refers to the end of the list
     *  The tail does not "point" to any other SinglyLinkedNode
     *  The length is the number of SinglyLinkedNode objects in the SinglyLinkedList object
     */

    private SinglyLinkedNode<E> head;
    private SinglyLinkedNode<E> tail;
    private int length;

    /**
     * Constructor
     * Initializes a SinglyLinkedList object without a starting node
     */
    public SinglyLinkedList () {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /**
     * addFront
     * @param node - node to be added
     * Adds node to the front of the list
     */
    public void addFront (SinglyLinkedNode<E> node) {
        if (this.isEmpty()) {
            this.head = node;
            this.tail = node;
            this.head.setNext(null);
        }
        else {
            node.setNext(this.head);
            this.head = node;
        }
        this.length++;
    }

    /**
     * addBack
     * @param node - node to added
     * Adds node to the end of the list, assumes that the node being added is not already part of a list
     */
    public void addBack (SinglyLinkedNode<E> node) {
        if (this.isEmpty()) {
            this.head = node;
            this.tail = node;
            this.head.setNext(null);
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        this.length++;
    }

    /**
     * remove
     * @param node - node to be removed
     * Removes the first occurrence of the GenericNode<E> node
     * If node is not present in the list, the list is unchanged
     */
    public SinglyLinkedNode<E> remove(SinglyLinkedNode<E> node) {
        if (this.head == node) {
            try {
                return removeFront();
            } catch (EmptyListException e) {
                //Do nothing, as rep invariant says list is unchanged
            }
        }
        SinglyLinkedNode<E> current = this.head;
        SinglyLinkedNode<E> next = current.getNext();
        while (next != null) {
            if (next == node) {
                current.setNext(next.getNext());
                next.setNext(null);
                this.length--;
                return next;
            }
        }
    }


    /**
     * removeFront
     * Removes the first node in the list
     * If the list is empty, then no change occurs, null is returned
     * @return the
     */
    public SinglyLinkedNode<E> removeFront () throws EmptyListException {
        if (this.isEmpty()){
            throw new EmptyListException("Singly Linked List is empty.");
        }
        SinglyLinkedNode<E> temp = this.head;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.getNext();
            temp.setNext(null);
        }
        this.length--;
        return temp;
    }

    /**
     * removeBack
     * Removes the last node in the list
     * If the list has one node, the list is made empty
     */
    public SinglyLinkedNode<E> removeBack () throws EmptyListException {
        if (this.isEmpty()) {
            throw new EmptyListException("Singly Linked List is empty.");
        }
        SinglyLinkedNode<E> temp = this.head;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;

        }
        else {
            while (temp.getNext() != this.tail) {
                temp = temp.getNext();
            }
            SinglyLinkedNode<E> current = temp;
            temp = current.getNext();
            current.setNext(null);
            this.tail = current;
        }
        this.length--;
        return temp;
    }

    /**
     *
     * Returns the singly linked
     */
    public void clear() {
        while (!this.isEmpty()) {
            try {
                removeFront();
            } catch (EmptyListException ignored) {
                //Will never get here, as the last time the front is removed, the list will then be empty
            }
        }
    }

    /**
     * cloneShallow
     * @return a shallow copy of the SinglyLinkedList
     */
    public SinglyLinkedList<E> cloneShallow() {
        SinglyLinkedNode<E> temp = this.head;
        SinglyLinkedList<E> returnList = new SinglyLinkedList<E>();
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
    public boolean contains(SinglyLinkedNode<E> node) {
        SinglyLinkedNode<E> temp = this.head;
        while (temp != null){
            if (temp == node)
                return true;
            temp = temp.getNext();
        }
        return false;
    }

    /**
     * isSame
     * @param list - list to be compared against
     * @return true if this and list contain the same elements
     * Compares reference equality for each node
     */
    public boolean isSame(SinglyLinkedList<E> list) {
        if (list.getLength() != this.length)
            return false;
        SinglyLinkedNode<E> currentThis = this.head;
        SinglyLinkedNode<E> currentThat = list.head;
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
     * getHead
     * @return the head SinglyLinkedList
     */
    public SinglyLinkedNode<E> getHead() {
        return this.head;
    }

    /**
     * getTail
     * @return the tail SinglyLinkedList
     */
    public SinglyLinkedNode<E> getTail() {
        return this.tail;
    }

    /**
     * getLength
     * @return the number of nodes in the SinglyLinkedList object
     */
    public int getLength() {
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

    /**
     * print
     * Prints the contents of the list
     */
    public void print() {
        System.out.print("[ ");
        SinglyLinkedNode<E> current = this.head;
        while (current != null) {
            System.out.print(current.getData().toString() + " ");
            current = current.getNext();
        }
        System.out.println("]");
    }
}
