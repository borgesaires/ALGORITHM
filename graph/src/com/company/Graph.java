package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    ArrayList<String> vertexList;
    int[][] edges;
    int numOfEdges;

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }
}
class VisitedVertex {
    public int[] visited;
    public int[] pre_visited;
    //distance
    public int[] d;


    //num 顶点个数 index 初始点下标
    public VisitedVertex(int num, int index) {
        this.visited = new int[num];
        this.pre_visited = new int[num];
        this.d = new int[num];

        //初始化
        Arrays.fill(d, 65535);
        //设置初始点为访问过
        this.visited[index] = 1;
        this.d[index] = 0;
    }

    //判断是否访问过
    public boolean vis(int index) {
        return visited[index] == 1;
    }

    //更新距离
    public void updateDistance(int index, int len) {
        d[index] = len;
    }

    //更新前驱节点
    public void updatePre(int pre, int index) {
        pre_visited[pre] = index;
    }

    //出发点到index的距离
    public int getDis(int index) {
        return d[index];
    }

    //更新新出发节点
    public int updateArr() {
        int min = 65535, index = 0;
        //当前距离current最近的顶点
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0 && d[i] < min) {
                min = d[index];
                index = i;
            }
        }
        visited[index] = 1;
        return index;
    }
}



class FloydGraph {
    public ArrayList<String> vertex;
    public int[][] pre;
    public int[][] d;


    public FloydGraph(int length, int[][] edges, ArrayList vertex) {
        this.vertex = vertex;
        this.pre = new int[length][length];
        this.d = edges;

        //对pre初始化
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    public void show() {
        for (int k = 0; k < d.length; k++) {
            for (int i = 0; i < d.length; i++) {
                System.out.print(vertex.get(pre[k][i]) + " ");
            }
            System.out.println();
            for (int i = 0; i < d.length; i++) {
                System.out.print(d[k][i] + " ");
            }
            System.out.println();
            System.out.println();
        }
    }
}

class topologicalSort {
    public int index = 0; //节点的遍历
    public int num;
    public int[] ind;               // 入度数组
    public int[] tops;             // 拓扑排序结果数组，记录每个节点的排序后的序号。
    public int[] temp;
    Queue<Integer> queue;

    public topologicalSort(int length) {

        this.num = length;
        this.ind = new int[num];
        this.tops = new int[num];
        this.temp = new int[num];
        this.queue = new LinkedList<Integer>();
    }
}



