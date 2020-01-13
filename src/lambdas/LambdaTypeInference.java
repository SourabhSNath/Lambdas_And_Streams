package lambdas;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
public class LambdaTypeInference {
    public static void main(String[] args) {

        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Compiler knows that n is an integer by looking at the list's type
        numberList.forEach(n -> System.out.println(n));
        numberList.forEach(System.out::println); // since n -> sout(n) has the same parameters use method reference

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

    private static void printLambdaString(AddTwoStrings addTwoStrings) {
        System.out.println(addTwoStrings.apply("Hello", " World"));
    }
}