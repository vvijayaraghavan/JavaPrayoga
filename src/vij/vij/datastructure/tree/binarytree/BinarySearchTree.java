package vij.vij.datastructure.tree.binarytree;

import vij.vij.datastructure.tree.Traverse;

/**
 * Created by Vijay on 2017, March 24.
 */
public class BinarySearchTree {

    private Node rootNode;

    public BinarySearchTree(Node rootNode) {

        this.rootNode = rootNode;
    }

    public static void main(String[] args) {

        int[] arr = { 0, 9, 5, 2, 3, 4, 9, 12, 8, 1, 18, 13, 16 };
        BinarySearchTree binaryTree = new BinarySearchTree(new Node(arr[0]));

        for (int i = 1; i < arr.length; i++) {
            binaryTree.insertNode(binaryTree.rootNode, arr[i]);
        }

        System.out.println("Traversing PRE");
        Traverse.traverseTree(binaryTree.rootNode, Traverse.TRAVERSAL_TYPE_PRE);
        System.out.println("\nTraversing IN / ASCENDING ORDER");
        Traverse.traverseTree(binaryTree.rootNode, Traverse.TRAVERSAL_TYPE_IN);
        System.out.println("\nTraversing POST");
        Traverse.traverseTree(binaryTree.rootNode, Traverse.TRAVERSAL_TYPE_POST);
        System.out.println("\nTraversing DESCENDING ORDER");
        Traverse.traverseTree(binaryTree.rootNode, Traverse.DESCENDING_ORDER);
    }

    public void insertNode(Node parentNode, int nodeValue) {

        if (nodeValue < parentNode.getNodeValue()) {

            if (parentNode.getLeftNode() != null) {

                insertNode(parentNode.getLeftNode(), nodeValue);
            } else {

//                System.out.println("Adding " + nodeValue + " to left of " + parentNode.getNodeValue());
                parentNode.setLeftNode(new Node(nodeValue));
            }
        } else if (nodeValue > parentNode.getNodeValue()) {

            if (parentNode.getRightNode() != null) {

                insertNode(parentNode.getRightNode(), nodeValue);
            } else {

//                System.out.println("Adding " + nodeValue + " to right of " + parentNode.getNodeValue());
                parentNode.setRightNode(new Node(nodeValue));
            }
        } else {

            // You may avoid duplicates by this condition
            // Otherwise you can omit this else block and
            // depending on the requirement, you man add the parent's equivalent value to either right or left
//            System.err.println("Given value " + nodeValue + " is equal to the current parent node! NOT ADDING!!");
        }
    }

    // Another way of inserting
    /*public Node insert(Node node, Integer x) {
        if (node == null) {
            return node = new Node(x);
        }
        if (x < (Integer) node.getNodeValue()) {
            node.setLeftNode(insert(node.getLeftNode(), x));
        } else {
            node.setRightNode(insert(node.getRightNode(), x));
        }
        return node;
    }*/
}