package Node;

public class DoublyLinkedNode<E> {

    private DoublyLinkedNode<E> next;
    private DoublyLinkedNode<E> previous;
    private E data;

    public DoublyLinkedNode(E data) {
        this.next = null;
        this.previous = null;
        this.data = data;
    }

    public Node.DoublyLinkedNode<E> getNext() {
        return next;
    }

    public void setNext(Node.DoublyLinkedNode<E> next) {
        this.next = next;
    }

    public Node.DoublyLinkedNode<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node.DoublyLinkedNode<E> previous) {
        this.previous = previous;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DoublyLinkedNode{" +
                "next=" + this.next +
                ", previous=" + this.previous +
                ", data=" + this.data +
                '}';
    }
}
