package vij.datastructure.tree.binarytree;

import vij.datastructure.tree.Traverse;

/**
 * Created by Vijay on 2017, March 24.
 *
 * This program
 *      1. Creates a Binary Search Tree with integers.
 *      2. Performs all the traversal routes on the tree (PRE, IN, POST).
 *      3. Lists the node values in ascending and descending order.
 *      4. Displays the tree height/depth of both left and right sub tree.
 *          The overall height/depth of the tree is always the max(left sub tree, right sub tree)
 */
public class BinarySearchTree {

    private Node rootNode;

    public BinarySearchTree(Node rootNode) {

        this.rootNode = rootNode;
        this.rootNode.setLevel(1); //By default, the root node's level is 1
    }

    public static void main(String[] args) {

        int[] arr = { 9, 0, 5, 2, 3, 4, 9, 12, 8, 1, 18, 13, 16 };
        BinarySearchTree binaryTree = new BinarySearchTree(new Node(arr[0]));

        for (int i = 1; i < arr.length; i++) {
            binaryTree.insertNode(binaryTree.rootNode, arr[i]); //Always insert the node(s) from root-node
        }

        System.out.println("Traversing PRE ORDER");
        Traverse.traverse(binaryTree.rootNode, Traverse.TRAVERSAL_POLICY.PRE_ORDER_TRAVERSAL);
        System.out.println("\nTraversing IN ORDER");
        Traverse.traverse(binaryTree.rootNode, Traverse.TRAVERSAL_POLICY.IN_ORDER_TRAVERSAL);
        System.out.println("\nTraversing POST ORDER");
        Traverse.traverse(binaryTree.rootNode, Traverse.TRAVERSAL_POLICY.POST_ORDER_TRAVERSAL);

        //Listing nodes in ascending order is same as the IN ORDER TRAVERSAL Policy
        System.out.println("\nListing node values in ASCENDING ORDER");
        Traverse.listTreeNodes(binaryTree.rootNode, Traverse.TREE_SORT_ORDER.ASCENDING_ORDER);
        System.out.println("\nListing node values in DESCENDING ORDER");
        Traverse.listTreeNodes(binaryTree.rootNode, Traverse.TREE_SORT_ORDER.DESCENDING_ORDER);

        System.out.println("\nFINDING HEIGHT OF LEFT SUB TREE");
        Traverse.getTreeHeight(binaryTree.rootNode, Traverse.SUB_TREE.LEFT_SUB_TREE);
        System.out.println("\nFINDING HEIGHT OF RIGHT SUB TREE");
        Traverse.getTreeHeight(binaryTree.rootNode, Traverse.SUB_TREE.RIGHT_SUB_TREE);

        System.out.println("\nLOWEST COMMON ANCESTOR OF 4,8");
        Node lowestCommAnces = Traverse.lowestCommonAncestor(binaryTree.rootNode, 4, 8);
        System.out.println(lowestCommAnces != null ? lowestCommAnces.getNodeValue() : "No Ancestor available for the given values!");
        System.out.println("\nLOWEST COMMON ANCESTOR OF 13,16");
        lowestCommAnces = Traverse.lowestCommonAncestor(binaryTree.rootNode, 13, 16);
        System.out.println(lowestCommAnces != null ? lowestCommAnces.getNodeValue() : "No Ancestor available for the given values!");
        System.out.println("\nLOWEST COMMON ANCESTOR OF 11,16");
        lowestCommAnces = Traverse.lowestCommonAncestor(binaryTree.rootNode, 11, 16);
        System.out.println(lowestCommAnces != null ? lowestCommAnces.getNodeValue() : "No Ancestor available for the given values!");
        System.out.println("\nLOWEST COMMON ANCESTOR OF 3,4");
        lowestCommAnces = Traverse.lowestCommonAncestor(binaryTree.rootNode, 3, 4);
        System.out.println(lowestCommAnces != null ? lowestCommAnces.getNodeValue() : "No Ancestor available for the given values!");
        System.out.println("\nLOWEST COMMON ANCESTOR OF 13,18");
        lowestCommAnces = Traverse.lowestCommonAncestor(binaryTree.rootNode, 13, 18);
        System.out.println(lowestCommAnces != null ? lowestCommAnces.getNodeValue() : "No Ancestor available for the given values!");
        System.out.println("\nLOWEST COMMON ANCESTOR OF 12,8");
        lowestCommAnces = Traverse.lowestCommonAncestor(binaryTree.rootNode, 12, 8);
        System.out.println(lowestCommAnces != null ? lowestCommAnces.getNodeValue() : "No Ancestor available for the given values!");

        System.out.println("Tree Max Depth: " + Traverse.getTreeDepth(binaryTree.rootNode));
    }

    /**
     * This method inserts the node based on the nodeValue as per the laws of binary search tree.
     * This also computes the node-level and stores inside the node object.
     *
     * @param parentNode Node
     * @param nodeValue int
     */
    public void insertNode(Node parentNode, int nodeValue) {

        if (nodeValue < parentNode.getNodeValue()) {

            if (parentNode.getLeftNode() != null) {

                insertNode(parentNode.getLeftNode(), nodeValue);
            } else {

                Node leftChildNode = new Node(nodeValue);
                parentNode.setLeftNode(leftChildNode);
                leftChildNode.setLevel(parentNode.getLevel() + 1);
                System.out.println("Level of " + nodeValue + " is [" + leftChildNode.getLevel() + "]");
            }
        } else if (nodeValue > parentNode.getNodeValue()) {

            if (parentNode.getRightNode() != null) {

                insertNode(parentNode.getRightNode(), nodeValue);
            } else {

                Node rightChildNode = new Node(nodeValue);
                parentNode.setRightNode(rightChildNode);
                rightChildNode.setLevel(parentNode.getLevel() + 1);
                System.out.println("Level of " + nodeValue + " is [" + rightChildNode.getLevel() + "]");
            }
        } else {

            // You may avoid duplicates by this condition
            // Otherwise you can omit this else block and
            // depending on the requirement, you man add the parent's equivalent value to either right or left
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