package com.sachin.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class FindSequenceOfCourses {

  public static void main(String[] args) {
    int[][] courses = {{1, 55}, {2, 55}, {4, 55}, {3, 1}, {3, 2}, {55, 1}};
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

    Map<Integer, List<Integer>> orderedMap = new HashMap<Integer, List<Integer>>();
    Map<Integer, Integer> maxorderMap = new HashMap<Integer, Integer>();

    Set<Integer> visited = new HashSet<>();
    Set<Integer> currentlyVisited = new HashSet<>();

    cMap.forEach((k, v) -> {
      System.out.print(k + " -> ");
      v.forEach(i -> System.out.print(i + ", "));
      System.out.println();
    });
    for (Entry<Integer, List<Integer>> e : cMap.entrySet()) {
      if (!visited.contains(e.getKey())) {
        // print(e.getKey(), cMap, visited);
        collectOrder(e.getKey(), cMap, visited, currentlyVisited, orderedMap, maxorderMap, 0);
      }
    }
    orderedMap.forEach((k, v) -> {
      System.out.print(k + " -> ");
      v.forEach(i -> System.out.print(i + ", "));
      System.out.println();
    });
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

  private static int collectOrder(Integer current, Map<Integer, List<Integer>> cMap,
      Set<Integer> visited, Set<Integer> currentlyVisited, Map<Integer, List<Integer>> orderedMap,
      Map<Integer, Integer> maxorderMap, int order) {
    int maxorder = order;
    if (currentlyVisited.contains(current)) {
      System.out.println("Circular dependency exists" + currentlyVisited);
      return -1;
    }
    currentlyVisited.add(current);
    // if (cMap.get(current) == null) {
    // orderedMap.compute(current, (k, v) -> order, orderedMap.getOrDefault(k, 0)));
    // }


    if (cMap.get(current) != null) {
      for (Integer e : cMap.get(current)) {
        if (!visited.contains(e)) {
          maxorder = Math.max(maxorder,
              collectOrder(e, cMap, visited, currentlyVisited, orderedMap, maxorderMap, order + 1));
        } else {
          maxorder = maxorderMap.get(e);
        }
      }
    }

    visited.add(current);
    currentlyVisited.remove(current);
    maxorderMap.put(current, maxorder);
    List<Integer> list = orderedMap.get(maxorder - order);
    if (list == null) {
      list = new ArrayList<Integer>();
      orderedMap.put(maxorder - order, list);
    }
    list.add(current);

    return maxorder;
  }

}
