package com.sachin.threads;

public class MyThreadtest {

  private MyMonitor myMonitorObject = new MyMonitor();
  private boolean wasSignalled = false;

  public static void main(String[] args) throws InterruptedException {
    MyThreadtest m1 = new MyThreadtest();
    Thread t1 = new Thread(() -> m1.doWait());
    Thread t2 = new Thread(() -> m1.doWait());
    Thread t3 = new Thread(() -> m1.doWait());
    Thread t4 = new Thread(() -> m1.doNotify());
    t1.start();
    t2.start();
    t3.start();
    Thread.sleep(5000);
    t4.start();
    Thread.sleep(5000);
    System.out.println("I am exiting");
  }


  public void doWait() {
    synchronized (myMonitorObject) {
      while (!wasSignalled) {
        try {
          System.out.println("I am waiting - " + Thread.currentThread().getName());
          myMonitorObject.wait();
        } catch (InterruptedException e) {
        }
      }

      System.out.println("I am notified by - " + Thread.currentThread().getName());
      // clear signal and continue running.
      wasSignalled = false;
    }

  }

  public void doNotify() {
    synchronized (myMonitorObject) {
      wasSignalled = true;
      myMonitorObject.notify();
    }
  }

}


class MyMonitor {



}
