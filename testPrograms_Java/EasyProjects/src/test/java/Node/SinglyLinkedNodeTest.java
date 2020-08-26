package Node;


import LinkedList.SinglyLinkedList;
import org.junit.Test;
import static org.junit.Assert.*;


public class SinglyLinkedNodeTest {

    @Test
    public void ConstructorTest1() {
        assertEquals(new Integer(1), new SinglyLinkedNode<Integer>(1).getData());
    }

    @Test
    public void test2() {
        assertEquals("Hello", new SinglyLinkedNode<String>("Hello").getData());
    }

    @Test
    public void test3() {
        assertEquals(null, new SinglyLinkedNode<Integer>(null, 1).getNext());
    }

    @Test
    public void test4() {
        assertEquals(new Integer(1), new SinglyLinkedNode<Integer>(1).getData());
    }

    @Test
    public void test5() {
        assertEquals(new Integer(1), new SinglyLinkedNode<Integer>(1).getData());
    }
}
