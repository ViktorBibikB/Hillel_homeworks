package binaryTree;

public class BinaryTree{
    Node root;

    public int findNode(int value) {
        Node current = root;

        while (current.getValue() != value) {
            if(value < current.getValue())
                current = current.getLeft();
            else
                current = current.getRight();
            if(current == null)
                return 0;
        }
        return current.getValue();
    }

    public void addNode(int value) {
        Node newNode = new Node();
        newNode.setValue(value);

        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;

                if (value < parent.getValue()) {
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

    public Node getRoot(){
        return root;
    }

    public void preOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            System.out.print(focusNode.getValue() + " ");
            preOrderTraversal(focusNode.getLeft());
            preOrderTraversal(focusNode.getRight());
        }
    }
}
