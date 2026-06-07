// DefaultEventQueue.java 

package project.queue;

import java.util.LinkedList;
import java.util.Queue;

import project.model.UserEvent;

public class DefaultEventQueue implements EventQueue {
    private final Queue<UserEvent> queue = new LinkedList<>();
    @Override
    public synchronized void add(UserEvent event) {
        queue.add(event);
    }

    @Override
    public synchronized UserEvent poll() {
        return queue.poll();
    }

    @Override
    public synchronized int size() {
        return queue.size();
    }
    
}
