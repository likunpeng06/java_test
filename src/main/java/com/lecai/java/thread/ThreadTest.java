package com.lecai.java.thread;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by qatang on 14-4-9.
 */
public class ThreadTest {
    private static int data = 0;
    final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    public static void main(String[] args) {
//        System.out.println(Thread.currentThread().getName());
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                while(true) {
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName());
//                }
//            }
//        };
//        thread.start();
//        System.out.println("main end");
//
////        Thread thread2 = new Thread(new Runnable() {
////            @Override
////            public void run() {
////                while(true) {
////                    try {
////                        Thread.sleep(1000);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                    System.out.println(Thread.currentThread().getName());
////                }
////            }
////        });
//////        thread2.start();
////
////        //定时器
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("Bomb!");
//            }
//        }, 5000);
//
//        while (true) {
//            System.out.println(new Date().getSeconds());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        //quartz
//        <dependency>
//        <groupId>org.quartz-scheduler</groupId>
//        <artifactId>quartz</artifactId>
//        <version>1.8.6</version>
//        </dependency>

        //synchronized和lock,unlock方法最好放在finally里，因为有可能代码出错，而不执行unlock，那就会永远锁住了
//        new ThreadTest().init();

        //ThreadLocal
//        final ThreadTest threadTest = new ThreadTest();
//
//        for (int i = 0; i < 5; i ++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    data = new Random().nextInt();
//                    threadTest.threadLocal.set(data);
//                    System.out.println(Thread.currentThread().getName() + " : " + threadTest.threadLocal.get());
//
//                    A a = threadTest.new A();
//                    System.out.println(Thread.currentThread().getName() + " get data : " + a.get());
//                }
//            }).start();
//        }

        //卖票


//        原子性
//        不能被线程调度机制中断的操作；--对原子性变量的赋值和返回操作通常都是原子性的
//        原子性可以用于除了long和double之外的所有基本类型上的简单操作（当做不可分的原子），但是JVM将64位的  （long 和double变量）读取和写入当成是两个分离的32位      操作来执行。
//        原子是世界上的最小单位，具有不可分割性。简单操作就是赋值或者return。比如”a = 1;“和 “return a;”这样的操作都具有原子性。比如 a=0；（a非long和double类型） 这个操作是不可分割的，那么我们说这个操作时原子操作。再比如：a++； 这个操作实际是a = a + 1；是可分割的，所以他不是一个原子操作。非原子操作都会存在线程安全问题，需要我们使用同步技术（sychronized）来让它变成一个原子操作。一个操作是原子操作，那么我们称它具有原子性。java的concurrent包下提供了一些原子类，我们可以通过阅读API来了解这些原子类的用法。比如：AtomicInteger、AtomicLong、AtomicReference等

//        可见性
//        可见性，是指线程之间的可见性，一个线程修改的状态对另一个线程是可见的。也就是一个线程修改的结果。另一个线程马上就能看到。比如：用volatile修饰的变量，就会具有可见性。volatile修饰的变量不允许线程内部缓存和重排序，即直接修改内存。所以对其他线程是可见的。但是这里需要注意一个问题，volatile只能让被他修饰内容具有可见性，但不能保证它具有原子性。比如 volatile int a = 0；之后有一个操作 a++；这个变量a具有可见性，但是a++ 依然是一个非原子操作，也就这这个操作同样存在线程安全问题。

        //volatile
//        用在多线程，同步变量。 线程为了提高效率，将某成员变量(如A)拷贝了一份（如B），线程中对A的访问其实访问的是B。只在某些动作时才进行A和B的同步。因此存在A和B不一致的情况。volatile就是用来避免这种情况的。volatile告诉jvm， 它所修饰的变量不保留拷贝，直接访问主内存中的（也就是上面说的A)
        //如果给一个变量加上volatile修饰符，就相当于：每一个线程中一旦这个值发生了变化就马上刷新回主存，使得各个线程取出的值相同。编译器不要对这个变量的读、写操作做优化。
//        与锁相比，Volatile 变量是一种非常简单但同时又非常脆弱的同步机制，它在某些情况下将提供优于锁的性能和伸缩性。如果严格遵循 volatile 的使用条件 —— 即变量真正独立于其他变量和自己以前的值 —— 在某些情况下可以使用 volatile 代替 synchronized 来简化代码。然而，使用 volatile 的代码往往比使用锁的代码更加容易出错。本文介绍的模式涵盖了可以使用 volatile 代替 synchronized 的最常见的一些用例。遵循这些模式（注意使用时不要超过各自的限制）可以帮助您安全地实现大多数用例，使用 volatile 变量获得更佳性能。
        //当你定义long或者double的时候，如果使用volatile关键字，就会获得原子性（JDK 1.5之前不支持）
        //volatile 会拒绝编译器对其修饰的变量进行优化。也就不会存在重排序的问题。volatile只会影响可见性，不会影响原子性。
        //举例：共享一个boolean的变量，先不用volatile，再使用volatile，两个线程设置sleep

        //Executor
        ExecutorService executorService = Executors.newCachedThreadPool();

//        Future<String> future = executorService.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                Thread.sleep(5000);
//                return "aaaa";
//            }
//        });
//
//        System.out.println("future get");
//        try {
//            System.out.println(future.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        System.out.println("future get end");

//        CompletionService的实现是维护一个保存Future对象的BlockingQueue。只有当这个Future对象状态是结束的时候，才会加入到这个Queue中，take()方法其实就是Producer-Consumer中的Consumer。它会从Queue中取出Future对象，如果Queue是空的，就会阻塞在那里，直到有完成的Future对象加入到Queue中。
//        CompletionService采取的是BlockingQueue<Future<V>>无界队列来管理Future。则有一个线程执行完毕把返回结果放到BlockingQueue<Future<V>>里面。就可以通过completionServcie.take().get()取出结果。
//        方法区别：
//
//        take 方获取并移除表示下一个已完成任务的 Future，如果目前不存在这样的任务，则等待。<如果需要用到返回值建议用take>
//                poll 获取并移除表示下一个已完成任务的 Future，如果不存在这样的任务，则返回null。
        CompletionService<String> completionService = new ExecutorCompletionService<String>(executorService);
        for (int i = 0; i < 5; i ++) {
            final int seq = i;
            completionService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    return String.valueOf(seq);
                }
            });
        }

        for (int i = 0; i < 5; i ++) {
            try {
                System.out.println(completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        //ReentrantReadWriteLock，实现线程互斥。 读写锁，多线程读操作不用上锁，写操作上锁，jdk文档里有一个CachedData的例子
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        //Condition，实现线程通信。wait notify ,jdk文档例子阻塞队列，解释比wait notify高级之处
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        try {
            condition.await(); //wait，千万别写wait()，那个是Object的
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        condition.signal();//notify
    }

    class A {
        public int get() {
            return threadLocal.get();
        }
    }

    public synchronized void init() {
        final Outer outer = new Outer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outer.output("aaaaaaaa");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outer.output("bbbbbbbbbbb");
                }
            }
        }).start();
    }

    class Outer {
        public synchronized void output(String name) {
            int len = name.length();
//            synchronized (name) {
                for (int i = 0; i < len; i ++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
        }
    }
}
