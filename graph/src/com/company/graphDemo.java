package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class graphDemo implements graphTest {

    Graph graph = new Graph(5);

    @Override
    public void insertVertex(String vertex) {

        graph.vertexList.add(vertex);
    }

    //  有向图相邻矩阵
    @Override
    public void insertEdge(int v1, int v2, int weight) {

        graph.edges[v1][v2] = weight;
        graph.numOfEdges++;
    }

    @Override
    public int getNumOfEdge() {
        return graph.numOfEdges;
    }

    @Override
    public String getValueOfIndex(int i) {
        return graph.vertexList.get(i);
    }

    @Override
    public int getNumOfWeight(int v1, int v2) {
        return graph.edges[v1][v2];
    }

    @Override
    public void putGraph() {
        System.out.print(" ");
        for (int i = 0; i < graph.vertexList.size(); i++) {
            System.out.print(getValueOfIndex(i));
        }
        System.out.println();
        for (int i = 0; i < graph.vertexList.size(); i++) {
            System.out.print(getValueOfIndex(i));
            for (int j = 0; j < graph.vertexList.size(); j++) {

                System.out.print(graph.edges[i][j]);

            }
            System.out.println();
        }
    }

    @Override
    public int getFirstNeighbor(int index) {
        for (int col = 0; col < graph.vertexList.size(); col++) {
            if (graph.edges[index][col] < 65535) {
                return col;
            }
        }
        return -1;
    }

    @Override
    public int getNextNeighbor(int row, int col) {
        for (int i = col + 1; i < graph.vertexList.size(); i++) {
            if (graph.edges[row][i] != 65535) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void DFS() {

        boolean[] visited = new boolean[graph.vertexList.size()];

        //初始化标记
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        //访问当前节点
        for (int j = 0; j < graph.vertexList.size(); j++) {
            if (!visited[j]) {
                DFS(j, visited);
            }
        }
        System.out.println();
    }


    private void DFS(int i, boolean visited[]) {

        visited[i] = true;
        System.out.print(getValueOfIndex(i) + "->");

        int col = getFirstNeighbor(i);
        while (col != -1) {
            if (!visited[col]) {
                DFS(col, visited);
            }
            //当前值为叶节点时
            col = getNextNeighbor(i, col);
        }
    }

    @Override
    public void BFS() {

        boolean[] visited = new boolean[graph.vertexList.size()];

        //初始化标记
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        //访问当前节点
        for (int j = 0; j < graph.vertexList.size(); j++) {
            if (!visited[j]) {
                BFS(j, visited);
            }
        }
        System.out.println();
    }


    private void BFS(int col, boolean visited[]) {

        Queue queue = new LinkedList();
        System.out.print(getValueOfIndex(col) + "->");
        visited[col] = true;
        //当前结点入队列
        queue.add(col);
        while (!queue.isEmpty()) {
            //出队列
            int current = ((Integer) queue.remove()).intValue();
            int next = getFirstNeighbor(current);
            //叶子节点一次输出
            while (next != -1) {
                if (!visited[next]) {
                    System.out.print(getValueOfIndex(next) + "->");
                    visited[next] = true;
                    queue.add(next);
                }
                //叶节点时同
                next = getNextNeighbor(current, next);
            }
        }

    }

    //dijkstra
    public void djkMatrix(){
        int INFINITY = 65535;
        for(int i = 0; i < graph.vertexList.size(); i++)    //将所有边初始化为无穷大
            for(int j = 0; j < graph.vertexList.size(); j++)
                graph.edges[i][j] = INFINITY;
    }
    public void dijkstra(int index) {

        VisitedVertex v = new VisitedVertex(graph.vertexList.size(), index);

        update(index, v);

        for(int j = 1; j < graph.vertexList.size(); j++){
            index = v.updateArr();
            update(index, v);
        }
        show(v);
    }

    private void update(int index, VisitedVertex v) {
        //len  顶点到index的距离
        int len = 0;
        for (int j = 0; j < graph.edges[index].length; j++) {
            len = v.getDis(index) + graph.edges[index][j];

            //更新的判断条件
            if (!v.vis(j) && len < v.getDis(j)) {
                v.updatePre(j, index);
                v.updateDistance(j, len);
            }
        }
    }
    //输出
    private void show(VisitedVertex v){
        System.out.println("节点是否访问过");
        for(int i : v.visited){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("前序节点的值");
        for(int i : v.pre_visited){
            System.out.print(getValueOfIndex(i) + " ");
        }
        System.out.println();
        System.out.println("距离");
        for(int i : v.d){
            System.out.print(i + " ");
        }
    }


    public void floyd(){
        FloydGraph f = new FloydGraph(graph.vertexList.size(),graph.edges,graph.vertexList);

        int distance = 0;
        //k为起始节点
        for(int k = 0; k < f.d.length; k++){
            //i为终止节点
            for(int i = 0; i < f.d.length; i++){
                //j为中间节点
                for(int j = 0; j < f.d.length; j++){
                    //测试
                    distance = f.d[k][j] + f.d[j][i];
                    //判断
                    if(distance < f.d[k][i]){
                        //update
                        f.d[k][i] = distance;
                        f.pre[k][i] = f.pre[j][i];
                    }
                }
            }
        }

        f.show();
    }

    //prim 不断找到权值最小且不产生闭环的N-1条边,从v起始

    public void prim(int v) {
        int visited[] = new int[graph.vertexList.size()];

        int len = 65535;
        visited[v] = 1;
        int s1 = -1;
        int s2 = -1;
        //访问遍历，有N-1条边
        for (int k = 0; k < graph.vertexList.size() - 1; k++) {

            //在后续的循环中，实际逻辑上是有多个顶点在寻找最小边
            for (int i = 0; i < graph.vertexList.size(); i++) {
                for (int j = 0; j < graph.vertexList.size(); j++) {
                    //避免构成连通图且边存在
                    //找到围绕v的最小的一条边
                    if (visited[i] == 1 && visited[j] == 0 && graph.edges[i][j] < len) {
                        len = graph.edges[i][j];
                        s1 = i;
                        s2 = j;
                    }
                }
            }
            System.out.println("<" + graph.vertexList.get(s1) + graph.vertexList.get(s2) + "> 权值" + len);
            visited[s2] = 1;
            //重置len
            len = 65535;
        }
    }


    public void topologicalSort() {
       topologicalSort t = new topologicalSort(graph.vertexList.size());
        // 统计每个顶点的入度数
        for (int i = 0; i < t.num; i++) {
            for (int j = 0; j < t.num; j++) {
                if (graph.edges[j][i] < 65535) {
                    t.ind[i]++;
                }
            }
        }
        //测试入度
        //System.out.println(graph.vertexList);
        //System.out.println(Arrays.toString(t.ind));

          // 将所有入度为0的顶点入队列
        for(int i = 0; i < t.num; i ++)
            if(t.ind[i] == 0)
                t.queue.add(i);                 // 入队列

        while (!t.queue.isEmpty()) {
            int len = 0;//临时数组中的长度
            int j = t.queue.poll().intValue();    // 出队列

            t.tops[t.index++] = j;  // 将该顶点添加到tops中，tops是排序结果
            // 矩阵中的有值的列 为该顶点为起点的出边队列
            for(int k = 0;k < t.num; k++){
                if(graph.edges[j][k] < 65535){
                    t.temp[len++] = k;
                }
            }
            // 将与index关联的节点的入度减1；
            // 若减1之后，该节点的入度为0；则将该节点添加到队列中。
            for(int l = 0; l <= len; l++) {
                t.ind[t.temp[l]]--;
                // 若节点的入度为0，则入队列
                if (t.ind[t.temp[l]] == 0)
                    t.queue.add(t.temp[l]);
            }

        }

        if(t.index != t.num) {
            System.out.printf("Graph has a cycle\n");
        }

        // 打印拓扑排序结果
        System.out.printf("topologicalSort: ");
        for(int i = 0; i < t.num; i++)
            System.out.printf(graph.vertexList.get(t.tops[i]));
        System.out.printf("\n");
    }


}


