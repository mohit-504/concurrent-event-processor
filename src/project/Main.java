// Main.java 

package project;

import java.util.List;
import java.util.stream.IntStream;

import project.counter.EventCounter;
import project.counter.DefaultEventCounter;
import project.generate.DefaultEventGenerator;
import project.generate.EventGenerator;
import project.model.UserEvent;
import project.produce.DefaultProducer;
import project.produce.Producer;
import project.queue.DefaultEventQueue;
import project.queue.EventQueue;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        // milestone1();
        // milestone2();
        // milestone3();
        milestone4();
    }

    public static void milestone1(){
        EventGenerator generator = new DefaultEventGenerator();
        List<UserEvent> events = IntStream.rangeClosed(1, 100)
                                        .mapToObj(i -> generator.generateEvent())
                                        .toList();
        System.out.println("First 10 events: "+events.subList(0, 10));
        System.out.println("No of events: "+events.size());
    }

    public static void milestone2() throws InterruptedException{
        EventQueue queue = new DefaultEventQueue();
        Producer producer = new DefaultProducer(new DefaultEventGenerator(), 10, queue, new DefaultEventCounter());
        Thread thread = new Thread(producer, "Producer - 1");

        System.out.println("Main thread started producer");
        thread.start();
        System.out.println("Main thread continues...");
    }

    public static void milestone3() throws InterruptedException{
        EventQueue queue = new DefaultEventQueue();
        Producer producer = new DefaultProducer(new DefaultEventGenerator(), 10, queue, new DefaultEventCounter());

        Thread thread = new Thread(producer, "Producer - 1");

        System.out.println("Main thread started producer");
        thread.start();
        System.out.println("Main thread continues...");

        thread.join();

        System.out.println("Queue Size = "+ queue.size());
    }

    public static void milestone4() throws InterruptedException{
        EventQueue queue = new DefaultEventQueue();
        EventCounter counter = new DefaultEventCounter();

        int producerCount = 10;
        int eventsPerProducer = 10_000;

        Thread[] threads = new Thread[producerCount];

        for(int i=0;i<producerCount;i++){
            Producer producer = new DefaultProducer(new DefaultEventGenerator(), eventsPerProducer, queue, counter);

            threads[i] = new Thread(producer, "Producer - "+(i+1));
            threads[i].start();
        }

        for(Thread thread : threads){
            thread.join();
        }

        System.out.println("Expected Count = "+ (producerCount * eventsPerProducer));

        System.out.println("Actual Count   = "+ counter.getCount());

        System.out.println("Queue Size     = "+ queue.size());
    }
}
