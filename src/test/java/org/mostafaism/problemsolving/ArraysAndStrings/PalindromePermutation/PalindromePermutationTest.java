package org.mostafaism.problemsolving.ArraysAndStrings.PalindromePermutation;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.Test;

public class PalindromePermutationTest {

    @Test
    void it_should_return_true_when_empty() {
        // given
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        String str = "";

        // when
        boolean actual = palindromePermutation.palindromePermutation(str);

        // then
        then(actual).isTrue();
    }

    @Test
    void it_should_return_true_when_length_is_1() {
        // given
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        String str = "a";

        // when
        boolean actual = palindromePermutation.palindromePermutation(str);

        // then
        then(actual).isTrue();
    }

    @Test
    void it_should_return_true_when_palindrome_and_even_and_only_one_unique_character() {
        // given
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        String str = "aa";

        // when
        boolean actual = palindromePermutation.palindromePermutation(str);

        // then
        then(actual).isTrue();
    }

    @Test
    void it_should_return_true_when_palindrome_and_odd_and_only_one_unique_character() {
        // given
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        String str = "aaa";

        // when
        boolean actual = palindromePermutation.palindromePermutation(str);

        // then
        then(actual).isTrue();
    }

    @Test
    void it_should_return_true_when_palindrome_and_even() {
        // given
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        String str = "abab";

        // when
        boolean actual = palindromePermutation.palindromePermutation(str);

        // then
        then(actual).isTrue();
    }

    @Test
    void it_should_return_true_when_palindrome_and_odd() {
        // given
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        String str = "aba";

        // when
        boolean actual = palindromePermutation.palindromePermutation(str);

        // then
        then(actual).isTrue();
    }

    @Test
    void it_should_return_false_when_not_palindrome_and_even() {
        // given
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        String str = "ab";

        // when
        boolean actual = palindromePermutation.palindromePermutation(str);

        // then
        then(actual).isFalse();
    }

    @Test
    void it_should_return_false_when_not_palindrome_and_odd() {
        // given
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        String str = "abc";

        // when
        boolean actual = palindromePermutation.palindromePermutation(str);

        // then
        then(actual).isFalse();
    }
}
