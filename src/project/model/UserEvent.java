// UserEvent.java 

package src.project.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserEvent {
    final String eventId;
    final String userId;
    final EventType type;
    final long timestamp;
}
