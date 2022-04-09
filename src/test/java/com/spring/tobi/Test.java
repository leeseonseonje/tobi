package com.spring.tobi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    @org.junit.jupiter.api.Test
    void test() {
        List<String> list = new java.util.ArrayList<>(List.of("aa", "aa"));
        List<String> list2 = List.of("aa", "ab", "ba");
        List<String> result = new ArrayList<>();

        for(int i = 0; i < list.size(); ++i) {
            if(list2.contains(list.get(i))) result.add(list.get(i));
        }

        list.removeAll(list2);

        list.forEach(System.out::println);

    }
}
