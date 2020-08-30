package LinkedList;

import Exceptions.EmptyListException;
import Exceptions.NodeNotFoundException;
import Node.SinglyLinkedNode;
import Exceptions.UnisolatedNodeException;

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
        if (this.length == 0)
            this.tail = node;
        node.setNext(this.head);
        this.head = node;
        this.length++;
    }

    /**
     * addBack
     * @param node - node to added
     * Adds node to the end of the list
     */
    public void addBack (SinglyLinkedNode<E> node) throws UnisolatedNodeException{
        if(node.getNext() != null)
            throw new UnisolatedNodeException("Given node is in another list. Cannot insert.");
        this.tail.setNext(node);
        this.tail = node;
        this.length++;
    }

    /**
     * remove
     * @param node - node to be removed
     * Removes the first occurrence of the GenericNode<E> node
     * If node is not present in the list, the list is unchanged
     */
    public SinglyLinkedNode<E> remove(SinglyLinkedNode<E> node) throws NodeNotFoundException{
        if (this.head == node) {
            try {
                return removeFront();
            } catch (EmptyListException error) {
                System.out.println("Removal attempted. List is empty.");
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
        throw new NodeNotFoundException("Node not found in SinglyLinkedList.");
    }

    /**
     * removeData
     * @param node - node to be removed
     * Removes the first occurrence of the GenericNode<E> node
     * If node is not present in the list, the list is unchanged
     */
    public SinglyLinkedNode<E> remove(E data) throws NodeNotFoundException{
        if (this.head.getData() == data) {
            try {
                return removeFront();
            } catch (EmptyListException error) {
                System.out.println("Removal attempted. List is empty.");
            }

        }
        SinglyLinkedNode<E> current = this.head;
        SinglyLinkedNode<E> next = current.getNext();
        while (next != null) {
            if (next.getData() == data) {
                current.setNext(next.getNext());
                next.setNext(null);
                this.length--;
                return next;
            }
        }
        throw new NodeNotFoundException("Node not found in SinglyLinkedList.");
    }

    /**
     * removeFront
     * Removes the first node in the list
     * If the list is empty, then no change occurs, null is returned
     * @return the
     */
    public SinglyLinkedNode<E> removeFront () throws EmptyListException {
        if (this.isEmpty()){
            return null;
        }
        else if (this.length == 1) {
            SinglyLinkedNode<E> temp = this.head;
            this.head = null;
            this.tail = null;
            this.length--;
            return temp;
        }
        else {
            SinglyLinkedNode<E> temp = this.head;
            this.head = this.head.getNext();
            temp.setNext(null);
            this.length--;
            return temp;
        }
    }

    /**
     * removeBack
     * Removes the last node in the list
     * If the list has one node, the list is made empty
     */
    public SinglyLinkedNode<E> removeBack () {
        if (this.isEmpty()) {}
        else if (this.length == 1) {
            SinglyLinkedNode<E> temp = this.head;
            this.head = null;
            this.tail = null;
            this.length--;
            return temp;
        }
        else {
            SinglyLinkedNode<E> current = this.head;
            while (current.getNext() != this.tail) {
                current = current.getNext();
            }
            SinglyLinkedNode<E> temp = this.tail;
            current.setNext(null);
            this.tail = current;
            this.length--;
            return temp;
        }
    }

    /**
     * get
     * Returns the singly linked
     */
    public void clear() {
        SinglyLinkedNode<E> temp = this.head;
        while (this.head != null) {
            removeFront();
        }
    }

    /**
     * clear
     * Removes all SinglyLinkedNodes from the SinglyLinkedList object
     */
    public void clear() {
        SinglyLinkedNode<E> temp = this.head;
        while (this.head != null) {
            removeFront();
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
            try {
                returnList.addBack(temp);
            } catch (UnisolatedNodeException error) {
                System.out.println("Could not add the following SinglyLinkedNode to the copy: " + temp.toString());
            }
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
     * @return the head SinglyLinkedNode
     */
    public SinglyLinkedNode<E> getHead() {
        return this.head;
    }

    /**
     * getTail
     * @return the tail SinglyLinkedNode
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
