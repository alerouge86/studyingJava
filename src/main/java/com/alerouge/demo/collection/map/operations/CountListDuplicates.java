package com.alerouge.demo.collection.map.operations;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountListDuplicates {
    public static void main(String[] args) {

        Employee employee1 = new Employee(1, "joe");
        Employee employee2 = new Employee(33, "marie");
        Employee employee3 = new Employee(8, "lucie");

        Employee employee4 = new Employee(15, "tom");
        Employee employee5 = new Employee(88, "joe");

        Map<String, Employee> mapEmployees1 = new HashMap<>();
        mapEmployees1.put(employee1.getName(), employee1);
        mapEmployees1.put(employee2.getName(), employee2);
        mapEmployees1.put(employee3.getName(), employee3);

        Map<String, Employee> mapEmployees2 = new HashMap<>();
        mapEmployees2.put(employee4.getName(), employee4);
        mapEmployees2.put(employee5.getName(), employee5);

        System.out.println("map 1");
        mapEmployees1.forEach((k,v)-> System.out.println("k = " + k + ": " + v));

        System.out.println("map 2");
        mapEmployees2.forEach((k,v)-> System.out.println("k = " + k + ": " + v));

        // merge
        Map<String, Employee> mapEmployees3 = new HashMap<>(mapEmployees1);

        mapEmployees2.forEach(
                (k1, v1) -> mapEmployees3.merge(k1, v1, (k2, v2) -> new Employee(v1.getId(), v2.getName()))
        );

        System.out.println("map 3 merged");
        mapEmployees3.forEach((k,v)-> System.out.println("k = " + k + ": " + v));


        Map<String, Employee> mapEmployees4 = Stream.concat(mapEmployees1.entrySet().stream(), mapEmployees2.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (value1, value2) -> new Employee(value1.getId(), value1.getName())
                ));


        System.out.println("map 4 concat");
        mapEmployees4.forEach((k,v)-> System.out.println("k = " + k + ": " + v));


        System.out.println("test");
        Stream<Map.Entry<String, Employee>> test = Stream.of(mapEmployees1, mapEmployees2)
                .flatMap(map -> map.entrySet().stream());
        test.forEach(System.out::println);

        Map<String, Employee> mapEmployees5 = Stream.of(mapEmployees1, mapEmployees2)
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (value1, value2) -> new Employee(value2.getId(), value1.getName())
                ));

        System.out.println("map 5 stream of");
        mapEmployees5.forEach((k,v)-> System.out.println("k = " + k + ": " + v));

    }

}

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
