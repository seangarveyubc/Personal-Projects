package LinkedList;

import Exceptions.EmptyListException;
import Exceptions.NodeNotFoundException;
import Node.DoublyLinkedNode;
import org.w3c.dom.Node;

/**
 * Implementation of a Doubly Linked List that contains both head and tail references
 * @param <E> - Generic to handle different types of linked lists
 */

/**
 * Functions contained in this file
 *      Constructor ()
 *      addFront (DoublyLinkedNode<E> node)
 *      addBack (DoublyLinkedNode<E> node)
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
        node.setPrevious(this.tail);
        node.setNext(null);
        this.tail = node;
        this.length++;
    }

    /**
     * remove
     * @param node - node to be removed
     * Removes the first occurrence of the GenericNode<E> node
     * If node is not present in the list, the list is unchanged
     */
    public DoublyLinkedNode<E> remove(DoublyLinkedNode<E> node) throws EmptyListException {
        if (this.isEmpty()) {
            throw new EmptyListException("Doubly Linked List is empty");
        } else {
            if (this.head == node) {

                return removeFront();
            }
            DoublyLinkedNode<E> current = this.head;
            while (current.getNext() != null) {
                if (current == node) {
                    DoublyLinkedNode<E> prev = current.getPrevious();
                    DoublyLinkedNode<E> next = current.getNext();
                    prev.setNext(next);
                    next.setPrevious(prev);
                    current.setNext(null);
                    current.setPrevious(null);
                    this.length--;
                    return current;
                }
                current = current.getNext();
            }
            if (current == node)
                return removeBack();
            throw new NodeNotFoundException("Node not found in the DoublyLinkedList.");
        }
    }

    /**
     * removeFront
     * Removes the first node in the list
     * If the list is empty, then no change occurs
     */
    public DoublyLinkedNode<E> removeFront () throws EmptyListException {
        if (this.isEmpty())
            throw new EmptyListException("DoublyLinkedList is empty.");
        DoublyLinkedNode<E> temp = this.head;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        }
        else {
            this.head = this.head.getNext();
            this.head.setPrevious(null);
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
    public DoublyLinkedNode<E> removeBack () throws EmptyListException {
        if (this.isEmpty())
            throw new EmptyListException("DoublyLinkedList is empty.");
        DoublyLinkedNode<E> temp = this.tail;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        }
        else {
            this.tail = this.tail.getPrevious();
            this.tail.setNext(null);
            temp.setPrevious(null);
        }
        this.length--;
        return temp;
    }

    /**
     * clear
     * Removes all DoublyLinkedNode from the DoublyLinkedList object
     */
    public void clear() {
        while (this.head != null) {
            try {
                removeFront();
            } catch (EmptyListException ignored) {
            }
        }
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
    public boolean isSame(DoublyLinkedList<E> list) {
        if (list.getLength() != this.length)
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
     * getHead
     * @return the head of DoublyLinkedList
     */
    public DoublyLinkedNode<E> getHead() {
        return this.head;
    }

    /**
     * getTail
     * @return the tail of DoublyLinkedList
     */
    public DoublyLinkedNode<E> getTail() {
        return this.tail;
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
    public int getLength() {
        return this.length;
    }

    /**
     * toString
     * Prints the contents of the list
     */
    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }
}
