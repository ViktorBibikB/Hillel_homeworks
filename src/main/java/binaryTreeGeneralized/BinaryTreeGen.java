package binaryTreeGeneralized;

public class BinaryTreeGen<V extends Comparable<V>> {
    NodeGen<V> root;

    public V findNode(V value) {
        NodeGen<V> current = root;

        while (current.getValue() != value) {
            if(value.compareTo(current.getValue()) < 0)
                current = current.getLeft();
            else
                current = current.getRight();
            if(current == null)
                return null;
        }
        return current.getValue();
    }

    public void addNode(V value) {
        NodeGen<V> newNode = new NodeGen<V>();
        newNode.setValue(value);

        if (root == null)
            root = newNode;
        else {
            NodeGen<V> current = root;
            NodeGen<V> parent;

            while (true) {
                parent = current;

                if (value.compareTo(parent.getValue()) < 0) {
                    current = current.getLeft();

                    if (current == null) {
                        parent.setLeft(newNode);
                        return;
                    }
                } else {
                    current = current.getRight();

                    if (current == null) {
                        parent.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }

    public void preOrderTraversal(NodeGen<V> focusNode) {
        if (focusNode != null) {
            System.out.print(focusNode.getValue() + " ");
            preOrderTraversal(focusNode.getLeft());
            preOrderTraversal(focusNode.getRight());
        }
    }

    public NodeGen<V> getRoot(){
        return root;
    }
}
