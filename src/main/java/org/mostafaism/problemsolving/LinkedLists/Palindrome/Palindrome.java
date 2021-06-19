package org.mostafaism.problemsolving.LinkedLists.Palindrome;

import org.mostafaism.problemsolving.datastructure.LinkedList.LinkedList;
import org.mostafaism.problemsolving.datastructure.LinkedList.Node;

public class Palindrome<K> {

    public boolean palindrome(LinkedList<K> list) {
        return palindromeHelper(list, list.getHead()).isPalindrme();
    }

    private PartialPalindrome<K> palindromeHelper(LinkedList<K> list, Node<K> head) {
        // base case
        if (list.isNil(head)) {
            return new PartialPalindrome<>(true, list.getHead());
        }

        // recursive step
        PartialPalindrome<K> partialPalindrome = palindromeHelper(list, head.next);
        return new PartialPalindrome<>(partialPalindrome.isPalindrme() && (head.key == partialPalindrome.current().key),
                partialPalindrome.current().next);
    }

    private static record PartialPalindrome<K> (boolean isPalindrme, Node<K> current) {
    };

}
