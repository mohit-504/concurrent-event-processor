// EventQueue.java 

package project.queue;

import project.model.UserEvent;

public interface EventQueue {
    public void add(UserEvent event);
    public UserEvent poll();
    public int size();
}
