package com.sachin.leetCode.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class UniquePaths {

  public static void main(String[] args) {
    System.out.println(uniquePaths(6, 3));
    // System.out.println(calculatePathItr);

  }

  public static int uniquePaths(int m, int n) {
    Map<String, Integer> paths = new HashMap<>();
    int rec = calculatePath(m - 1, n - 1, paths);
    System.out.println("REC -> " + rec);
    paths = new HashMap<>();
    System.out.println("ITR ->" + calculatePathItr(m, n, paths));
    return rec;
  }

  private static int calculatePath(int m, int n, Map<String, Integer> paths) {
    if (paths.get(m + ":" + n) != null) {
      return paths.get(m + ":" + n);
    } else if (m == 0 || n == 0) {
      return 1;
    } else {
      int path = calculatePath(m - 1, n, paths) + calculatePath(m, n - 1, paths);
      paths.put(m + ":" + n, path);
      return path;
    }
  }

  private static class Graph {
    int x;
    int y;

    Graph(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private static int calculatePathItr(int m, int n, Map<String, Integer> paths) {
    for (int u = 0; u < m; u++) {
      paths.put(u + ":" + 0, 1);
    }
    for (int u = 0; u < n; u++) {
      paths.put(0 + ":" + u, 1);
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        paths.put(i + ":" + j, paths.get(i - 1 + ":" + j) + paths.get(i + ":" + (j - 1)));
      }
    }
    
    int[][] dis = new int[m][n];
    System.out.println();
    for (int u = 0; u < m; u++) {
     dis[u][0]= 1;
    }
    for (int u = 0; u < n; u++) {
      dis[0][u]= 1;
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dis[i][j] = dis[i-1][j] + dis[i][j -1];
      }
    }
    System.out.println("array ->" + dis[m - 1][n - 1]);
    System.out.println("String -> " + paths.get(m - 1 + ":" + (n - 1)));

//    System.out.println("Tester -> " + paths.get(m - 1 + ":" + (n - 1)));
    // Queue<Graph> q = new LinkedList<>();
    // q.add(new Graph(m - 1, n - 1));
    // int result = 0;
    // while (!q.isEmpty()) {
    // Graph g = q.poll();
    // if (g.x == 0 || g.y == 0) {
    // // result++;
    // } else {
    // if (paths.putIfAbsent(g.x - 1 + ":" + g.y, 1) == null) {
    // q.add(new Graph(g.x - 1, g.y));
    // result++;
    // }
    // if (paths.putIfAbsent(g.x + ":" + (g.y - 1), 1) == null) {
    // q.add(new Graph(g.x, g.y - 1));
    // result++;
    // }
    // // result += 2;
    // }
    // }
    return dis[m - 1][n - 1];
  }


}
