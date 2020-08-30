package Stack;
import LinkedList.SinglyLinkedList;
import Node.SinglyLinkedNode;

public class SinglyStack<E> {
    private int size;
    private SinglyLinkedList<E> data;

    public SinglyStack<E>() {
        this.size = 0;
        this.data = new SinglyLinkedList<E>();
    }

    public void push(SinglyLinkedNode<E> node) {
        this.data.addBack();
        this.size++;
    }

    public SinglyLinkedNode<E> pop() {
        this.data.removeBack();
        this.size--;
    }

    public SinglyLinkedNode<E> peek () {
        SinglyLinkedNode<E> temp = this.data.removeBack();
        this.data.addBack(temp);
        return temp;
    }

    public void clear() {
        this.data.clear();
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

}
