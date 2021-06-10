package org.mostafaism.problemsolving.ArraysAndStrings.IsUnique;

public class IsUnique {

    public boolean isUnique1(String str) {
        return str.chars().distinct().count() == str.length() ? true : false;
    }

    public boolean isUnique2(String str) {
        String sortedStr = sort(str);
        return hasDifferentSubsequentCharacters(sortedStr) ? true : false;
    }

    // FIXME Replace with an in-place sorting algorithm.
    private String sort(String str) {
        return str.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private boolean hasDifferentSubsequentCharacters(String str) {
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

}
