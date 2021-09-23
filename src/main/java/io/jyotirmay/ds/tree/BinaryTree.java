package io.jyotirmay.ds.tree;

import java.io.Serializable;

public class BinaryTree<T> implements Serializable {

    private static class Node<T> implements Serializable {

        private T data;

        private Node<T> parent, left, right;

        private Node(T data) {
            this.data = data;
        }

    }

    private int size;

    private Node<Comparable<T>> root;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(Node<Comparable<T>> node, T data) {

        if (null == node)
            node = root;

        if (null == root) {
            root = new Node(data);
            size++;
            return;
        } else {
            if (node.data.compareTo(data) > 0) {
                if (null == node.left) {
                    node.left = new Node(data);
                    size++;
                    return;
                } else {
                    insert(node.left, data);
                }
            } else {
                if (null == node.right) {
                    node.right = new Node(data);
                    size++;
                    return;
                } else {
                    insert(node.right, data);
                }
            }
        }

    }

    public boolean contains(Node<Comparable<T>> node, T data) {

        if (null == node)
            node = root;

        if (null == root)
            return false;

        if (node.data.compareTo(data) == 0)
            return true;

        if (node.data.compareTo(data) < 0) {
            if (node.left == null)
                return false;
            return contains(node.left, data);
        } else {
            if (node.right == null)
                return false;
            return contains(node.right, data);
        }
    }

    public void printInOrder(Node<Comparable<T>> node) {

        if (null == node)
            node = root;

        if (null != node.left)
            printInOrder(node.left);

        System.out.println("node: " + node.data);

        if (null != node.right)
            printInOrder(node.right);
    }

    public void printPreOrder(Node<Comparable<T>> node) {
        if (null == node)
            node = root;

        System.out.println("node: " + node.data);

        if (null != node.left)
            printPreOrder(node.left);

        if (null != node.right)
            printPreOrder(node.right);
    }

    public void printPostOrder(Node<Comparable<T>> node) {

        if (null == node)
            node = root;

        if (null != node.left)
            printPostOrder(node.left);

        if (null != node.right)
            printPostOrder(node.right);

        System.out.println("node: " + node.data);
    }

}
