package lambdas.lambdatut;

public class Lambda1 {

    public static void main(String[] args) {

        /*
         * Lambda Expression:
         * Here there is no need to create a class.
         * It's just like creating an anonymous inner class, although its's a bit different
         *
         * It avoids creating a new class for the implementation
         */

        GreetingInterface print = () -> System.out.println("Hello World from lambda");
        print.print(); //Use it here



        /* **********************************************************************
         * Inline implementation of the interface though an anonymous inner class
         */
        GreetingInterface greeting = new GreetingInterface() {
            @Override
            public void print() {
                System.out.println("Hello World from greeting anonymous inner class");
            }
        };
        greeting.print();

        /* ***********************************************************************
         * Here it is implemented in a class and the logic is provided in the class
         */
        GreetingInterface printer = new Greeting();
        print(printer);

    }

    public static void print(GreetingInterface greeting) {
        greeting.print();
    }

}

/*
 * Functional interface
 *  Cannot have multiple methods in the interface, the compiler will throw an error
 */
interface GreetingInterface {
    void print(); // Takes no arguments and returns a void, just like the expression above.
}

// Interface implemented class
class Greeting implements GreetingInterface {
    @Override
    public void print() {
        System.out.println("Hello World from Greeting class implementation");
    }

}