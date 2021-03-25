package LinkedList;

import Exceptions.EmptyListException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import Node.SinglyLinkedNode;

public class SinglyLinkedListTest {

    @Test
    public void ConstructorTest1 () {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        assertEquals(null, list.getHead());
        assertEquals(null, list.getTail());
        assertEquals(0, list.getLength());
    }

    @Test
    public void addTest1 () {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<Integer>(1);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<Integer>(2);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.addFront(node1);
        assertEquals(node1, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(1, list.getLength());
        list.addFront(node2);
        assertEquals(node2, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(2, list.getLength());
    }

    @Test
    public void addTest2 () {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<Integer>(1);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<Integer>(2);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.addFront(node1);
        list.addFront(node2);
        assertEquals(node2, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(2, list.getLength());
    }

    @Test
    public void addTest3 () {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<Integer>(1);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<Integer>(2);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.addFront(node1);
        list.addBack(node2);
        assertEquals(node1, list.getHead());
        assertEquals(node2, list.getTail());
        assertEquals(2, list.getLength());
    }

    @Test
    public void removeTest1 () {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<Integer>(1);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<Integer>(2);
        SinglyLinkedNode<Integer> node3 = new SinglyLinkedNode<Integer>(3);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.addFront(node1);
        list.addFront(node2);
        list.addFront(node3);
        list.print();
        assertEquals(node3, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(3, list.getLength());
        try {
            list.removeFront();
        } catch (EmptyListException error) {
            System.out.println("Error removing front node.");
        }
        list.print();
        assertEquals(node2, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(2, list.getLength());
        list.print();
    }

    @Test
    public void removeTest2 () {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<Integer>(1);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<Integer>(2);
        SinglyLinkedNode<Integer> node3 = new SinglyLinkedNode<Integer>(3);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.addFront(node1);
        list.addFront(node2);
        list.addFront(node3);
        list.print();
        assertEquals(node3, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(3, list.getLength());
        try {
            list.removeBack();
        } catch (EmptyListException error) {
            System.out.println("Error removing back Node.");
        }
        list.print();
        assertEquals(node3, list.getHead());
        assertEquals(node2, list.getTail());
        assertEquals(2, list.getLength());
        list.print();
    }

    @Test
    public void removeTest3 () {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<Integer>(1);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<Integer>(2);
        SinglyLinkedNode<Integer> node3 = new SinglyLinkedNode<Integer>(3);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.addFront(node1);
        list.addFront(node2);
        list.addFront(node3);
        list.print();
        assertEquals(node3, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(3, list.getLength());
        list.remove(node2);
        assertEquals(node3, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(2, list.getLength());
        list.print();
    }

    @Test
    public void removeTest4 () {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<Integer>(1);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<Integer>(2);
        SinglyLinkedNode<Integer> node3 = new SinglyLinkedNode<Integer>(3);
        SinglyLinkedNode<Integer> node4 = new SinglyLinkedNode<Integer>(4);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.addFront(node1);
        list.addFront(node2);
        list.addFront(node3);
        list.print();
        assertEquals(node3, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(3, list.getLength());
        list.remove(node4);
        assertEquals(node3, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(3, list.getLength());
        list.print();
    }

    @Test
    public void clearTest1 () {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<Integer>(1);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<Integer>(2);
        SinglyLinkedNode<Integer> node3 = new SinglyLinkedNode<Integer>(3);
        SinglyLinkedNode<Integer> node4 = new SinglyLinkedNode<Integer>(4);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.addFront(node1);
        list.addFront(node2);
        list.addFront(node3);
        list.addFront(node4);
        list.print();
        assertEquals(node4, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(4, list.getLength());
        list.clear();
        assertEquals(null, list.getHead());
        assertEquals(null, list.getTail());
        assertEquals(0, list.getLength());
        list.print();
    }

    @Test
    public void cloneShallowTest1 () {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<Integer>(1);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<Integer>(2);
        SinglyLinkedNode<Integer> node3 = new SinglyLinkedNode<Integer>(3);
        SinglyLinkedNode<Integer> node4 = new SinglyLinkedNode<Integer>(4);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.addFront(node1);
        list.addFront(node2);
        list.addFront(node3);
        list.addFront(node4);
        SinglyLinkedList<Integer> copy = list.cloneShallow();
        list.print();
        copy.print();
        assertEquals(node4, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(4, list.getLength());
        assertEquals(node4, copy.getHead());
        assertEquals(node1, copy.getTail());
        assertEquals(4, list.getLength());
        list.print();
        copy.print();
    }

    @Test
    public void containsTest1 () {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<Integer>(1);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<Integer>(2);
        SinglyLinkedNode<Integer> node3 = new SinglyLinkedNode<Integer>(3);
        SinglyLinkedNode<Integer> node4 = new SinglyLinkedNode<Integer>(4);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.addFront(node1);
        list.addFront(node2);
        list.addFront(node3);
        SinglyLinkedList<Integer> copy = list.cloneShallow();
        list.print();
        assertEquals(true, list.contains(node1));
        assertEquals(true, list.contains(node2));
        assertEquals(true, list.contains(node3));
        assertEquals(false, list.contains(node4));
        list.print();
    }

    @Test
    public void isSameTest1 () {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<Integer>(1);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<Integer>(2);
        SinglyLinkedNode<Integer> node3 = new SinglyLinkedNode<Integer>(3);
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
        list1.addFront(node1);
        list1.addFront(node2);
        list1.addFront(node3);
        list2.addFront(node1);
        list2.addFront(node2);
        list2.addFront(node3);
        list1.print();
        list2.print();
        assertEquals(true, list1.isSame(list2));
    }

    @Test
    public void isSameTest2 () {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<Integer>(1);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<Integer>(2);
        SinglyLinkedNode<Integer> node3 = new SinglyLinkedNode<Integer>(3);
        SinglyLinkedNode<Integer> node4 = new SinglyLinkedNode<Integer>(4);
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
        list1.addFront(node1);
        list1.addFront(node2);
        list1.addFront(node3);
        SinglyLinkedList<Integer> list2 = list1.cloneShallow();
        list1.print();
        list2.print();
        assertEquals(true, list1.isSame(list2));
    }

    @Test
    public void isSameTest3 () {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<Integer>(1);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<Integer>(2);
        SinglyLinkedNode<Integer> node3 = new SinglyLinkedNode<Integer>(3);
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
        list1.addFront(node1);
        list1.addFront(node2);
        list1.addFront(node3);
        list2.addFront(node1);
        list2.addFront(node2);
        list2.addFront(node4);
        list1.print();
        list2.print();
        assertEquals(false, list1.isSame(list2));
    }

}
