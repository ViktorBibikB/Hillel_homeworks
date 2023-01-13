import binaryTree.BinaryTree;
import binaryTreeGeneralized.BinaryTreeGen;

public class Main {
    public static void main(String[] args) {
        BinaryTreeGen<Integer> binaryTree = new BinaryTreeGen<>();

        binaryTree.addNode(50);
        binaryTree.addNode(25);
        binaryTree.addNode(75);
        binaryTree.addNode(12);
        binaryTree.addNode(37);
        binaryTree.addNode(83);
        binaryTree.addNode(30);
        binaryTree.addNode(96);
        binaryTree.addNode(30);
        binaryTree.addNode(30);


        binaryTree.preOrderTraversal(binaryTree.getRoot());

        System.out.println();
        System.out.println(binaryTree.findNode(75));
        System.out.println(binaryTree.findNode(58));


        BinaryTree binTree = new BinaryTree();

        binTree.addNode(50);
        binTree.addNode(25);
        binTree.addNode(75);
        binTree.addNode(12);
        binTree.addNode(37);
        binTree.addNode(83);
        binTree.addNode(30);
        binTree.addNode(96);
        binTree.addNode(30);
        binTree.addNode(30);


        binTree.preOrderTraversal(binTree.getRoot());

        System.out.println();
        System.out.println(binTree.findNode(75));
        System.out.println(binTree.findNode(58));
    }
}
