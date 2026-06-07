// DefaultEventGenerator.java 

package project.generate;

import java.util.Random;

import project.model.EventType;
import project.model.UserEvent;

public class DefaultEventGenerator implements EventGenerator {

    private static final EventType[] EVENT_TYPES = EventType.values();

    private final Random random = new Random();

    private long sequence = 1;

    @Override
    public UserEvent generateEvent() {

        return UserEvent.builder()
                .eventId("E" + sequence++)
                .userId("U" + random.nextInt(1000))
                .type(EVENT_TYPES[random.nextInt(EVENT_TYPES.length)])
                .timestamp(System.currentTimeMillis())
                .build();
    }
}