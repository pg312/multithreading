public class DeadlockExample {

    public void testDeadlock(){
        String resource1 = "Resource1";
        String resource2 = "Resource2";

        Thread sharedResource1 = new Thread(){
            public void run(){
                synchronized(resource1){
                    System.out.printf(Thread.currentThread() + "\t acquired lock on\t"+resource1+"\n");
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    synchronized (resource2){
                        System.out.printf(Thread.currentThread() +"\t acquired lock on\t"+resource2+"\n");
                    }
                }


            }};
        Thread sharedResource2 = new Thread(){
            public void run(){
                synchronized(resource2){
                    System.out.printf(Thread.currentThread() + "\t acquired lock on\t"+ resource2+"\n");
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    synchronized (resource1){
                        System.out.printf(Thread.currentThread() +"\t acquired lock on\t"+resource1+"\n");
                    }
                }
            }
        };

        sharedResource1.start();
        sharedResource2.start();
    }
}
