package org.mostafaism.problemsolving.ArraysAndStrings.StringRotation;

public class StringRotation {

    public boolean stringRotation(String s1, String s2) {
        return s1.length() != s2.length() ? false : isSubString(s2.concat(s2), s1);
    }

    private boolean isSubString(String s1, String s2) {
        return s1.contains(s2);
    }

}
