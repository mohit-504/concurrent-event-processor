// Producer.java

package src.project.produce;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import src.project.generate.EventGenerator;
import src.project.model.UserEvent;

@Getter
@RequiredArgsConstructor
public class Producer implements Runnable{
    private final EventGenerator generator;
    private final int eventCount;
    @Override
    public void run() {
        for(int i=1; i<=eventCount; i++){
            UserEvent event = generator.generateEvent();

            System.out.println(Thread.currentThread().getName()+" generated "+event.getEventId());
        
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    } 
}
