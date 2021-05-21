package com.alerouge.demo.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamBasicDemo {

    public static final String FILE_NAME = "myFile.txt";

    public static void main(String[] args) {
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("1", "2", "3", "46"),
                Arrays.asList("one", "two", "four"),
                Arrays.asList("myName")
        );
        Map<Object, List<String>> allWords = nestedList.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(s -> s.length()));
        allWords.entrySet().stream()
                .forEach(System.out::println);
    }

}
