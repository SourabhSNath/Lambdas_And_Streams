package lambdas.lambdatut;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Using a wrapper
 */
public class LambdaExceptionHandling {

    public static void main(String[] args) {
        int[] someNumbers = IntStream.range(1, 15).toArray();
        int key = 0;
        System.out.println(Arrays.toString(someNumbers));

        // Put the lambda expression in another interface called wrapperLambda which returns the
        // the same consumer, basically a no op
        //
        // The wrapper lambda takes care of the exceptions
        process(someNumbers, key, wrapperLambda((s, k) -> System.out.print((s / k) + " ")));

        List<Integer> list = IntStream.range(1, 15).boxed().collect(Collectors.toList());
        list.forEach(wrapperLambda(integer -> System.out.println(integer / key))); //wrapperLambda handles exception
    }

    private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
        for (int someNumber : someNumbers) {
            consumer.accept(someNumber, key);
        }
    }

    /**
     * It's basically creating a new lambda expression from the lambda that was passed in
     * It's wrapping the previous lambda expression with a new Lambda expression
     * Includes a try catch block to catch Exception
     *
     * @param wrapperConsumer takes in the lambda which should have been done directly
     * @return a new consumer which has exception handling capabilities
     */
    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> wrapperConsumer) {
        return (v, k) -> {
            try {
                wrapperConsumer.accept(v, k);
            } catch (ArithmeticException ae) {
                System.out.println(ae.toString());
            }
        };
    }

    // Wrapper to be used in list.foreach
    private static Consumer<Integer> wrapperLambda(Consumer<Integer> wrapperConsumer) {
        return v -> {
            try {
                wrapperConsumer.accept(v);
            } catch (ArithmeticException ae) {
                System.out.println(ae.toString());
            }
        };
    }
}
