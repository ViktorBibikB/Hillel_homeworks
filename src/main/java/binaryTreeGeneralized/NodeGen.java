package binaryTreeGeneralized;

public class NodeGen<V> {
    private V value;
    private NodeGen<V> left;
    private NodeGen<V> right;

    public V getValue() {
        return value;
    }

    public NodeGen<V> getLeft() {
        return left;
    }

    public NodeGen<V> getRight() {
        return right;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setLeft(NodeGen<V> left) {
        this.left = left;
    }

    public void setRight(NodeGen<V> right) {
        this.right = right;
    }
}
