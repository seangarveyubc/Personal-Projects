package Node;

import LinkedList.SinglyLinkedList;
import Utility.Pair;

public class GraphNode<E> {

    private E data;
    private SinglyLinkedList<Pair<GraphNode, Integer>> neighbours;

    public GraphNode(E data) {
        this.data = data;
        this.neighbours = new SinglyLinkedList<Pair<GraphNode, Integer>>();
    }

    public E getData() {
        return this.data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public SinglyLinkedList<Pair<GraphNode, Integer>> getNeighbours() {
        return this.neighbours;
    }

    public SinglyLinkedList<Pair<GraphNode, Integer>> getPair() {
        return this.neighbours;
    }

    public void addNeighbour(GraphNode node, int cost) {
        this.neighbours.addFront(new SinglyLinkedNode<Pair<GraphNode, Integer>>(new Pair<GraphNode, Integer>(node, cost)));
    }

    public void removeNeighbour(GraphNode node) {
        Pair<GraphNode, Integer> temp = this.neighbours.getPair
        this.neighbours.remove(new SinglyLinkedNode<Pair<GraphNode, Integer>>(new Pair<GraphNode, Integer>()))

    }
}
