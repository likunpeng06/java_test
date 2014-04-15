package com.lecai.java.thread;

/**
 * Created by qatang on 14-4-8.
 */
public class ThreadTest3 extends Thread {
    private int threadNo;

    public ThreadTest3(int threadNo) {
        this.threadNo = threadNo;
    }

    public static void main(String[] args) throws Exception {
         for (int i = 1; i < 10; i++) {
             new ThreadTest3(i).start();
             Thread.sleep(1);
         }

     }

    public synchronized static void doRun(int threadNo) {
        for (int i = 1; i < 100; i++) {
            System.out.println("No." + threadNo + ":" + i);
        }
    }

     @Override
    public void run() {
         doRun(threadNo);
    }
}
