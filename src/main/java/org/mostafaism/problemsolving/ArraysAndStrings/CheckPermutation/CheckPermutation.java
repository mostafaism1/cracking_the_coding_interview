package org.mostafaism.problemsolving.ArraysAndStrings.CheckPermutation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

    public boolean checkPermutation1(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Integer> characterFrequancy = getCharacterFrequancy(str1);
        if (!decrementFrequancy(characterFrequancy, str2)) {
            return false;
        }
        if (!isZero(characterFrequancy)) {
            return false;
        }
        return true;
    }

    public boolean checkPermutation2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        String sortedStr1 = sortString(str1);
        String sortedStr2 = sortString(str2);
        for (int i = 0; i < str1.length(); i++) {
            if (sortedStr1.charAt(i) != sortedStr2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> getCharacterFrequancy(String str1) {
        Map<Character, Integer> characterFrequancy = new HashMap<>();
        for (Character c : str1.toCharArray()) {
            if (characterFrequancy.containsKey(c)) {
                characterFrequancy.put(c, characterFrequancy.get(c) + 1);
            } else {
                characterFrequancy.put(c, 1);
            }
        }
        return characterFrequancy;
    }

    private boolean decrementFrequancy(Map<Character, Integer> characterFrequancy, String str) {
        for (Character c : str.toCharArray()) {
            if (characterFrequancy.containsKey(c)) {
                characterFrequancy.put(c, characterFrequancy.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isZero(Map<Character, Integer> characterFrequancy) {
        for (Integer count : characterFrequancy.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    private String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
