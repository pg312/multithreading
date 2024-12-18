public class SharedResource implements Runnable{

    private int count = 0;

   @Override
    public void run(){
        increment();
        decrement();
    }
    public void increment(){

       synchronized (this){
           System.out.printf("Incrementing %d\n",++count);

       }
    }

    public void decrement(){

        synchronized (this){
           System.out.printf("Decrementing %d\n", --count);

       }
    }

}
