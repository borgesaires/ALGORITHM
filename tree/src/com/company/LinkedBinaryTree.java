package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
import java.util.Stack;

public class LinkedBinaryTree implements BinaryTree {

    public Node root;
    private Object Node;
    private Object LinkedList;

    public LinkedBinaryTree(Node root) {
        this.root = root;
    }


    //二叉树的高度
    @Override
    public int getHeight() {
        System.out.println("二叉树的高度");
        System.out.println(this.getHeight(root));
        return 0;
    }

    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        } else {
            int nl = this.getHeight(root.leftchild);
            int nr = this.getHeight(root.rightchild);
            return nl >= nr ? nl + 1 : nr + 1;
        }
    }

    @Override
    public int getDepth() {
        return 0;
    }

    //节点数
    @Override
    public int num() {
        System.out.println("节点个数");
        System.out.println(this.num(root));
        return 0;
    }

    private int num(Node root) {
        if (root == null) {
            return 0;
        } else {
            int nl = this.num(root.leftchild);
            int nr = this.num(root.rightchild);
            return nl + nr + 1;
        }
    }


    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public boolean insert() {
        return false;
    }

    //前序遍历递归
    @Override
    public void preOrderTerverse() {
        System.out.println("前序遍历");
        preOrderTerverse(root);
        System.out.println();
    }

    private void preOrderTerverse(Node root) {
        if (root != null) {
            System.out.println(root.data);
            this.preOrderTerverse(root.leftchild);
            this.preOrderTerverse(root.rightchild);
        }
    }

    //中序遍历递归
    @Override
    public void inOrderTerverse() {
        System.out.println("中序遍历");
        inOrderTerverse(root);
        System.out.println();
    }

    private void inOrderTerverse(Node root) {
        if (root != null) {
            this.inOrderTerverse(root.leftchild);
            System.out.println(root.data);
            this.inOrderTerverse(root.rightchild);
        }
    }


    //后序遍历递归
    @Override
    public void postOrderTerverse() {
        System.out.println("后序遍历");
        postOrderTerverse(root);
        System.out.println();
    }

    private void postOrderTerverse(Node root) {
        if (root != null) {
            this.postOrderTerverse(root.leftchild);
            this.postOrderTerverse(root.rightchild);
            System.out.println(root.data);
        }
    }

    //前序非递归
    @Override
    public void preOrderByStack() {
        System.out.println("前序非递归遍历");
        Deque<Node> stack = new LinkedList<Node>();
        Node current = root;
        stack.push(current);
        while(!stack.isEmpty()){
            current = stack.pop();
            System.out.print(current.data + " ");
            if(current.rightchild != null) stack.push(current.rightchild);
            if(current.leftchild != null) stack.push(current.leftchild);
        }System.out.println();
    }

    //中序非递归
    @Override
    public void inOrderByStack() {
        System.out.println("非递归中序遍历");
        Deque<Node> stack = new LinkedList<Node>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.leftchild;
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                System.out.print(current.data + " ");
                current = current.rightchild;
            }
        }
        System.out.println();
    }

    //后序非递归
    @Override
    public void postOrderByStack() {

    }

    //层次遍历
    @Override
    public void levelOraderByStack() {
        System.out.println("层次遍历：");
        if (root == null) return;
        else {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while (queue.size() != 0) {
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    Node temp = queue.poll();
                    System.out.println(temp.data + " ");
                    if (root.leftchild != null) queue.add(temp.leftchild);
                    if (root.rightchild != null) queue.add(temp.rightchild);
                }
            }
        }
    }
}
