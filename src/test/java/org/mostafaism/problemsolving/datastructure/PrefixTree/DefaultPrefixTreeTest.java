package org.mostafaism.problemsolving.datastructure.PrefixTree;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class DefaultPrefixTreeTest {

    private Set<String> alphabet;
    private PrefixTree prefixTree;
    private List<String> insertWord;
    private List<String> searchWord;

    @Test
    void givenAnEmptyAlphabet_whenInsertingAWord_thenWillThrowAnException() {
        // Given.
        alphabet = new HashSet<>();
        prefixTree = new DefaultPrefixTree(alphabet);
        insertWord = List.of("A");

        // When. then.
        thenThrownBy(() -> prefixTree.insert(insertWord)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenAOneSymbolAlphabet_whenInsertingAOneSymbolWordWithItsSymbolNotInTheAlphabet_thenWillThrowAnException() {
        // Given.
        alphabet = Set.of("A");
        prefixTree = new DefaultPrefixTree(alphabet);
        insertWord = List.of("B");

        // When. then.
        thenThrownBy(() -> prefixTree.insert(insertWord)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenAOneSymbolAlphabet_whenInsertingAOneSymbolWordWithItsSymbolInTheAlphabet_thenWillInsert() {
        // Given.
        alphabet = Set.of("A");
        prefixTree = new DefaultPrefixTree(alphabet);
        insertWord = List.of("A");

        // When.
        prefixTree.insert(insertWord);

        // Then.
        then(prefixTree.search(insertWord)).isTrue();
    }

    @Test
    void givenATwoSymbolAlphabet_whenInsertingAOneSymbolWordWithItsSymbolNotInTheAlphabet_thenWillInsert() {
        // Given.
        alphabet = Set.of("A", "B");
        prefixTree = new DefaultPrefixTree(alphabet);
        insertWord = List.of("C");

        // When. then.
        thenThrownBy(() -> prefixTree.insert(insertWord)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenATwoSymbolAlphabet_whenInsertingAOneSymbolWordWithItsSymbolInTheAlphabet_thenWillInsert() {
        // Given.
        alphabet = Set.of("A", "B");
        prefixTree = new DefaultPrefixTree(alphabet);
        insertWord = List.of("A");

        // When.
        prefixTree.insert(insertWord);

        // Then.
        then(prefixTree.search(insertWord)).isTrue();
    }

    @Test
    void givenATwoSymbolAlphabet_whenInsertingATwoSymbolWordWithItsSymbolsInTheAlphabet_thenWillInsert() {
        // Given.
        alphabet = Set.of("A", "B");
        prefixTree = new DefaultPrefixTree(alphabet);
        insertWord = List.of("B", "A");

        // When.
        prefixTree.insert(insertWord);

        // Then.
        then(prefixTree.search(insertWord)).isTrue();
    }

    @Test
    void givenATwoSymbolAlphabet_whenInsertingATwoSymbolWordWithItsSymbolsInTheAlphabet_thenSearchingForAWordWithOnlyTheFirstSymbolInTheInsertedWordWillReturnFalse() {
        // Given.
        alphabet = Set.of("A", "B");
        prefixTree = new DefaultPrefixTree(alphabet);
        insertWord = List.of("B", "A");
        searchWord = List.of("B");

        // When.
        prefixTree.insert(insertWord);

        // Then.
        then(prefixTree.search(searchWord)).isFalse();
    }

}
