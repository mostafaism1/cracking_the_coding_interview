package org.mostafaism.problemsolving.ArraysAndStrings.OneWay;

public class OneWay {

    public boolean oneWay(String str1, String str2) {
        int lengthDifference = Math.abs(str1.length() - str2.length());
        return lengthDifference > 1 ? false
                : lengthDifference == 0 ? canReplace(str1, str2) : canInsert(str1, str2);
    }

    private boolean canReplace(String str1, String str2) {
        return mismatchCharacterCount(str1, str2) <= 1;
    }

    /**
     * Returns the number of non-matching characters between the 2 strings.
     * 
     * The 2 strings have equal lengths.
     * 
     * @param str1 the first string
     * @param str2 the second string
     * @return the number of non-matching characters between the 2 strings
     */
    private int mismatchCharacterCount(String str1, String str2) {
        int result = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                result++;
            }
        }
        return result;
    }

    private boolean canInsert(String str1, String str2) {
        String shortString = str1.length() > str2.length() ? str2 : str1;
        String longString = str1.length() > str2.length() ? str1 : str2;
        return canPartition(shortString, longString);
    }

    /**
     * Returns true if there exists an index i around which longString can be partitioned into 2
     * sub-strings (excluding the ith element) whose concatenation equals shortString, otherwise
     * false.
     * 
     * longString.length must equal shortString.length() + 1.
     * 
     * @param shortString the shorter string
     * @param longString the longer string
     * @return true if there exists an index i around which longString can be partitioned into 2
     *         sub-strings (excluding the ith element) whose concatenation equals shortString,
     *         otherwise false.
     */
    private boolean canPartition(String shortString, String longString) {
        for (int i = 0; i < shortString.length(); i++) {
            if (shortString.charAt(i) != longString.charAt(i)) {
                return shortString.substring(i, shortString.length())
                        .equals(longString.substring(i + 1, longString.length()));
            }
        }
        return true;
    }
}
