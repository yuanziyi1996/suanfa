package 生产者消费者;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerByWaitNotify {
    private static final int CAPACITY = 5;
    public static void main(String args[]){
        Queue<Integer> queue = new LinkedList<Integer>();

        Thread producer1 = new ProducerConsumerByWaitNotify.Producer("生产者-1", queue, CAPACITY);
        Thread producer2 = new ProducerConsumerByWaitNotify.Producer("生产者-2", queue, CAPACITY);
        Thread consumer1 = new ProducerConsumerByWaitNotify.Consumer("消费者-1", queue, CAPACITY);
        Thread consumer2 = new ProducerConsumerByWaitNotify.Consumer("消费者-2", queue, CAPACITY);
        Thread consumer3 = new ProducerConsumerByWaitNotify.Consumer("消费者-3", queue, CAPACITY);

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }

    public static class Producer extends Thread{
        private Queue<Integer> queue;
        String name;
        int maxSize;
        int i = 0;

        public Producer(String name, Queue<Integer> queue, int maxSize){
            super(name);
            this.name = name;
            this.queue = queue;
            this.maxSize = maxSize;
        }
        @Override
        public void run(){

            while (true){
                synchronized (queue){
                    while (queue.size()==maxSize){
                        System.out .println("Queue is full, Producer[" + name + "] thread waiting for " + "consumer to take something from queue.");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("[" + name + "] Producing value : +" + i);
                    queue.offer(i++);
                    queue.notifyAll();
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    public static class Consumer extends Thread{
        private Queue<Integer> queue;
        String name;
        int maxSize;
        int i = 0;

        public Consumer(String name, Queue<Integer> queue, int maxSize){
            super(name);
            this.name = name;
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run(){

            while (true){
                synchronized (queue){
                    while (queue.isEmpty()){
                        System.out.println("Queue is empty, Consumer[" + name + "] thread is waiting for Producer");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int x = queue.poll();
                    System.out.println("[" + name + "] Consuming value : " + x);
                    queue.notifyAll();
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }

    }
}
