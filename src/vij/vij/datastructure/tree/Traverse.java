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

    public enum TRAVERSAL_POLICY{PRE_ORDER_TRAVERSAL, IN_ORDER_TRAVERSAL, POST_ORDER_TRAVERSAL}

    public enum TREE_SORT_ORDER{ASCENDING_ORDER, DESCENDING_ORDER}

    public enum SUB_TREE{LEFT_SUB_TREE, RIGHT_SUB_TREE}

    public static void traverse(Node rootNode, final TRAVERSAL_POLICY traversal_policy) {

        switch(traversal_policy) {

            case PRE_ORDER_TRAVERSAL:
                performPreOrderTraversal(rootNode);
                break;
            case IN_ORDER_TRAVERSAL:
                performInOrderTraversal(rootNode);
                break;
            case POST_ORDER_TRAVERSAL:
                performPostOrderTraversal(rootNode);
                break;
            default:
                System.err.println("Given traversal policy '" + traversal_policy + "' is NOT DEFINED!");
        }
    }

    public static void listTreeNodes(Node rootNode, final TREE_SORT_ORDER treeSortOrder) {

        switch (treeSortOrder) {

            case ASCENDING_ORDER:
                listNodesByAscendingOrder(rootNode);
                break;
            case DESCENDING_ORDER:
                listNodesByDescendingOrder(rootNode);
                break;
            default:
                System.err.println("Given Sorting Order '" + treeSortOrder + "' is NOT DEFINED!");
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

    private static void listNodesByAscendingOrder(Node treeNode) {

        if (treeNode != null) {

            listNodesByAscendingOrder(treeNode.getLeftNode());
            System.out.print(treeNode.getNodeValue() + " ");
            listNodesByAscendingOrder(treeNode.getRightNode());
        }
    }

    private static void listNodesByDescendingOrder(Node treeNode) {

        if (treeNode != null) {

            listNodesByDescendingOrder(treeNode.getRightNode());
            System.out.print(treeNode.getNodeValue() + " ");
            listNodesByDescendingOrder(treeNode.getLeftNode());
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

    public static void getTreeHeight(Node rootNode, final SUB_TREE subTree) {

        System.out.println("node val: " + rootNode.getNodeValue());
        if (rootNode == null) {

            System.err.println("The given node does not have any descendants!");
        }

        switch (subTree) {

            case LEFT_SUB_TREE:
                System.out.println("Root Node Value: " + rootNode.getNodeValue());
                Node leftSubTreeNode = rootNode.getLeftNode();
                if (leftSubTreeNode == null) {
                    System.out.println("Height of left sub tree is: 0");
                } else {
                    int leftSubTreeHeight = computeSubTreeHeight(leftSubTreeNode);
                    System.out.println("Height of left sub tree is: " + (leftSubTreeHeight));
                }
                break;
            case RIGHT_SUB_TREE:
                System.out.println("Root Node Value: " + rootNode.getNodeValue());
                Node rightSubTreeNode = rootNode.getRightNode();
                if (rightSubTreeNode == null) {
                    System.out.println("Height of right sub tree is: 0");
                } else {
                    int rightSubTreeHeight = computeSubTreeHeight(rightSubTreeNode);
                    System.out.println("Height of right sub tree is: " + (rightSubTreeHeight));
                }
                break;
            default:
                System.err.println("The given argument '" + subTree + "' is INVALID!");
        }
    }

    /**
     * Returns the maximum depth of the tree comparing left and right subtrees from the given node.
     * @param node Node
     * @return Integer
     */
    public static Integer getTreeDepth(Node node) {

        if (node == null) {
            return 0;
        } else {
            /* compute the depth of each subtree */
            int lDepth = getTreeDepth(node.getLeftNode());
            int rDepth = getTreeDepth(node.getRightNode());

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    /**
     * This method uses the attribute 'level' in the Node object
     * @param node Node
     * @return Integer
     */
    private static Integer computeSubTreeHeight(Node node) {

        int leftNodeLevel;
        if (node.getLeftNode() == null) {
            leftNodeLevel = node.getLevel();
        } else {
            leftNodeLevel = computeSubTreeHeight(node.getLeftNode());
        }
        int rightNodeLevel;
        if (node.getRightNode() == null) {
            rightNodeLevel = node.getLevel();
        } else {
            rightNodeLevel = computeSubTreeHeight(node.getRightNode());
        }

        return Math.max(leftNodeLevel, rightNodeLevel);
    }

    /**
     * This implementation assumes the Node that is passed is from a binary search tree.
     *
     * @param startNode Node
     * @param firstValue int
     * @param secondValue int
     *
     * @return Node - which is the lowest common ancestor
     */
    public static Node lowestCommonAncestor(Node startNode, int firstValue, int secondValue) {

        while (startNode != null) {

            int startNodeValue = startNode.getNodeValue();
            if (startNodeValue > firstValue && startNodeValue > secondValue) {
                startNode = startNode.getLeftNode();
            } else if (startNodeValue < firstValue && startNodeValue < secondValue) {
                startNode = startNode.getRightNode();
            } else {
                return startNode;
            }
        }
        return null;
    }

}