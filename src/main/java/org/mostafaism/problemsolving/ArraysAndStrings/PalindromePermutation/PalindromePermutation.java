package org.mostafaism.problemsolving.ArraysAndStrings.PalindromePermutation;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PalindromePermutation {

    public boolean palindromePermutation(String str) {
        Map<Character, Integer> frequancyMap = getFrequancyMap(str);
        long oddCount = countOdd(frequancyMap);
        return str.length() % 2 == 0 ? oddCount == 0 : oddCount == 1;
    }

    private long countOdd(Map<Character, Integer> frequancyMap) {
        return frequancyMap.values().stream().filter(v -> v % 2 != 0).count();
    }

    private Map<Character, Integer> getFrequancyMap(String str) {
        return str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));
    }
}
