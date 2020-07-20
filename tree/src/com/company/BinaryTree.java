package com.company;

public interface BinaryTree {


    //该树的高度
    public int getHeight();

    //该树的深度
    public int getDepth();

    //该树的节点数
    public int num();

    //删除操作
    public boolean delete();

    //插入操作
    public boolean insert();

    //前序遍历
    public void preOrderTerverse();

    //中序遍历
    public void inOrderTerverse();

    //后序遍历
    public void postOrderTerverse();

    //前序遍历非递归
    public void preOrderByStack();

    //中序遍历非递归
    public void inOrderByStack();

    //后序遍历非递归
    public void postOrderByStack();

    //层次遍历
    public void levelOraderByStack();

}
