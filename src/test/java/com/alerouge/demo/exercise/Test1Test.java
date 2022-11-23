package com.alerouge.demo.exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class Test1Test {

    @Test
    void whenPresent_findSmallestSubstring() {
        String expectedResult = "cab";

        String[] chars = {"c", "b", "a"};
        String str = "abbccabaccba";

        Test1 test1 = new Test1();
        String result = test1.findSmallestSubstring(chars, str);

        assertThat(expectedResult).isEqualTo(result);
    }

    @Test
    void whenNotPresent_returnBlank() {
        String expectedResult = "";

        String[] chars = {"c", "b", "a"};
        String str = "abbcbcbbaaca";

        Test1 test1 = new Test1();
        String result = test1.findSmallestSubstring(chars, str);

        assertThat(expectedResult).isEqualTo(result);
    }

    @Test
    void whenInputSmallerThanArray_returnBlank() {
        String expectedResult = "";

        String[] chars = {"c", "b", "a"};
        String str = "ab";

        Test1 test1 = new Test1();
        String result = test1.findSmallestSubstring(chars, str);

        assertThat(expectedResult).isEqualTo(result);
    }
}