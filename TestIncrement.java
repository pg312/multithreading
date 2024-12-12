public class TestIncrement extends Thread{

    private static int count = 0;

    public TestIncrement(String name) {
        super(name);
    }

    public void run(){
     ///   synchronized (this){
//        try {
////            this.sleep(1000);
//        } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//        }
        System.out.println(this.getName() + "\t"+(++count));
        }
    }


