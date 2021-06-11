package org.mostafaism.problemsolving.ArraysAndStrings.StringCompression;

public class StringCompression {

    public String stringCompression(String str) {
        StringBuilder result = new StringBuilder();
        int newCharStartIndex = 0;
        while (newCharStartIndex < str.length()) {
            char newChar = str.charAt(newCharStartIndex);
            result.append(newChar);
            int repeats = 1;
            while (newCharStartIndex + repeats < str.length() && str.charAt(newCharStartIndex + repeats) == newChar) {
                repeats++;
            }
            result.append(repeats);
            newCharStartIndex += repeats;
        }
        return result.length() < str.length() ? result.toString() : str;
    }
}
