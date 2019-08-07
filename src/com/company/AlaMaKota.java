package com.company;

import java.util.*;

public class AlaMaKota {

    public static void main(String[] args) {

        String text = "Ala ma kota kot koduje w Javie kota";
        AlaMaKota scrapper = new AlaMaKota();
        Map<Character, Set<String>> result = scrapper.alaMaKota(text);
        System.out.println(result);
    }


    private Map<Character, Set<String>> alaMaKota(String text) {
        Map<Character, Set<String>> collection = new TreeMap<>();
        Arrays.stream(text.replaceAll("-+.^:,", "").toLowerCase().split("\\s+"))
                .forEach(word -> word.chars()
                        .mapToObj(c -> (char) c)
                        .forEach(character -> {
                            collection.putIfAbsent(character, new HashSet<>());
                            collection.get(character).add(word);
                        }));
        return collection;

    }
}



