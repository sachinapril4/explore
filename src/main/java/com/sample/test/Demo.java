package com.sample.test;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import com.sachin.sorting.BST;
import com.sachin.sorting.HeapSort;
import com.sachin.sorting.MergeSort;
import com.sachin.sorting.SelectionSort;
import com.sample.string.MyLinkedList;
import com.sample.string.MyLinkedList.Node;

public class Demo {

  public static void main(String[] args) {

    //binarySearchTree();
//    mergeSort();


    //selectionSort();
    
//    heapSort();
    
    //Valid Parenthesis
    String s = "()[]{}";
    System.out.println(isValid(s));


    /*
     * Add 2 char arrays char[] a = {'9', '9'}; char[] b = {'9', '9', '9'}; addTwoNumbers(a, b);
     * 
     */
    /**
     * Remove List
     */
    /*
     * Remove Duplicates List<String> list = new ArrayList<String>(Arrays.asList("sachin", "sonal",
     * "aarav", "sachin")); removeDuplicatesFromlist(list);
     */
    // testLinkedList();
    // MyLinkedList<String> myList = new MyLinkedList<>();
    // myList.add("0");
    // myList.add("1");
    // myList.add("2");
    // myList.add("3");
    // myList.add("4");
    // myList.add("5");
    // myList.add("6");
    // myList.add("7");
    // myList.add("8");
    // myList.add("9");

    // Node<String> n1 = new Node("1");
    // Node<String> n2 = new Node("2");
    // Node<String> n3 = new Node("3");
    // Node<String> n4 = new Node("4");
    // Node<String> n5 = new Node("5");
    // Node<String> n6 = new Node("6");
    // Node<String> n7 = new Node("7");
    // Node<String> n8 = new Node("8");
    // Node<String> n9 = new Node("9");
    // myList.head.next = n1;
    // n1.next = n2;
    // n2.next = n3;
    // n3.next = n4;
    // n4.next = n5;
    // n5.next = n6;
    // n6.next = n7;
    // n7.next = n8;
    // n8.next = n9;
    // n9.next = n4;
    // myList.last.setNext(myList.head.next.next.next);
    // findLoopAndRemoveFromList(myList);
    /**
     * Remove List end
     */
  }
  
  public static boolean isValid(String s) {
    Deque<Character> list = new LinkedList<>();
    Character tmp = null;
    for(Character ch : s.toCharArray()) {
        switch(ch) {
            case '(':
            case '[':
            case '{':    
                    list.add(ch);
                break;
            case ')':
                if(list.isEmpty()) return false;
                tmp = list.removeLast();
                if(!tmp.equals('(')) {
                    return false;
                } 
                break;
            case ']':
                if(list.isEmpty()) return false;
                tmp = list.removeLast();
                if(!tmp.equals('[')) {
                    return false;
                }
                break;
            case '}':
                if(list.isEmpty()) return false;
                tmp = list.removeLast();
                if(!tmp.equals('{')) {
                    return false;
                }
                break;
            default:
                return false;
        }
    }
     if(!list.isEmpty()) {
         return false;
     } else {
         return true;
     }
}

  private static void binarySearchTree() {
    Integer[] array = {6, 5, 3, 7, 2, 4, 8, 9, 0, 1};
    BST<Integer> bst = new BST<Integer>();
    Arrays.asList(array).forEach(bst::add);
    bst.printBst();
  }

  private static void mergeSort() {
    Integer[] array = {6, 5, 3, 7, 2, 4, 8, 9, 0, 1};
    Arrays.asList(array).forEach(System.out::print);
    MergeSort.sort(array);
    System.out.println("\n");
    Arrays.asList(array).forEach(System.out::print);
  }
  
  private static void heapSort() {
    Integer[] array = {6, 5, 3, 7, 2, 4, 8, 9, 0, 1};
    Arrays.asList(array).forEach(System.out::print);
    HeapSort.sort(array);
    System.out.println("\n");
    Arrays.asList(array).forEach(System.out::print);
  }

  private static void selectionSort() {
    Integer[] array = {6, 5, 3, 7, 2, 4, 8, 9, 0, 1};
    Arrays.asList(array).forEach(System.out::print);
    SelectionSort.sort(array);
    System.out.println("\n");
    Arrays.asList(array).forEach(System.out::print);
  }

  private static void removeDuplicatesFromlist(List<String> list) {
    Set<String> existing = new HashSet<String>();
    Iterator<String> lstItr = list.iterator();
    while (lstItr.hasNext()) {
      if (!existing.add(lstItr.next())) {
        lstItr.remove();
      }
    }
    list.forEach(System.out::println);
  }

  private static void testLinkedList() {
    MyLinkedList<String> myList = new MyLinkedList<>();
    myList.add("sachin");
    myList.add("sonal");
    myList.add("aarav");
    printList(myList);
    System.out.println("********1*******");
    myList.addFirst("first");
    myList.addLast("last");
    printList(myList);
    System.out.println("********2*******");
    myList.remove("Sonal");
    myList.remove("sachin");
    printList(myList);
    System.out.println("********3*******");
    myList.remove("first");
    myList.remove("sonal");
    myList.remove("aarav");
    printList(myList);
    System.out.println("********4*******");
    myList.remove("last");
    printList(myList);
  }

  private static void addTwoNumbers(char[] a, char[] b) {
    int aLen = a.length - 1;
    int bLen = b.length - 1;
    int length = aLen > bLen ? aLen : bLen;
    int sum = 0;
    int multiplier = 1;

    for (; aLen >= 0 || bLen >= 0; aLen--, bLen--, multiplier *= 10) {
      sum += ((aLen >= 0 ? a[aLen] - '0' : 0) + (bLen >= 0 ? b[bLen] - '0' : 0)) * multiplier;
    }

    System.out.println("Sum of two arrays : " + sum);
  }

  private static void printList(MyLinkedList<String> myList) {
    int i = 11;
    int count = 0;
    for (String value : myList) {
      System.out.println(value);
      count++;
      if (count == i) {
        break;
      }
    }
  }

  private static void findNthFromLast(MyLinkedList<String> list, int n) {
    // list.addLast(ele);
  }

  private static void findLoopAndRemoveFromList(MyLinkedList<String> myList) {
    printList(myList);
    System.out.println("--- After removing ---");
    Node<String> first = myList.head, second = myList.head;
    while (true) {
      if (first == null || second == null || second.getNext() == null) {
        System.out.println("No Loop");
        break;
      }
      first = first.getNext();
      second = second.getNext().getNext();

      if (first == second) {
        removeLoop(first, myList.head);
        myList.forEach(System.out::println);
        break;
      }
    }
  }

  private static void removeLoop(Node<String> loppEle, Node<String> head) {
    Node<String> fromBeg = head;

    Node<String> loopStart = null;
    while (true) {
      fromBeg = fromBeg.getNext();

      if (loopStart != null && fromBeg == loopStart) {
        loppEle.setNext(null);
        break;
      }
      loppEle = loppEle.getNext();
      if (loopStart == null && fromBeg == loppEle) {
        loopStart = loppEle;
      }
    }
  }
}
