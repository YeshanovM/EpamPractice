package task3;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Runner {

    private static final int VALUES_PER_THREAD = 100_000;
    private static final int THREADS_COUNT = 5;
    private static final int ATTEMPTS_COUNT = 100;

    private Map<Integer, String> map;
    private ConcurrentMap<Integer, String> concurrentMap;
    private boolean isMapAvailable;

    public Runner() {
    }

    public void run() throws IOException {
        long totalHashMapTime = 0;
        long totalConcurrentHashMapTime = 0;
        File file = new File("result.txt");
        if(file.exists())
            file.delete();
        file.createNewFile();
        FileWriter fw = new FileWriter(file);
        for(int i = 0; i < ATTEMPTS_COUNT; i++) {
            long startTime = System.currentTimeMillis();
            operateHashMap();
            long hashMapTime = System.currentTimeMillis() - startTime;
            totalHashMapTime += hashMapTime;
            startTime = System.currentTimeMillis();
            operateConcurrentHashMap();
            long concurrentHashMapTime = System.currentTimeMillis() - startTime;
            totalConcurrentHashMapTime += concurrentHashMapTime;
            fw.write("HashMap: " + hashMapTime + " ms;" +
                    "\tConcurrentHashMap: " + concurrentHashMapTime + " ms;\n"
            );
        }
        fw.write("\n--------------------------------------------\n\n");
        fw.write("Average HashMap time: " +
                totalHashMapTime / (double)ATTEMPTS_COUNT + " ms\n");
        fw.write("Average ConcurrentHashMap time: " +
                totalConcurrentHashMapTime / (double)ATTEMPTS_COUNT + " ms\n");
        fw.close();
        System.out.println("Finished");
    }

    private void operateHashMap() {
        map = new HashMap<>();
        isMapAvailable = true;
        Thread[][] threads = new Thread[VALUES_PER_THREAD][2];
        for(int i = 0; i < THREADS_COUNT; i++) {
            threads[i][0] = new Thread(() -> {
               for(int j = 0; j < VALUES_PER_THREAD; j++) {
                   putInMap(j, Thread.currentThread().getName());
               }
            });
            threads[i][1] = new Thread(() -> {
                for(int j = 0; j < VALUES_PER_THREAD; j++) {
                    getFromMap(j);
                }
            });
            threads[i][0].start();
            threads[i][1].start();
        }
        for(int i = 0; i < THREADS_COUNT; i++) {
            try {
                threads[i][0].join();
                threads[i][1].join();
            }
            catch (InterruptedException e ) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void putInMap(int key, String value) {
        if(isMapAvailable) {
            isMapAvailable = false;
            map.put(key, value);
            isMapAvailable = true;
            notify();
        }
        else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized String getFromMap(int key) {
        if(isMapAvailable) {
            isMapAvailable = false;
            String value = map.get(key);
            isMapAvailable = true;
            notify();
            return value;
        }
        else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void operateConcurrentHashMap() {
        concurrentMap = new ConcurrentHashMap<>();
        Thread[][] threads = new Thread[VALUES_PER_THREAD][2];
        for(int i = 0; i < THREADS_COUNT; i++) {
            threads[i][0] = new Thread(() -> {
                for(int j = 0; j < VALUES_PER_THREAD; j++) {
                    concurrentMap.put(j, Thread.currentThread().getName());
                }
            });
            threads[i][1] = new Thread(() -> {
                for(int j = 0; j < VALUES_PER_THREAD; j++) {
                    concurrentMap.get(j);
                }
            });
            threads[i][0].start();
            threads[i][1].start();
        }
        for(int i = 0; i < THREADS_COUNT; i++) {
            try {
                threads[i][0].join();
                threads[i][1].join();
            }
            catch (InterruptedException e ) {
                e.printStackTrace();
            }
        }
    }
}
