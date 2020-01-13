package lambdas.lambdatut;

import lambdas.lambdaexercises.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaMethodReference {
    public static void main(String[] args) {
        //Example 1

        Thread thread = new Thread(() -> printMethod());
        thread.start();

        // If the parameters matches use this, () and printMethod() has no parameters
        Thread thread1 = new Thread(LambdaMethodReference::printMethod); //() -> method()
        thread1.start();

        // Example 2

        List<Person> people = Arrays.asList(
                new Person("Sourabh", "S Nath", 25),
                new Person("Albert", "Einstein", 30),
                new Person("Issac", "Newton", 45),
                new Person("Nikola", "Tesla", 55),
                new Person("Stephen", "Hawking", 76)
        );

        people.forEach(System.out::print);
        people.forEach(p -> System.out.println(p.getFirstName()));

//      performConditionally(people, p -> p.getFirstName().startsWith("S"), p -> System.out.println(p));
        performConditionally(people, p -> p.getFirstName().startsWith("S"), System.out::println); // p -> method(p)
    }


    public static void printMethod() {
        System.out.println("Hello");
    }

    static void performConditionally(List<Person> people, Predicate<Person> personPredicate, Consumer<Person> consumer) {
        for (Person person : people) {
            if (personPredicate.test(person)) {
                consumer.accept(person);
            }
        }
    }
}
