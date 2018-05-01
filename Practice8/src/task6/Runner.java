package task6;

import java.util.*;
import java.util.stream.*;

public class Runner {

    public static void run() {
        operateIntStream();
        operatePersonStream();
    }

    private static void operateIntStream() {
        List<Integer> list = Stream.iterate(10, x -> x + 10)
                .limit(10)
                .map(x -> x / 2)
                .collect(Collectors.toList());
        list.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    private static void operatePersonStream() {
        List<Person> people = generatePeople(10);
        printPeople("People:", people);
        printPeople("Military liable people:", getMilitaryLiablePeople(people));
        System.out.printf("Average woman age: %.1f", getAvgWomanAge(people));
    }

    private static List<Person> generatePeople(int count) {
        List<Person> people = new ArrayList<>();
        for(int i = 0; i < count; i++)
            people.add(Person.createPerson());
        return people;
    }

    private static void printPeople(String message, List<Person> people) {
        System.out.println(message);
        people.forEach(System.out::println);
        System.out.println();
    }

    private static List<Person> getMilitaryLiablePeople(List<Person> people) {
        return people.stream()
                .filter(Person::isMilitaryLiable)
                .collect(Collectors.toList());
    }

    private static double getAvgWomanAge(List<Person> people) {
        List<Person> woman = people.stream()
                .filter(p -> p.getSex() == Sex.FEMALE)
                .collect(Collectors.toList());
        int sum = woman.stream()
                .mapToInt(Person::getAge)
                .sum();
        int count = woman.size();
        return sum / (double) count;
    }
}
