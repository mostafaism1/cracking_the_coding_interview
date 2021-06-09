package org.mostafaism.problemsolving.ArraysAndStrings.IsUnique;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsUnique {

    public boolean isUnique1(String string) {
        Set<Character> set = new HashSet<>();
        for (Character character : string.toCharArray()) {
            if (set.contains(character)) {
                return false;
            }
            set.add(character);
        }
        return true;
    }

    public boolean isUnique2(String string) {
        String sorted = sort(string);
        char previous = string.charAt(0);
        for (int i = 1; i < sorted.length(); i++) {
            char c = sorted.charAt(i);
            if (c == previous) {
                return false;
            }
            previous = c;
        }
        return true;
    }

    private String sort(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
