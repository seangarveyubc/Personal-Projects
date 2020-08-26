package java.Node;

public class DoublyLinkedNode<E> {

    private DoublyLinkedNode<E> next;
    private DoublyLinkedNode<E> previous;
    private E data;

    public DoublyLinkedNode(E data) {
        this.next = null;
        this.previous = null;
        this.data = data;
    }

    public DoublyLinkedNode(E data, DoublyLinkedNode<E> next, DoublyLinkedNode<E> previous) {
        this.next = next;
        this.previous = previous;
        this.data = data;
    }

    public DoublyLinkedNode<E> getNext() {
        return this.next;
    }

    public void setNext(DoublyLinkedNode<E> next) {
        this.next = next;
    }

    public DoublyLinkedNode<E> getPrevious() {
        return this.previous;
    }

    public void setPrevious(DoublyLinkedNode<E> previous) {
        this.previous = previous;
    }

    public E getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return "DoublyLinkedNode{" +
                "next=" + this.next +
                ", previous=" + this.previous +
                ", data=" + this.data +
                '}';
    }

    public boolean equals(DoublyLinkedNode<E> node) {
        return (this.toString() == node.toString());
    }
}
