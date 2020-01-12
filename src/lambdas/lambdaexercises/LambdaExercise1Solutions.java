package lambdas.lambdaexercises;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaExercise1Solutions {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Sourabh", "S Nath", 25),
                new Person("Albert", "Einstein", 30),
                new Person("Issac", "Newton", 45),
                new Person("Nikola", "Tesla", 55),
                new Person("Stephen", "Hawking", 76)
        );


        // Sort by last name
        people.sort((Person p1, Person p2) -> p1.lastName.compareTo(p2.lastName));

        //or
//        people.sort(Comparator.comparing((Person p) -> p.lastName));

        /* ****************************************************************
         * 1. Prints all elements
         */

        // Type 1 Solution:
        performConditionally(people, p -> true); // Setting predicate's test to true, Pass p to test and return true

        // Type 2 Solution:
        Consumer<List<Person>> printAll = System.out::println;
        printAll.accept(people);

        /* *****************************************************************
         * 2. Print elements with the same first character in the first name
         */

        // Type 1 Solution:
        performConditionally(people, p -> p.firstName.startsWith("S")); // Pass P to test and return the boolean

        // with consumer to print
        performConditionally(people, p -> p.firstName.startsWith("S"), System.out::println);
        // another one that prints the first name
        performConditionally(people, p -> p.firstName.startsWith("S"), p -> System.out.println(p.firstName));

        // Type 2 Solution:
        BiConsumer<List<Person>, String> printConditionally = (p, s) -> p.forEach(
                person -> {
                    if (person.firstName.startsWith(s)) System.out.println(person);
                }
        );
        printConditionally.accept(people, "S");
    }


    static void performConditionally(List<Person> people, Predicate<Person> personPredicate) {
        for (Person p : people) {
            if (personPredicate.test(p))
                System.out.println(p); // Test is boolean method, the condition passed above returns boolean, hence why it works
        }
    }

    // Overloading with consumer to print according to the input
    static void performConditionally(List<Person> people, Predicate<Person> personPredicate, Consumer<Person> consumer) {
        for (Person person : people) {
            if (personPredicate.test(person)) {
                consumer.accept(person);
            }
        }
    }
}


// interface PrintElements {
//     void print(List<Person> list, String stringCharacter);
// }
//
//
//    // Reusing it to print people with firstName starting with S
//    PrintElements printConditionally = (p, c) -> p.forEach(person -> {
//        if (person.firstName.startsWith(c)) System.out.println(person);
//    });
//
//        printConditionally.print(people, "S");