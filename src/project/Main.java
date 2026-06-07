// Main.java 

package project;

import java.util.List;
import java.util.stream.IntStream;

import project.generate.DefaultEventGenerator;
import project.generate.EventGenerator;
import project.model.UserEvent;
import project.produce.Producer;
import project.queue.DefaultEventQueue;
import project.queue.EventQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // milestone1();
        // milestone2();
        milestone3();
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
        Producer producer = new Producer(new DefaultEventGenerator(), 10, queue);
        Thread thread = new Thread(producer, "Producer - 1");

        System.out.println("Main thread started producer");
        thread.start();
        System.out.println("Main thread continues...");
    }

    public static void milestone3() throws InterruptedException{
        EventQueue queue = new DefaultEventQueue();
        Producer producer = new Producer(new DefaultEventGenerator(), 10, queue);

        Thread thread = new Thread(producer, "Producer - 1");

        System.out.println("Main thread started producer");
        thread.start();
        System.out.println("Main thread continues...");

        thread.join();

        System.out.println("Queue Size = "+ queue.size());
    }
}
