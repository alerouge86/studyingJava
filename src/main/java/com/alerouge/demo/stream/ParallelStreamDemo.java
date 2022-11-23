package com.alerouge.demo.stream;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.*;

public class ParallelStreamDemo {

    private Instant start;
    private Instant end;

    public static void main(String[] args) {
        ParallelStreamDemo demo = new ParallelStreamDemo();
        demo.execute(() -> actionToExecute());
    }

    public void execute(Runnable runnable) {
        this.start = Instant.now();
        runnable.run();
        this.end = Instant.now();
        long durationMs = Duration.between(start, end).toMillis();
        System.out.println("durationMs = " + durationMs);
    }

    private static void actionToExecute() {
        List<Person> people = Arrays.asList(
                new Person("al", 26, 4500),
                new Person("joe", 24, 3500),
                new Person("alex", 25, 3000),
                new Person("john", 39, 3200),
                new Person("jack", 33, 2850)
        );

        people.stream()
                .parallel()
                .filter(p -> p.getAge()>20 && p.getAge()<30)
                .filter(p -> p.getSalary() > 3000)
                .forEach(System.out::println);

    }

    private static long compute(long number) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number;
    }

    private static class Person {
        private String name;
        private int age;
        private long salary;

        public Person(String name, int age, long salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public long getSalary() {
            return salary;
        }

        public void setSalary(long salary) {
            this.salary = salary;
        }
    }
}
