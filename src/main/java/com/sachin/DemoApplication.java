package com.sachin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication {

  public static void main(String[] args) {
    // SpringApplication.run(DemoApplication.class, args);
    // testPrinting();
    System.out.println("minimum -> " + findMinimumDistance());
  }

  private static void testPrinting() {
    int[][] m = new int[2][3];
    m[0][0] = 1;
    m[0][1] = 1;
    m[0][2] = 1;
    m[1][0] = 1;
    m[1][1] = 1;
    m[1][2] = 1;
    System.out.println(m.length + " - " + m[0].length);
  }

  /*
   * 1 source 2 destination 3 blank 0 wall
   */

  private static class Graph {

    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();



  }

  private static int findMinimumDistance() {
    int[][] m = {
        {0, 3, 2}, 
        {3, 3, 0}, 
        {1, 3, 0}};
    Graph g = new Graph();

    int s = 0;
    int d = 0;
    int k = 1;
    int rows = m.length;
    int col = m[0].length;
    List<Integer> adj = null;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < col; j++) {
        if (m[i][j] != 0) {
          adj = g.map.get(k);
          if (adj == null) {
            adj = new ArrayList<Integer>();
            g.map.put(k, adj);
          }

          if (isSafe(i, j + 1, rows, col, m)) {
            adj.add(k + 1);
          }

          if (isSafe(i, j - 1, rows, col, m)) {
            adj.add(k - 1);
          }

          if (isSafe(i + 1, j, rows, col, m)) {
            adj.add(k + col);
          }

          if (isSafe(i - 1, j, rows, col, m)) {
            adj.add(k - col);
          }
        }

        if (m[i][j] == 1) {
          s = k;
        }

        if (m[i][j] == 2) {
          d = k;
        }
        k++;
      }
    }

    return bfs(g, s, d);
  }

  private static int bfs(Graph g, int s, int d) {
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(s);
    int result = 0;
    Set<Integer> visited = new HashSet<Integer>();
    while (!q.isEmpty()) {
      System.out.println();
      int size = q.size();
      for(int index = 0; index < size; index++) {
        Integer item = q.poll();
        System.out.print(item + "->");
        visited.add(item);
        if (item == d) {
          return result;
        }
        for (Integer j : g.map.get(item)) {
          if (!visited.contains(j)) {
            q.add(j);
          }
        }
      }
      result++;
    }
    return result;
  }

  private static boolean isSafe(int i, int j, int rows, int col, int[][] m) {
    if ((i >= rows || i < 0) || (j >= col || j < 0) || m[i][j] == 0) {
      return false;
    }
    return true;
  }


}
