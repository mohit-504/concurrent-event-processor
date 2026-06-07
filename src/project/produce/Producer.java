// Producer.java

package project.produce;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.generate.EventGenerator;
import project.model.UserEvent;
import project.queue.EventQueue;

@Getter
@RequiredArgsConstructor
public class Producer implements Runnable{
    private final EventGenerator generator;
    private final int eventCount;
    private final EventQueue queue;
    @Override
    public void run() {
        for(int i=1; i<=eventCount; i++){
            UserEvent event = generator.generateEvent();

            queue.add(event);

            System.out.println(Thread.currentThread().getName()+" added "+event.getEventId());
        
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    } 
}
