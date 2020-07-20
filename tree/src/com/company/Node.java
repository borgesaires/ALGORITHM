package com.company;

public class Node {
    int data;
    Node leftchild;
    Node rightchild;

    public Node(int data){
        this.data=data;
        this.leftchild = null;
        this.rightchild = null;
    }
    public Node(int data,Node rightchild,Node leftchild){
        this.data = data;
        this.leftchild = rightchild;
        this.rightchild = leftchild;
    }
}