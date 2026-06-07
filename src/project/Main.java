// Main.java 

package src.project;

import java.util.List;
import java.util.stream.IntStream;

import src.project.generate.DefaultEventGenerator;
import src.project.generate.EventGenerator;
import src.project.model.UserEvent;
import src.project.produce.Producer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // milestone1();
        milestone2();
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
        Producer producer = new Producer(new DefaultEventGenerator(), 10);
        Thread thread = new Thread(producer, "Producer - 1");

        System.out.println("Main thread started producer");
        thread.start();
        System.out.println("Main thread continues...");
    }
}
