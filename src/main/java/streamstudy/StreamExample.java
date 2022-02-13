package streamstudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    class Student {
        String name;

        public String getName() {
            return name;
        }
    }
    public static void main(String[] args) {
        Student[] students = new Student[3];
        Stream<Student> stream = Arrays.stream(students);
        List<String> names = stream
                                .map(Student::getName)
                                .collect(Collectors.toList());

        names.stream().collect(Collectors.toCollection(ArrayList::new));

        IntStream intStream1 = IntStream.of(1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5, 5);
        intStream1.distinct()
                .forEach(System.out::println);


        System.out.println("-----------------------");

        intStream1 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8);
        intStream1.filter(x -> x < 5)
                .forEach(System.out::println);

        Stream<Integer> generateStream = Stream.generate(() -> 1);
        Stream<Integer> evenStream = Stream.iterate(0, n -> n + 2);

        new Random().ints().limit(5).forEach(System.out::println);
        System.out.println("----------");
        new Random().ints(3).forEach(System.out::println);

        IntStream.range(1, 5); // 1~4 IntStream
        IntStream.rangeClosed(1, 5); // 1~5 IntStream

        IntStream intStream = IntStream.of(new int[]{1, 2, 3, 4, 5});
        IntStream intStream2 = Arrays.stream(new int[]{1, 2, 3});

        Stream<String> strStream = Stream.of("a", "b", "c");
        Stream<String> strStream2 = Arrays.stream(new String[]{"a", "b", "c"});

        List<Integer> list  = Arrays.asList(1,2,3,4,5);
        list.stream()
                .forEach(System.out::println);

        Integer[] arr = {5, 10, 2, 1, 7, 9};
        Arrays.stream(arr)
                .sorted()
                .forEach(System.out::println);
    }
}
