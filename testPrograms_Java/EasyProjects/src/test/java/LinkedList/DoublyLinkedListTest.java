package LinkedList;

import org.junit.Test;
public class DoublyLinkedListTest {

    @Test
    public void constructorTest1() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        assertEquals(null, list.getHead());
        assertEquals(null, list.getTail());
        assertEquals(0, list.getLength());
    }

    @Test
    public void addTest1() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        DoublyLinkedNode<Integer> node1 = new DoublyLinkedNode<Integer>(1);
        list.addFront(node1);
        assertEquals(node1, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(1, list.getLength());
        assertEquals(null, node1.getNext());
        assertEquals(null, node1.getPrevious());
    }

    @Test
    public void addTest2() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        DoublyLinkedNode<Integer> node1 = new DoublyLinkedNode<Integer>(1);
        DoublyLinkedNode<Integer> node2 = new DoublyLinkedNode<Integer>(2);
        DoublyLinkedNode<Integer> node3 = new DoublyLinkedNode<Integer>(3);
        list.addFront(node1);
        list.addFront(node2);
        list.addFront(node3);
        assertEquals(node3, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(3, list.getLength());
        assertEquals(null, node1.getNext());
        assertEquals(node2, node1.getPrevious());
        assertEquals(node1, node2.getNext());
        assertEquals(node3, node2.getPrevious());
        assertEquals(node2, node3.getNext());
        assertEquals(null, node3.getPrevious());
    }

    @Test
    public void addTest3() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        DoublyLinkedNode<Integer> node1 = new DoublyLinkedNode<Integer>(1);
        DoublyLinkedNode<Integer> node2 = new DoublyLinkedNode<Integer>(2);
        DoublyLinkedNode<Integer> node3 = new DoublyLinkedNode<Integer>(3);
        list.addFront(node1);
        list.addBack(node2);
        list.addBack(node3);
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(3, list.getLength());
        assertEquals(node2, node1.getNext());
        assertEquals(null, node1.getPrevious());
        assertEquals(node3, node2.getNext());
        assertEquals(node1, node2.getPrevious());
        assertEquals(null, node3.getNext());
        assertEquals(node2, node3.getPrevious());
    }

    @Test
    public void removeTest1() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        DoublyLinkedNode<Integer> node1 = new DoublyLinkedNode<Integer>(1);
        DoublyLinkedNode<Integer> node2 = new DoublyLinkedNode<Integer>(2);
        DoublyLinkedNode<Integer> node3 = new DoublyLinkedNode<Integer>(3);
        list.addFront(node1);
        list.addBack(node2);
        list.addBack(node3);
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(3, list.getLength());
        assertEquals(node2, node1.getNext());
        assertEquals(null, node1.getPrevious());
        assertEquals(node3, node2.getNext());
        assertEquals(node1, node2.getPrevious());
        assertEquals(null, node3.getNext());
        assertEquals(node2, node3.getPrevious());
        list.remove(node3);
        assertEquals(node1, list.getHead());
        assertEquals(node2, list.getTail());
        assertEquals(2, list.getLength());
        assertEquals(node2, node1.getNext());
        assertEquals(null, node1.getPrevious());
        assertEquals(null, node2.getNext());
        assertEquals(node1, node2.getPrevious());
        assertEquals(null, node3.getNext());
        assertEquals(null, node3.getPrevious());
    }

    @Test
    public void removeTest2() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        DoublyLinkedNode<Integer> node1 = new DoublyLinkedNode<Integer>(1);
        DoublyLinkedNode<Integer> node2 = new DoublyLinkedNode<Integer>(2);
        DoublyLinkedNode<Integer> node3 = new DoublyLinkedNode<Integer>(3);
        list.addFront(node1);
        list.addBack(node2);
        list.addBack(node3);
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(3, list.getLength());
        assertEquals(node2, node1.getNext());
        assertEquals(null, node1.getPrevious());
        assertEquals(node3, node2.getNext());
        assertEquals(node1, node2.getPrevious());
        assertEquals(null, node3.getNext());
        assertEquals(node2, node3.getPrevious());
        list.removeFront();
        assertEquals(node2, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(2, list.getLength());
        assertEquals(null, node1.getNext());
        assertEquals(null, node1.getPrevious());
        assertEquals(node3, node2.getNext());
        assertEquals(null, node2.getPrevious());
        assertEquals(null, node3.getNext());
        assertEquals(node2, node3.getPrevious());
    }

    public void removeTest3() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        DoublyLinkedNode<Integer> node1 = new DoublyLinkedNode<Integer>(1);
        DoublyLinkedNode<Integer> node2 = new DoublyLinkedNode<Integer>(2);
        DoublyLinkedNode<Integer> node3 = new DoublyLinkedNode<Integer>(3);
        list.addFront(node1);
        list.addBack(node2);
        list.addBack(node3);
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(3, list.getLength());
        assertEquals(node2, node1.getNext());
        assertEquals(null, node1.getPrevious());
        assertEquals(node3, node2.getNext());
        assertEquals(node1, node2.getPrevious());
        assertEquals(null, node3.getNext());
        assertEquals(node2, node3.getPrevious());
        list.removeBack();
        assertEquals(node1, list.getHead());
        assertEquals(node2, list.getTail());
        assertEquals(2, list.getLength());
        assertEquals(node2, node1.getNext());
        assertEquals(null, node1.getPrevious());
        assertEquals(null, node2.getNext());
        assertEquals(node1, node2.getPrevious());
        assertEquals(null, node3.getNext());
        assertEquals(null, node3.getPrevious());
    }

    public void clearTest1() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        DoublyLinkedNode<Integer> node1 = new DoublyLinkedNode<Integer>(1);
        DoublyLinkedNode<Integer> node2 = new DoublyLinkedNode<Integer>(2);
        DoublyLinkedNode<Integer> node3 = new DoublyLinkedNode<Integer>(3);
        list.addFront(node1);
        list.addBack(node2);
        list.addBack(node3);
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(3, list.getLength());
        assertEquals(node2, node1.getNext());
        assertEquals(null, node1.getPrevious());
        assertEquals(node3, node2.getNext());
        assertEquals(node1, node2.getPrevious());
        assertEquals(null, node3.getNext());
        assertEquals(node2, node3.getPrevious());
        list.clear();
        assertEquals(null, list.getHead());
        assertEquals(null, list.getTail());
        assertEquals(0, list.getLength());
        assertEquals(null, node1.getNext());
        assertEquals(null, node1.getPrevious());
        assertEquals(null, node2.getNext());
        assertEquals(null, node2.getPrevious());
        assertEquals(null, node3.getNext());
        assertEquals(null, node3.getPrevious());
    }

    public void cloneShallowTest1() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        DoublyLinkedNode<Integer> node1 = new DoublyLinkedNode<Integer>(1);
        DoublyLinkedNode<Integer> node2 = new DoublyLinkedNode<Integer>(2);
        DoublyLinkedNode<Integer> node3 = new DoublyLinkedNode<Integer>(3);
        list.addFront(node1);
        list.addBack(node2);
        list.addBack(node3);
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(3, list.getLength());
        assertEquals(node2, node1.getNext());
        assertEquals(null, node1.getPrevious());
        assertEquals(node3, node2.getNext());
        assertEquals(node1, node2.getPrevious());
        assertEquals(null, node3.getNext());
        assertEquals(node2, node3.getPrevious());
        DoublyLinkedList<Integer> copy = list.cloneShallow();
        assertEquals(list.getHead(), copy.getHead());
        assertEquals(list.getTail(), copy.getTail());
        assertEquals(list.getLength(), copy.getLength());
    }
}

