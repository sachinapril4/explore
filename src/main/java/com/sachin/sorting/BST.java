package com.sachin.sorting;

public class BST<T extends Comparable<T>> {

  private Node<T> head;

  public void add(T value) {
    Node<T> n = new Node<>();
    n.setValue(value);
    if (head == null) {
      head = n;
      return;
    } else {
      findPositionAndInsert(head, n);
    }

    // printBst(head);
  }

  public void printBst() {
    printBst(this.head);
  }

  private void printBst(Node<T> head) {
    if (head.getLeft() != null) {
      printBst(head.getLeft());
    }
    System.out.println(head.getValue());
    if (head.getRight() != null) {
      printBst(head.getRight());
    }

  }

  private void findPositionAndInsert(Node<T> head, Node<T> n) {
    if (head.getValue().compareTo(n.getValue()) <= 0) {
      if (head.getRight() == null) {
        head.setRight(n);
        return;
      } else {
        findPositionAndInsert(head.getRight(), n);
      }
    } else if (head.getLeft() == null) {
      head.setLeft(n);
      return;
    } else {
      findPositionAndInsert(head.getLeft(), n);
    }
  }

  private static class Node<T> {

    private T value;
    private Node<T> left;
    private Node<T> right;

    public T getValue() {
      return value;
    }

    public void setValue(T value) {
      this.value = value;
    }

    public Node<T> getLeft() {
      return left;
    }

    public void setLeft(Node<T> left) {
      this.left = left;
    }

    public Node<T> getRight() {
      return right;
    }

    public void setRight(Node<T> right) {
      this.right = right;
    }

  }

}
