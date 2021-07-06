package org.mostafaism.problemsolving.datastructure.PrefixTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

public class DefaultPrefixTree implements PrefixTree {

    @Data
    @AllArgsConstructor
    private static class PrefixTreeNode {
        private String symbol;
        private boolean isWord;
        private PrefixTreeNode[] children;
    }

    /*
     * Design decisions documentation:
     * 
     * I chose a Set<String> instead of a Set<Character>, to allow for
     * multi-character symbols.
     * 
     * I chose a List instead of a Set, to have each symbol in the alphabet
     * associated with an index - its index in the list -
     */
    private final List<String> alphabet;

    /*
     * Design decisions documentation:
     * 
     * I chose to make the root data type a PrefixTreeNode instead of an array of
     * PrefixTreeNodes, to allow for uniform handling of the root as any inner node.
     */
    private final PrefixTreeNode root;

    public DefaultPrefixTree(Set<String> alphabet) {
        this.alphabet = new ArrayList<>(alphabet);
        this.root = new PrefixTreeNode(null, false, new PrefixTreeNode[alphabet.size()]);
    }

    @Override
    public void insert(List<String> word) {
        var current = root;
        for (String symbol : word) {
            if (!alphabet.contains(symbol)) {
                throw new IllegalArgumentException("Word contains a symbol that is not in the alphabet.");
            }
            int symbolIndex = alphabet.indexOf(symbol);
            if (current.children[symbolIndex] == null) {
                current.children[symbolIndex] = new PrefixTreeNode(symbol, false, new PrefixTreeNode[alphabet.size()]);
            }
            current = current.children[symbolIndex];
        }
        current.isWord = true;
    }

    @Override
    public boolean search(List<String> word) {
        boolean containsPath = true;
        var current = root;
        for (String symbol : word) {
            if (!alphabet.contains(symbol)) {
                throw new IllegalArgumentException("Word contains a symbol that is not in the alphabet.");
            }
            var next = current.children[alphabet.indexOf(symbol)];
            if (next == null) {
                containsPath = false;
                break;
            }
            current = next;
        }
        return containsPath && current.isWord;
    }

}
