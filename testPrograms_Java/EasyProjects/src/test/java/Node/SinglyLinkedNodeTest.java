package Node;


import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;


public class SinglyLinkedNodeTest {

    @Test
    public void ConstructorIntTest() {
        String testString = "SinglyLinkedNode{" +
                            "next=null" +
                            ", data=1" +
                            "}";
        String resultString = new SinglyLinkedNode<Integer>(1).toString();
        assertEquals(testString, resultString);
    }

    @Test
    public void ConstructorObjectTest() {
        Date testDate = new Date();
        Date resultDate = (Date) testDate.clone();
        assertEquals(testDate.toString(), resultDate.toString());
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
