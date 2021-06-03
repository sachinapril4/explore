package com.sachin.leetCode.list;

public class RemoveNth {

  public static void main(String[] args) {


    ListNode four = new ListNode(5);
    ListNode thi = new ListNode(4, four);
    ListNode sec = new ListNode(3, thi);
    ListNode first = new ListNode(2, sec);
    ListNode head = new ListNode(1, null);
    printList(head);
    System.out.println("****");


    head = removeNthFromEnd(head, 1);
    printList(head);
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode first = null;
    ListNode sec = null;
    while (true) {

      if (n > 0) {
        if (first == null) {
          first = head;
        } else {
          first = first.next;
        }
        n--;
        continue;
      }

      if (first.next == null) {
        if (sec != null) {
          sec.next = sec.next.next;
        } else {
          if (head.next != null) {
            head = head.next;
          } else {
            head = null;
          }
        }
        break;
      }
      first = first.next;
      if (sec == null) {
        sec = head;
      } else {
        sec = sec.next;
      }
    }
    return head;
  }

  private static void printList(ListNode l) {
    while (l != null) {
      System.out.println(l.val);
      l = l.next;
    }
  }

  public static class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
      this.val = val;
    }

    public ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

}
