package com.company;

public interface graphTest {


    public void insertVertex(String vertex);

    public void insertEdge(int v1, int v2, int weight);

    //边的数量
    public int getNumOfEdge();

    //节点的值
    public String getValueOfIndex(int i);

    //边的权值
    public int getNumOfWeight(int v1, int v2);

    //输出相邻矩阵
    public void putGraph();

    //第一个邻接节点的下标
    public int getFirstNeighbor(int index);

    //次邻接节点
    public int getNextNeighbor(int v1, int v2);

    //DFS
    public void DFS();

    //BFS
    public void BFS();

    public void dijkstra(int index);
}
