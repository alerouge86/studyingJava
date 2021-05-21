package com.alerouge.demo.collection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CollectionsConvertDemoTest {

    Integer[] notSorted;
    Integer[] sorted;

    @BeforeEach
    void beforeAll() {
        notSorted = new Integer[]{7, 2, 9, 5, 1, 8};
        sorted = new Integer[]{1, 2, 5, 7, 8, 9};
    }

    @Test
    void convertingList() {
        List<Integer> list = Arrays.asList(notSorted);
        Collections.sort(list);
//        System.out.println("list: " + list);
        Integer[] arrayFromList = list.toArray(new Integer[0]);
//        Arrays.sort(arrayFromList);
//        showArray(arrayFromList);
//        Set<Integer> set = new HashSet<>(Arrays.asList(arrayFromList));
//        System.out.println("\nset = " + set);
        Set<Integer> set = new HashSet<>();
        Collections.addAll(set, arrayFromList);
//        System.out.println("\nset = " + set);
        List<Integer> listFromSet = new ArrayList<>(set);
//        System.out.println("listFromSet = " + listFromSet);
        Set<Integer> set2 = Set.copyOf(listFromSet);
        System.out.println("\nset = " + set);
    }

    @Test
    void convertingMap() {
        Map<Integer, String> map = createMap();
        System.out.println("map = " + map);
        Collection<String> values = map.values();
        String[] arrayValues = values.toArray(new String[0]);
//        showArray(arrayValues);
        List<String> listValues = new ArrayList<>(values);
        System.out.println("listValues = " + listValues);
    }

    @Test
    void convertingListToMap() {
        List<Animal> animals = Arrays.asList(
                new Animal(1, "tiger"), 
                new Animal(2, "cat"), 
                new Animal(3, "dog"));

        Map<Integer, Animal> map = animals.stream()
                .collect(Collectors.toMap(Animal::getId, animal -> animal));
        System.out.println("map = " + map);
    }

    private Map<Integer, String> createMap() {
        return Map.of(
                1, "a",
                3, "c",
                2, "b");
    }

    private void showArray(Integer[] array) {
        Arrays.stream(array).forEach(System.out::print);
    }

    private void showArray(String[] array) {
        Arrays.stream(array).forEach(System.out::print);
    }
}

class Animal {
    private int id;
    private String name;

    public Animal(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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
}