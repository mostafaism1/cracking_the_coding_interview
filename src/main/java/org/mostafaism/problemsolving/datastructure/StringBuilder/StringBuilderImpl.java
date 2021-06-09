package org.mostafaism.problemsolving.datastructure.StringBuilder;

import java.util.ArrayList;

public class StringBuilderImpl implements StringBuilder {

    private ArrayList<Character> builder;
    private String cachedValue;

    public StringBuilderImpl() {
        builder = new ArrayList<>();
        cachedValue = null;
    }

    @Override
    public void append(String string) {
        for (char c : string.toCharArray()) {
            builder.add(c);
        }
        cachedValue = null;
    }

    @Override
    public String toString() {
        char[] charArray = new char[builder.size()];
        for (int i = 0; i < builder.size(); i++) {
            charArray[i] = builder.get(i);
        }
        cachedValue = new String(charArray);
        return cachedValue;
    }

}
