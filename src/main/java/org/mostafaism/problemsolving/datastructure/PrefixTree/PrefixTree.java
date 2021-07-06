package org.mostafaism.problemsolving.datastructure.PrefixTree;

import java.util.List;

public interface PrefixTree {
    void insert(List<String> word);

    boolean search(List<String> word);
}
