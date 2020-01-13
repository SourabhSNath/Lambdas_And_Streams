package streams;

import java.util.Arrays;
import java.util.List;

public class Streams2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Given the values, double the even numbers and total\
        int total = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                total += number * 2;
            }
        }
        System.out.println(total);

        //Now with streams
        // 1:
        System.out.println(
                numbers.stream()
                        .filter(number -> number % 2 == 0)
                        .map(number -> number * 2)
                        .reduce(0, Integer::sum)
        );

        //2:
        System.out.println(
                numbers.stream()
                        .filter(n -> n % 2 == 0)
                        .mapToInt(n -> n * 2)
                        .sum()
        );
    }
}
