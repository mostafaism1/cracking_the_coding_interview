package org.mostafaism.problemsolving.ArraysAndStrings.URLify;

public class URLify {
    private static final String URL_SPACE = "%20";

    public char[] urlify(char[] str, int trueLength) {
        int spaces = countSpaces(str, trueLength);
        int difference = URL_SPACE.length() - 1;
        int displacement = spaces * difference;
        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                for (int j = 0; j < URL_SPACE.length(); j++) {
                    str[i + displacement - j] = URL_SPACE.charAt(URL_SPACE.length() - j - 1);
                }
                displacement -= difference;
            } else {
                str[i + displacement] = str[i];
            }
        }
        return str;
    }

    private int countSpaces(char[] str, int trueLength) {
        int result = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                result++;
            }
        }
        return result;
    }
}
