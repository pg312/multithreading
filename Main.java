import javax.sound.midi.SysexMessage;
import java.util.concurrent.*;

public class Main {

    public static void main(String [] args) throws Exception {
        TestIncrement testIncrement = new TestIncrement("Thread 1");
        TestIncrement testIncrement2 = new TestIncrement("Thread 2");
        TestIncrement testIncrement3 = new TestIncrement("Thread 3");

        testIncrement.start();
        testIncrement2.start();
        testIncrement3.start();

        TestRunnable runnable = new TestRunnable();

        Thread testRunnable = new Thread(runnable);
        Thread testRunnable2 = new Thread(runnable);
        Thread testRunnable3 = new Thread(runnable);

        System.out.println(testRunnable.getName());
        testRunnable.start();
        System.out.println(testRunnable2.getName());
        testRunnable2.start();
        System.out.println(testRunnable3.getName());
        testRunnable3.start();


        TestCallable testCallable = new TestCallable();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> task1 = executorService.submit(testCallable);
        Future<Integer> task2 = executorService.submit(testCallable);


        System.out.println(task1.get());
        System.out.println(task2.get());

        executorService.shutdown();

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> 2);
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> 2);
        CompletableFuture<Integer> completableFuture3 = CompletableFuture.supplyAsync(() -> 2);

        CompletableFuture<Void> allOf = CompletableFuture.allOf(completableFuture, completableFuture2, completableFuture3);
        allOf.thenRun(()-> {System.out.println(completableFuture.join() + completableFuture2.join() + completableFuture3.join());});
    }
}
