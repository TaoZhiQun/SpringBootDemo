package com.example.test.other;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadingCacheExpiryTest {
    public LoadingCache<String,String> loadingCache;
    private ExecutorService executorService = Executors.newFixedThreadPool(5);
    public LoadingCacheExpiryTest(){
        loadingCache = CacheBuilder.newBuilder().expireAfterWrite(5,TimeUnit.SECONDS).build(new CacheLoader<String, String>() {
            private AtomicInteger count = new AtomicInteger(1);
            private AtomicInteger reloadCount = new AtomicInteger(1);
            @Override
            public String load(String key) throws Exception {
                System.out.println("load value "+count.get()+" times");
                for(int i=0;i<10;i++){
                    System.out.println("Load Value "+count.get()+" times");
                    Thread.currentThread().sleep(1000);
                }
                count.incrementAndGet();
                return "Tao";
            }

            @Override
            public ListenableFuture<String> reload(String key, String oldValue) throws Exception {
                System.out.println("Reload for "+reloadCount.get()+" times");
                ListenableFutureTask<String> futureTask = ListenableFutureTask.create(new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        for(int i=0;i<10;i++){
                            System.out.println("Reload Value for"+i+"seconds");
                            Thread.currentThread().sleep(1000);
                        }
                        int count = reloadCount.incrementAndGet();
                        return "Tao"+count;
                    }
                });
                executorService.execute(futureTask);
                return futureTask;
            }
        });
    }

    public static void main(String[] args) {
        LoadingCacheExpiryTest test = new LoadingCacheExpiryTest();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    try {
                        System.out.println("线程1 Before Get Cache");
                        System.out.println("线程1获取值"+test.loadingCache.get("bao"));
                        System.out.println("线程1 After Get Cache");
                        Thread.currentThread().sleep(1000);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程2 Before Get Cache");
                    System.out.println("线程2获取值"+test.loadingCache.get("bao"));
                    System.out.println("线程 After Get Cache");
                    Thread.currentThread().sleep(1000);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        t1.start();
        t2.start();
    }
}
