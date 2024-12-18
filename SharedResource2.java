import java.util.Locale;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource2 implements Runnable{

    private int count = 0;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        increment();
        decrement();
    }

    public void increment(){
        lock.lock();
            System.out.printf("Incrementing %d\n",++count);
            lock.unlock();
    }

    public void decrement(){
        lock.lock();
            System.out.printf("Decrementing %d\n", --count);
            lock.unlock();
    }
}
