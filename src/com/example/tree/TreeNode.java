package com.example.tree;

public class TreeNode {
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value == data) {
            return;
        }
        if (value < data) {
            if (leftChild == null) leftChild = new TreeNode(value);
            else leftChild.insert(value);
        } else {
            if (rightChild == null) rightChild = new TreeNode(value);
            else rightChild.insert(value);
        }
    }

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return false;
        if (root.leftChild != null && root.leftChild.data % 2 == 0) {
            return root.rightChild != null && root.rightChild.data <= root.leftChild.data;
        }
        if (root.rightChild != null && root.rightChild.data % 2 == 0) {
            return root.leftChild != null && root.rightChild.data >= root.leftChild.data;
        }
        return isEvenOddTree(root.leftChild) && isEvenOddTree(root.rightChild);
    }


    public TreeNode get(int value) {
        if (value == data) return this;
        if (value < data && leftChild != null) return leftChild.get(value);
        else if (rightChild != null)return rightChild.get(value);
        return null;
    }

    public int min() {
        if (leftChild == null) return data;
        else return leftChild.min();
    }
    public int max() {
        if (rightChild == null) return data;
        else return rightChild.max();
    }

    public void traversalInOrder() {
        System.out.println("Data = " + data + ", ");
        if (leftChild != null) leftChild.traversalInOrder();
        if (rightChild != null) rightChild.traversalInOrder();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
