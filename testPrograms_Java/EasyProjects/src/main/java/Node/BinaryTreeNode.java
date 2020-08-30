package Node;

public class BinaryTreeNode<E> {

    private BinaryTreeNode<E> left;
    private BinaryTreeNode<E> right;
    private E data;

    public BinaryTreeNode(E data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }

    public BinaryTreeNode<E> getLeft() {
        return this.left;
    }

    public void setLeft(BinaryTreeNode<E> left) {
        this.left = left;
    }

    public BinaryTreeNode<E> getRight() {
        return this.right;
    }

    public void setRight(BinaryTreeNode<E> right) {
        this.right = right;
    }

    public E getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "left=" + left +
                ", right=" + right +
                ", data=" + data +
                '}';
    }
}
