package lambdas.lambdaexercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExercise1 {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Sourabh", "S Nath", 25),
                new Person("Albert", "Einstein", 30),
                new Person("Issac", "Newton", 45),
                new Person("Nikola", "Tesla", 55),
                new Person("Stephen", "Hawking", 76)
        );

        /*
         * Do these with Lambda Expressions
         */

        // Sort by last name
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return person1.lastName.compareTo(person2.lastName);
            }
        });

        // Method that prints all elements in the list
        printAll(people);

        // Print all people whose name begins with S
       printFirstNameBeginningWith(people, 'S');

    }

    private static void printFirstNameBeginningWith(List<Person> people, Character character) {
        for (Person person: people){
            if (person.firstName.charAt(0) == character) System.out.println(person);
        }
    }

    private static void printAll(List<Person> people) {
        System.out.println(people);
    }
}
