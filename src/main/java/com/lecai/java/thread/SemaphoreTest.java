package com.lecai.java.thread;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;

/**
 * Created by qatang on 14-4-10.
 */
public class SemaphoreTest {
    private static final ConcurrentMap<String, Semaphore> SEARCH_SEMAPHORE_MAP = new ConcurrentHashMap<String, Semaphore>();
    private static final ConcurrentMap<String, String> DATA_CACHED_MAP = new ConcurrentHashMap<String, String>();

    public static void main(String[] args) {
        final SemaphoreTest semaphoreTest = new SemaphoreTest();

        int i = 2000;
        while(i > 0) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int a = new Random().nextInt(10000) % 1000;
                    String key = "key" + a;
                    System.out.println(key);
                    semaphoreTest.execute(key);
                }
            }).start();
            i --;
        }
        System.out.println("end");

//        for (int j = 0;j < 10; j ++) {
////            try {
////                Thread.sleep(100);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//            semaphoreTest.execute("key_" + Thread.currentThread().getName());
//        }

    }

    private Semaphore getSemaphore(String key) {
        if (SEARCH_SEMAPHORE_MAP.size() > 1000) {
            SEARCH_SEMAPHORE_MAP.clear();
        }
        if (!SEARCH_SEMAPHORE_MAP.containsKey(key)) {
            SEARCH_SEMAPHORE_MAP.putIfAbsent(key, new Semaphore(1));
        }
        return SEARCH_SEMAPHORE_MAP.get(key);
    }

    public void execute(String key) {
        String value = DATA_CACHED_MAP.get(key);
        if (value == null) {
            Semaphore semaphore = this.getSemaphore(key);
            try {
                System.out.println(Thread.currentThread().getName() + " request semaphore : " + key);
                semaphore.acquire();

                value = DATA_CACHED_MAP.get(key);
                if (value != null) {
                    System.out.println("enter acquire semaphore but cached map has the value:" + key);
                    return;
                }

                Thread.sleep(5000);
                DATA_CACHED_MAP.put(key, key);
                System.out.println("acquire semaphore : " + key);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }
}
