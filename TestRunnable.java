import java.util.concurrent.Callable;

public class TestRunnable implements Runnable {

    private int count = 0;


    @Override
    public void run() {
        System.out.println( "\t"+(++count));
    }
}
