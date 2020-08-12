package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        graphDemo g = new graphDemo();
        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");
        g.insertVertex("E");

        //dijkstra需要初始化边矩阵，使0值变为N

        g.djkMatrix();


        g.insertEdge(0, 1, 1);
        g.insertEdge(0, 2, 1);
        g.insertEdge(2, 3, 1);
        g.insertEdge(1, 4, 1);
        g.putGraph();
        g.DFS();
        g.BFS();

        //g.floyd();
        //g.prim(0);
        g.topologicalSort();
    }
}
