package streams;

import lambdas.lambdaexercises.Person;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
public class Streams1 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        /** 0 initial val, current_total + e,
         * current_total initially = 0
         */

        System.out.println(
                numbers.stream()
                        .reduce(0, (total, e) -> Integer.sum(total, e)));
        /**
         * reduce(T identity, BinaryOperator<T> accumulator);
         *
         * identity:
         * The identity element is both the initial value of the reduction and the default result
         * if there are no elements in the stream. In this example, the identity element is 0;
         * this is the initial value of the sum of ages and the default value if no members exist
         * in the collection roster.
         *
         * accumulator: The accumulator function takes two parameters:
         * a partial result of the reduction (in this example, the sum of all processed integers so far) and
         * the next element of the stream (in this example, an integer). It returns a new partial result.
         * In this example, the accumulator function is a lambda expression that adds two Integer values
         * and returns an Integer value:
         */

        System.out.println(
                numbers.stream()
                        .reduce(0, Integer::sum)); // Replaced directly

        System.out.println(
                numbers.stream()
                        .map(String::valueOf)
                        .reduce("", String::concat) //initial, (carry, str) -> carry.concat(str) | carry is initially identity ""
        );

        // *******************************************************************************************************

        List<Person> people = Arrays.asList(
                new Person("Sourabh", "S Nath", 25),
                new Person("Albert", "Einstein", 30),
                new Person("Issac", "Newton", 45),
                new Person("Nikola", "Tesla", 55),
                new Person("Stephen", "Hawking", 76)
        );

        System.out.println();
        people.stream()
                .filter(person -> person.getFirstName().startsWith("S"))
                .forEach(System.out::println);

    }
}
