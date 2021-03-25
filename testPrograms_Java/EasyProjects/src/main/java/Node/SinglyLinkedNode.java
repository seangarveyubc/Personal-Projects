package Node;

public class SinglyLinkedNode<E> {

    private SinglyLinkedNode<E> next;
    private E data;

    public SinglyLinkedNode(E data) {
        this.next = null;
        this.data = data;
    }

    public Node.SinglyLinkedNode<E> getNext() {
        return next;
    }

    public void setNext(Node.SinglyLinkedNode<E> next) {
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SinglyLinkedNode{" +
                "next=" + next +
                ", data=" + data +
                '}';
    }

}
