package com.sample.string;

import java.util.Iterator;

public class MyLinkedList<T extends Object> implements Iterable<T> {
  public Node<T> head;
  public Node<T> last;

  // Constructors
  public MyLinkedList() {}

  // Add method
  public void add(T ele) {
    Node<T> node = new Node<>();
    node.setValue(ele);
    if (head == null) {
      head = node;
    }
    if (last == null) {
      last = node;
    } else {
      last.setNext(node);
      node.setPre(last);
      last = node;
    }
  } // Add first

  public void addFirst(T ele) {
    Node<T> node = new Node<>();
    node.setValue(ele);
    if (head == null) {
      head = node;
    } else {
      node.setNext(head);
      head.setPre(node);
      head = node;
    }
    if (last == null) {
      last = node;
    }
  }

  // Add last
  public void addLast(T ele) {
    Node<T> node = new Node<T>();
    node.setValue(ele);
    if (head == null) {
      head = node;
    }
    if (last == null) {
      last = node;
    } else {
      last.setNext(node);
      node.setPre(last);
      last = node;
    }
  }

  // Add in middle
  // Delete first
  public void remove(T ele) {
    if (head != null) {
      Node<T> node = head;
      for (; node != null;) {
        if (node.getValue().equals(ele)) {
          if (node.pre != null) {
            node.pre.next = node.next;
          } else {
            head = node.next;
          }
          if (node.next != null) {
            node.next.pre = node.pre;
          } else {
            last = node.pre;
          }
          break;
        } else {
          node = node.next;
        }
      }
    }
  }

  // Delete last
  // Delete from middle
  public static class Node<T> {
    public Node<T> next;
    private Node<T> pre;
    private T value;
    
    public Node() {
    }
    
    public Node(T s) {
      value = s;
    }

    public Node<T> getNext() {
      return next;
    }

    public void setNext(Node<T> next) {
      this.next = next;
    }

    public Node<T> getPre() {
      return pre;
    }

    public void setPre(Node<T> pre) {
      this.pre = pre;
    }

    public T getValue() {
      return value;
    }

    public void setValue(T value) {
      this.value = value;
    }
  }

  @Override
  public Iterator<T> iterator() {
    CustomIterator<T> cus = new CustomIterator<>();
    cus.current = head;
    return cus;
  }

  class CustomIterator<T> implements Iterator<T> {
    private Node<T> current;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public T next() {
      T val = current.value;
      current = current.next;
      return val;
    }
  }
}
