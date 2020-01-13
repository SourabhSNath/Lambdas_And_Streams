package lambdas.lambdatut;

public class LambdaThisReference {

    public void doProcess(int i, Process process) {
        process.process(i);
    }

    public static void main(String[] args) {
        LambdaThisReference lambdaThisReference = new LambdaThisReference();
        int i = 10;

        /**
         * lambda expression doesn't override 'this' reference,
         * so we cannot use it inside the static method (main() here) like usual
         */
        lambdaThisReference.doProcess(i, i1 -> {
            System.out.println(i+10);
//            System.out.println(this);
        });

        lambdaThisReference.doProcess(i, new Process() {
            @Override
            public void process(int i1) {
                System.out.println(i1 + 10);
                System.out.println(this); //lambdas.lambdatut.LambdaThisReference$1@2d209079
                // This happens to be the instance of the anonymous inner class we created
                // this reference points to the new Process we created
            }
        });

    }

}

interface Process {
    void process(int i);
}