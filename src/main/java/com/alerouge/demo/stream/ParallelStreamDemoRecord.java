package com.alerouge.demo.stream;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class ParallelStreamDemoRecord {

    private Instant start;
    private Instant end;
    
    public static void main(String[] args) {
        ParallelStreamDemoRecord demo = new ParallelStreamDemoRecord();
        demo.execute(ParallelStreamDemoRecord::actionToExecute);
    }

    private static void actionToExecute() {
        List<Person> people = Arrays.asList(
                new Person("ale", 26, 4500),
                new Person("vita", 24, 4499),
                new Person("cri", 25, 4498),
                new Person("john", 39, 3200),
                new Person("john", 39, 2850)
        );
        System.out.println("doing some work");
    }

    public void execute(Runnable runnable) {
        this.start = Instant.now();

        runnable.run();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.interrupted();
        }

        this.end = Instant.now();
        long durationMs = Duration.between(start, end).toMillis();
        System.out.println("durationMs = " + durationMs);
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
