package Node;

public class SinglyLinkedNode<E> {

    private SinglyLinkedNode<E> next;
    private E data;

    public SinglyLinkedNode(E data) {
        this.next = null;
        this.data = data;
    }

    public SinglyLinkedNode(SinglyLinkedNode<E> next, E data) {
        this.next = next;
        this.data = data;
    }

    public SinglyLinkedNode<E> getNext() {
        return next;
    }

    public void setNext(SinglyLinkedNode<E> next) {
        this.next = next;
    }

    public E getData() {
        return data;
    }

    @Override
    public String toString() {
        return "SinglyLinkedNode{" +
                "next=" + next +
                ", data=" + data +
                '}';
    }

}
