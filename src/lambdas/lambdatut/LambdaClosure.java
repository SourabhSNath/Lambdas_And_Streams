package lambdas.lambdatut;

public class LambdaClosure {
    public static void main(String[] args) {

        int a = 10;
        int b = 20; // The compiler expects it be final and freezes the value
        // this statement get's executed at the doProcess() outside main, where b isn't available
        doProcess(a, i -> System.out.println(i + b)); // the value of b is passed along with the lambda expression

        //This is the concept of closure
    }

    private static void doProcess(int i, Process process) {
        process.process(i);
    }

    interface Process {
        void process(int i);
    }

}


