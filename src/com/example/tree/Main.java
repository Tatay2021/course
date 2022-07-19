package com.example.tree;

public class Main {
    public static void main(String[] args) {
        Tree intTree = new Tree();
        intTree.insert(5);
        intTree.insert(4);
        intTree.insert(2);
        intTree.insert(3);
        intTree.insert(3);
        intTree.insert(7);
//        intTree.traverseInOrder();
        System.out.println(intTree.isEvenOddTree());
    }
}
