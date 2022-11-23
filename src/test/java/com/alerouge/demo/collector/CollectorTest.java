package com.alerouge.demo.collector;

import org.junit.jupiter.api.*;
import org.springframework.util.Assert;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CollectorTest {

    final String sonnet = "Nel mezzo del cammin di nostra vita\n" +
            "mi ritrovai per una selva oscura,\n" +
            "ché la diritta via era smarrita.\n" +
            "Ahi ora quanto a tanto dir qual era è cosa dura,\n" +
            "esta selva selvaggia e aspra e forte,\n" +
            "che nel pensier tanto rinova la paura!\n" +
            "Tant'è amara ora che poco è più morte;\n" +
            "ma per trattar del ben ch'i' vi trovai,\n" +
            "dirò de l'altre ora cose ch'i' v'ho scorte.\n" +
            "Io non so ben ridir com'i' v'intrai,\n" +
            "tant'era pien di sonno a quel punto\n" +
            "che la verace via tanto abbandonai.";

    private List<String> sonnetList;

    @BeforeAll
    public void init() {
        // create list of strings from the text
        this.sonnetList = Arrays.stream(sonnet.split("\n"))
                .collect(Collectors.toList());
    }

    private <T, V> void printMap(Map<T, V> map) {
        map.forEach((k, v) -> System.out.printf("Key: %s - Value: %s\n", k, v));
    }

    private <T> void printList(List<T> list) {
        list.forEach(System.out::println);
    }

    @Test
    @Disabled
    @Order(1)
    void groupTheSonnet_byFirstLetterOfLinesWithMap() {
        System.out.println("Test 1");
        Map<String, String> collect = this.sonnetList.stream()
                .collect(toMap(
                        line -> line.substring(0, 1),
                        line -> line,
                        (line1, line2) -> line2
                ));
        printMap(collect);
        System.out.println("\n\n");
    }

    @Test
    @Order(2)
    void groupTheSonnet_byFirstLetterOfLinesWithGroupBy() {
        System.out.println("Test 2");
        Map<String, List<String>> collect = this.sonnetList.stream()
                .collect(groupingBy(line -> line.substring(0, 1)));
        printMap(collect);
        System.out.println("\n\n");
    }

    @Test
    @Order(3)
    void groupTheSonnet_byFirstLetterOfLinesWithCountingWords() {
        System.out.println("Test 3");
        Map<String, Long> collect = this.sonnetList.stream()
                .collect(groupingBy(line -> line.substring(0, 1),
                        counting()));
        printMap(collect);
        System.out.println("\n\n");
    }

    @Test
    @Order(4)
    void groupTheSonnet_byFirstLetterOfLines_thenCollectToHashSet() {
        System.out.println("Test 4");
        Map<String, HashSet<String>> collect = this.sonnetList.stream()
                .collect(groupingBy(line -> line.substring(0, 1),
                        toCollection(HashSet::new)));
        printMap(collect);
        System.out.println("\n\n");
    }

    @Test
    @Order(5)
    void findTheMostUsedWords_thenCollectToList() {
        System.out.println("Test 5");

        Pattern pattern = Pattern.compile(("[ ,':\\-]+"));

        Map<String, Long> mapWordsOccurrences = this.sonnetList.stream()
                .map(String::toUpperCase)
                .flatMap(pattern::splitAsStream)
                .collect(
                        collectingAndThen(
                                groupingBy(
                                        word -> word,
                                        counting()
                                ),
                                Map::copyOf
                        )
                );

        Map.Entry<String, Long> mostFrequentWord = mapWordsOccurrences.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();
        System.out.println("mostFrequentWord = " + mostFrequentWord);


        Map<Long, List<String>> mapWordsOccurrencesByLong = mapWordsOccurrences.entrySet().stream()
                .collect(
                        groupingBy(
                                Map.Entry::getValue,
                                mapping(
                                        Map.Entry::getKey,
                                        toList()
                                )
                        )
                );
        printMap(mapWordsOccurrencesByLong);

        Map.Entry<Long, List<String>> mapMostUsedWords = mapWordsOccurrencesByLong.entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .orElseThrow();
        System.out.println("mapMostUsedWords = " + mapMostUsedWords);

        List<String> result = mapMostUsedWords.getValue();

        System.out.println("\nlist most used words:");
        printList(result);


        assertThat(result).hasSameElementsAs(List.of("TANTO", "I", "È", "LA", "ERA", "CHE", "ORA"));


        System.out.println("\n\n");
    }

    private String[] splitToWords(String line) {
        return line.split(" +");
    }


}
