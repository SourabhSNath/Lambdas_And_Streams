package lambdas.lambdatut;

public class LambdaTypeInference{
    public static void main(String[] args) {

        /*
         * It looks at the left side to know the type to return
         */
        AddTwoStrings addTwoStrings = (s1, s2) -> s1 + s2;
        printLambdaString(addTwoStrings);

        AddTwoNumbers<Float, Float, Integer> adder = (n1, n2) -> (int) (n1 + n2);
        System.out.println(adder.apply(3.4f, 3.14f));
    }

    /*
     * Compiler sees that it takes in inputs of type String
     * and that it returns a type String
     */
    interface AddTwoStrings {
        String apply(String s1, String s2);
    }

    interface AddTwoNumbers<T1, T2, R> {
        R apply(T1 number1, T2 number2);
    }

    private static void printLambdaString(AddTwoStrings addTwoStrings){
        System.out.println(addTwoStrings.apply("Hello", " World"));
    }
}