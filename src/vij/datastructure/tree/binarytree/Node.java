package vij.datastructure.tree.binarytree;

/**
 * Created by Vijay on 2017, March 24.
 */
public class Node {

    //Tree Components
    private Node leftNode;
    private Node rightNode;
    private int nodeValue;

    //Tree Features
    private Boolean isParent; //When this is false, its the leaf node
    private Integer childCount; //When this returns 2, its a balanced binary tree node; when returns 0, its the leaf node
    private Integer level;

    public Node(int nodeValue) {

        this.setNodeValue(nodeValue);
    }

    public boolean isLeafNode() {

        return (getLeftNode() == null && getRightNode() == null);
    }

    public boolean isParent() {

        if (isParent == null) {

            isParent = getLeftNode() != null || getRightNode() != null;
        }
        return isParent;
    }

    public int getChildCount() {


        if (childCount == null) {

            if (isParent()) {
                childCount = (getLeftNode() != null ? 1 : 0) + (getRightNode() != null ? 1 : 0);
            } else {

                childCount = 0;
            }
        }
        return childCount;
    }

    public Node getLeftNode() {

        return leftNode;
    }

    public void setLeftNode(Node leftNode) {

        this.leftNode = leftNode;
    }

    public int getNodeValue() {

        return nodeValue;
    }

    public void setNodeValue(int nodeValue) {

        this.nodeValue = nodeValue;
    }

    public Node getRightNode() {

        return rightNode;
    }

    public void setRightNode(Node rightNode) {

        this.rightNode = rightNode;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

}