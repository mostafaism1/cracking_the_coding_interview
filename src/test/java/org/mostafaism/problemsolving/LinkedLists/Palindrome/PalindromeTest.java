package org.mostafaism.problemsolving.LinkedLists.Palindrome;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.LinkedList.DoublyLinkedList;
import org.mostafaism.problemsolving.datastructure.LinkedList.LinkedList;
import org.mostafaism.problemsolving.datastructure.LinkedList.Node;

public class PalindromeTest {

    private Palindrome<Character> palindrome;
    private LinkedList<Character> list;

    @BeforeEach
    void setup() {
        palindrome = new Palindrome<>();
        list = new DoublyLinkedList<>();
    }

    @Test
    void it_should_return_true_when_list_is_empty() {
        // given

        // when
        boolean actual = palindrome.palindrome(list);

        // then
        then(actual).isTrue();
    }

    @Test
    void it_should_return_true_when_list_size_is_1() {
        // given
        list.add(new Node<>('a'));

        // when
        boolean actual = palindrome.palindrome(list);

        // then
        then(actual).isTrue();
    }

    @Test
    void it_should_return_false_when_list_size_is_2_and_list_elements_are_different() {
        // given
        list.add(new Node<>('a'));
        list.add(new Node<>('b'));

        // when
        boolean actual = palindrome.palindrome(list);

        // then
        then(actual).isFalse();
    }

    @Test
    void it_should_return_true_when_list_size_is_2_and_list_elements_are_equal() {
        // given
        list.add(new Node<>('a'));
        list.add(new Node<>('a'));

        // when
        boolean actual = palindrome.palindrome(list);

        // then
        then(actual).isTrue();
    }

    @Test
    void it_should_return_false_when_list_size_is_3_and_list_elements_are_all_different() {
        // given
        list.add(new Node<>('a'));
        list.add(new Node<>('b'));
        list.add(new Node<>('c'));

        // when
        boolean actual = palindrome.palindrome(list);

        // then
        then(actual).isFalse();
    }

    @Test
    void it_should_return_false_when_list_size_is_3_and_list_is_not_a_palindrome() {
        // given
        list.add(new Node<>('a'));
        list.add(new Node<>('b'));
        list.add(new Node<>('b'));

        // when
        boolean actual = palindrome.palindrome(list);

        // then
        then(actual).isFalse();
    }

    @Test
    void it_should_return_true_when_list_size_is_3_and_list_is_a_palindrome() {
        // given
        list.add(new Node<>('a'));
        list.add(new Node<>('b'));
        list.add(new Node<>('a'));

        // when
        boolean actual = palindrome.palindrome(list);

        // then
        then(actual).isTrue();
    }
}
