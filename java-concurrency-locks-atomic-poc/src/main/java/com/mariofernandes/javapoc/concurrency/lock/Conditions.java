package com.mariofernandes.javapoc.concurrency.lock;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Conditions {

    private ReentrantLock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();
    private Queue<String> buffer = new LinkedList<>();
    private final int CAPACITY = 5;

    public Conditions() {}

    private void produce(String data) throws InterruptedException {
        lock.lock();
        try {
            while(buffer.size() == CAPACITY) {
                System.out.println("Buffer is full, producer is waiting...");
                notFull.await();
            }
            buffer.add(data);
            System.out.println("Produced: " + data + ", Buffer size: " + buffer.size());
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    private String consume() throws InterruptedException {
        lock.lock();
        try {
            while(buffer.isEmpty()) {
                System.out.println("Buffer is empty, consumer is waiting...");
                notEmpty.await();
            }
            String data = buffer.poll();
            System.out.println("Consumed: " + data + ", Buffer size: " + buffer.size());
            notFull.signal();

            return data;
        } finally {
            lock.unlock();
        }
    }

    public List<String> basicPublishSubscribe() throws InterruptedException{
        List<String> consumedData = new LinkedList<>();
        var producer = Thread.ofVirtual().start(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    produce("Data " + i);
                }
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted: " + e.getMessage());
                throw new RuntimeException(e);
            }
        });

        var consumer = Thread.ofVirtual().start(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    consumedData.add(consume());
                }
            } catch (InterruptedException e) {
                System.out.println("Consumer interrupted: " + e.getMessage());
                throw new RuntimeException(e);
            }
        });

        producer.join();
        consumer.join();

        return consumedData;
    }

    public static void run() {
        Conditions conditions = new Conditions();
        System.out.println("=== Conditions ===");
        try {
            var result = conditions.basicPublishSubscribe();
            System.out.println("Consumed data: " + result);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
