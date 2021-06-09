package org.mostafaism.problemsolving.ArraysAndStrings.CheckPermutation;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.Test;

public class CheckPermutation1Test {

    @Test
    void it_should_return_true() {
        // given
        CheckPermutation checkPermutation = new CheckPermutation();

        // when, then
        then(checkPermutation.checkPermutation1("abc", "bac")).isTrue();
    }

    @Test
    void it_should_return_false() {
        // given
        CheckPermutation checkPermutation = new CheckPermutation();

        // when, then
        then(checkPermutation.checkPermutation1("abc", "abd")).isFalse();
    }

    @Test
    void it_should_return_false_when_the_strings_have_different_lengths() {
        // given
        CheckPermutation checkPermutation = new CheckPermutation();

        // when, then
        then(checkPermutation.checkPermutation1("abc", "abcd")).isFalse();
    }

}
