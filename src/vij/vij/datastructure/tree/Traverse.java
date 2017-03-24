package vij.vij.datastructure.tree;

import vij.vij.datastructure.tree.binarytree.Node;

import java.util.Stack;

/**
 * Created by Vijay on 2017, March 24.
 *
 * Tree traversals can be:
 *      Pre Order - root/current-node, left, right
 *      In Order/ASCENDING ORDER - left, root/current-node, right
 *      Post Order - left, right, root/current-node
 *      DESCENDING ORDER - right, root/current-node, left
 */
public class Traverse {

    public static final int TRAVERSAL_TYPE_PRE = 1;
    public static final int TRAVERSAL_TYPE_IN = 2;
    public static final int TRAVERSAL_TYPE_POST = 3;

    public static final int ASCENDING_ORDER = TRAVERSAL_TYPE_IN;
    public static final int DESCENDING_ORDER = 4;

    public static void traverseTree(Node rootNode, final int TRAVERSAL_TYPE) {

        if (TRAVERSAL_TYPE == TRAVERSAL_TYPE_PRE) {

            performPreOrderTraversal(rootNode);
        } else if (TRAVERSAL_TYPE == TRAVERSAL_TYPE_IN) {

            performInOrderTraversal(rootNode);
        } else if (TRAVERSAL_TYPE == TRAVERSAL_TYPE_POST) {

            performPostOrderTraversal(rootNode);
        } else if (TRAVERSAL_TYPE == DESCENDING_ORDER) {

            performDescendingOrderTraversal(rootNode);
        } else {

            System.err.println("UNSUPPORTED TRAVERSAL TYPE RECEIVED! " + TRAVERSAL_TYPE);
            System.out.println("SUPPORTED TRAVERSAL TYPES are Pre Order Traversal[" + TRAVERSAL_TYPE_PRE + "]" +
                    "In Order Traversal[" + TRAVERSAL_TYPE_IN + "]" +
                    "Post Order Traversal[" + TRAVERSAL_TYPE_POST + "]");
        }
    }

    private static void performPreOrderTraversal(Node treeNode) {

        if (treeNode != null) {

            System.out.print(treeNode.getNodeValue() + " ");
            performPreOrderTraversal(treeNode.getLeftNode());
            performPreOrderTraversal(treeNode.getRightNode());
        }
    }

    private static void performInOrderTraversal(Node treeNode) {

        if (treeNode != null) {

            performInOrderTraversal(treeNode.getLeftNode());
            System.out.print(treeNode.getNodeValue() + " ");
            performInOrderTraversal(treeNode.getRightNode());
        }
    }

    private static void performPostOrderTraversal(Node treeNode) {

        if (treeNode != null) {

            performPostOrderTraversal(treeNode.getLeftNode());
            performPostOrderTraversal(treeNode.getRightNode());
            System.out.print(treeNode.getNodeValue() + " ");
        }
    }

    private static void performDescendingOrderTraversal(Node treeNode) {

        if (treeNode != null) {

            performDescendingOrderTraversal(treeNode.getRightNode());
            System.out.print(treeNode.getNodeValue() + " ");
            performDescendingOrderTraversal(treeNode.getLeftNode());
        }
    }

    /**
     * This is an in order traversal of the tree using an iterative method.
     * @param treeNode Node
     */
    public static void getAscendingOrderArray(Node treeNode, int[] sortedArray) {

        if (treeNode == null) {
            return;
        }
        //keep the nodes in the path that are waiting to be visited
        Stack<Node> stack = new Stack<>();
        Node node = treeNode;

        //first node to be visited will be the left one
        while (node != null) {
            stack.push(node);
            node = node.getLeftNode();
        }

        int sortedArrayIdx = 0;
        // traverse the tree
        while (stack.size() > 0) {

            // visit the top node
            node = stack.pop();
            System.out.print(node.getNodeValue() + " ");
            sortedArray[sortedArrayIdx++] = node.getNodeValue();
            if (node.getRightNode() != null) {
                node = node.getRightNode();

                // the next node to be visited is the leftmost
                while (node != null) {
                    stack.push(node);
                    node = node.getLeftNode();
                }
            }
        }
        System.out.println("\nStack Size: " + stack.size());

    }

}