package com.company;

public class Main {

    public static void main(String[] args) {
	// 建立二叉树
        Node node3 = new Node(3,null,null);
        Node node2 = new Node(2,null,null);
        Node node1 = new Node(1, node2, node3);

        BinaryTree btree = new LinkedBinaryTree(node1);

        btree.preOrderTerverse();

        btree.inOrderTerverse();

        btree.postOrderTerverse();

        btree.getHeight();

        btree.num();

        //btree.levelOrderByStack();

        btree.inOrderByStack();

        btree.preOrderByStack();

    }
}
