package com.example.tree;

public class Tree {
    private TreeNode root;

    public boolean isEvenOddTree() {
        return root.isEvenOddTree(root);
    }
    public void insert(int value) {
        if (root == null) root = new TreeNode(value);
        else root.insert(value);
    }
    public void traverseInOrder() {
        if (root != null) root.traversalInOrder();
    }

    public void delete(int value) {
        root = delete(root, value);
    }
    private TreeNode delete(TreeNode subtreeRoot, int value) {
        if (subtreeRoot == null) return null;
        if (value < subtreeRoot.getData())
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
        else if (value > subtreeRoot.getData())
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
        else {
            // case 1 and 2: node to delete has 0 or 1 children
            if (subtreeRoot.getLeftChild() == null)
                return subtreeRoot.getRightChild();
            else if (subtreeRoot.getRightChild() == null)
                return subtreeRoot.getLeftChild();
            // case 3: node to be deleted has 2 children
            else {
                // Replace the value in the subtreeRoot node with the smallest value from the right subTree
                subtreeRoot.setData(subtreeRoot.getRightChild().min());
                // Delete the node that has the smallest value in the right subTree
                subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));

            }
        }
        return subtreeRoot;
    }

    public TreeNode get(int value) {
        if (root != null) return root.get(value);
        return null;
    }
    public int min() {
        if (root != null) return root.min();
        return  -1;
    }
    public int max() {
        if (root != null) return root.max();
        return  -1;
    }
}
