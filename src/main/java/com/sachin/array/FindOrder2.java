package com.sachin.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class FindOrder2 {

  public static void main(String[] args) {
//    int[][] courses = {{1, 0}, {2, 0}, {4, 0}, {3, 1}, {3, 2}};
     int[][] courses = {{1, 2}, {1, 3}, {1, 4}, {3, 5}, {3, 6}, {4, 6}, {5, 7}};
    Map<Integer, List<Integer>> cMap = new HashMap<>();
    List<Integer> dependencyList = null;
    for (int[] dependency : courses) {
      dependencyList = cMap.get(dependency[0]);
      if (dependencyList == null) {
        dependencyList = new ArrayList<>();
        cMap.put(dependency[0], dependencyList);
      }
      dependencyList.add(dependency[1]);
      dependencyList = cMap.get(dependency[1]);
      if (dependencyList == null) {
        dependencyList = new ArrayList<>();
        cMap.put(dependency[1], dependencyList);
      }
    }

    Map<Integer, List<Integer>> orderMap = new HashMap<Integer, List<Integer>>();
    Map<Integer, Integer> keyOrderMap = new HashMap<Integer, Integer>();
    Set<Integer> visited = new HashSet<Integer>();

    cMap.keySet().forEach(key -> {
      if (!visited.contains(key)) {
        visited.add(key);
        List<Integer> list = cMap.get(key);
        int maxOrder = 0;
        if (list != null && !list.isEmpty()) {
          maxOrder = processOrder(keyOrderMap, list, 0, cMap, visited);
        }
        keyOrderMap.put(key, maxOrder);
      } else {
        System.out.println("I am already visited - " + key);
      }
    });

    keyOrderMap.forEach((key, value) -> System.out.println("Key - " + key + " value - " + value));

  }

  static int processOrder(Map<Integer, Integer> orderMap, List<Integer> list, Integer initOrder,
      Map<Integer, List<Integer>> cMap, Set<Integer> visited) {
    int maxOrder = initOrder;
    if (list != null && list.size() > 0) {
      for (Integer v : list) {
        if (!visited.contains(v)) {
          visited.add(v);
          int currentOrderMax = initOrder;
          currentOrderMax = processOrder(orderMap, cMap.get(v), initOrder + 1, cMap, visited);
          if (maxOrder < currentOrderMax) {
            maxOrder = currentOrderMax;
          }
          orderMap.put(v, currentOrderMax - initOrder);
        } else {
          maxOrder = orderMap.get(v) + 1;
        }
      }
    } else {
      maxOrder--;
    }

    return maxOrder;
  }

}

