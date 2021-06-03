package com.sachin.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class FindOrder {

  public static void main(String[] args) {
    int[][] courses = {{1, 0}, {2, 0}, {4, 0}, {3, 1}, {3, 2}};
    Map<Integer, List<Integer>> cMap = new HashMap<>();
    List<Integer> dependencyList = null;
    for (int[] dependency : courses) {
      dependencyList = cMap.get(dependency[0]);
      if (dependencyList == null) {
        dependencyList = new ArrayList<>();
        cMap.put(dependency[0], dependencyList);
      }
      dependencyList.add(dependency[1]);
    }

    cMap.forEach((k, v) -> {
      System.out.print(k);
      System.out.print(" - ");
      v.forEach(i -> {
        System.out.print(i + ",");
      });
      System.out.println();
    });
    Set<Integer> visited = new HashSet<>();

    for (Entry<Integer, List<Integer>> e : cMap.entrySet()) {
      if (!visited.contains(e.getKey())) {
        print(e.getKey(), cMap, visited);
      }
    }

  }

  private static void print(Integer current, Map<Integer, List<Integer>> cMap,
      Set<Integer> visited) {
    if (cMap.get(current) == null) {
      System.out.println(current);
      visited.add(current);
    }

    if (!visited.contains(current)) {
      for (Integer e : cMap.get(current)) {
        if (!visited.contains(e)) {
          visited.add(current);
          if (cMap.get(current) != null) {
            for (Integer d : cMap.get(current)) {
              visited.add(d);
              print(d, cMap, visited);
            }
          }
        }
      }
      System.out.println(current);
    }
  }

}

