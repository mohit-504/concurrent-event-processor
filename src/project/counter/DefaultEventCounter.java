// DefaultEventCounter.java 
 

package project.counter;

public class DefaultEventCounter implements EventCounter {

    private int count = 0;

    @Override
    public synchronized void increment() {
        this.count++;
    }

    @Override
    public int getCount() {
        return this.count;
    }
    
}
