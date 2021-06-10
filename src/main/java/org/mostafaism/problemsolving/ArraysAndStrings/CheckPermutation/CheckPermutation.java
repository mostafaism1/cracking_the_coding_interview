package org.mostafaism.problemsolving.ArraysAndStrings.CheckPermutation;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckPermutation {

    public boolean checkPermutation1(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Integer> characterFrequancy1 = getCharacterFrequancy(str1);
        Map<Character, Integer> characterFrequancy2 = getCharacterFrequancy(str2);
        Map<Character, Integer> differenceFrequancy = substractMaps(characterFrequancy1, characterFrequancy2);
        return allZero(differenceFrequancy) ? true : false;
    }

    public boolean checkPermutation2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        String sortedStr1 = sort(str1);
        String sortedStr2 = sort(str2);
        return sortedStr1.equals(sortedStr2) ? true : false;
    }

    private Map<Character, Integer> getCharacterFrequancy(String str) {
        return str.chars().mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));
    }

    private Map<Character, Integer> substractMaps(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        return Stream.of(map1, map2).flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, Math::subtractExact));
    }

    private boolean allZero(Map<Character, Integer> map) {
        return map.values().stream().anyMatch(v -> v != 0) ? false : true;
    }

    // FIXME Replace with an in-place sorting algorithm.
    private String sort(String str) {
        return str.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
