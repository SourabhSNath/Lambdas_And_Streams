package lambdas.lambdatut;

public class LambdaRunnable {
    public static void main(String[] args) {

        // Old way
        Thread oldThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        oldThread.start();

        /*
         * Runnable interface only has 1 method with no parameters which returns void
         * hence why it can be used as a functional interface for lambda expressions
         */
        Thread myThread = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        myThread.start();

        Thread thread2 = new Thread(() -> {

        });
    }
}
