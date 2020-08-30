package LinkedList;

import Exceptions.UnisolatedNodeException;
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
    public void ConstructorTest2 () {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<Integer>(1);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>(node1);
        assertEquals(node1, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(1, list.getLength());
    }

    @Test
    public void addTest1 () {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<Integer>(1);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<Integer>(2);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.add(node1);
        assertEquals(node1, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(1, list.getLength());
    }

    @Test
    public void addTest2 () {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<Integer>(1);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<Integer>(2);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.add(node1);
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
        list.add(node1);
        try {
            list.addBack(node2);
        } catch (UnisolatedNodeException error) {
            System.out.println(error);
        }
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
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.print();
        assertEquals(node3, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(3, list.getLength());
        list.remove();
        list.print();
        assertEquals(node2, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(2, list.getLength());
    }

    @Test
    public void removeTest2 () {
        SinglyLinkedNode<Integer> node1 = new SinglyLinkedNode<Integer>(1);
        SinglyLinkedNode<Integer> node2 = new SinglyLinkedNode<Integer>(2);
        SinglyLinkedNode<Integer> node3 = new SinglyLinkedNode<Integer>(3);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.print();
        assertEquals(node3, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(3, list.getLength());
        list.removeBack();
        list.print();
        assertEquals(node3, list.getHead());
        assertEquals(node2, list.getTail());
        assertEquals(2, list.getLength());
        list.clear();
        list.print();
    }

}
