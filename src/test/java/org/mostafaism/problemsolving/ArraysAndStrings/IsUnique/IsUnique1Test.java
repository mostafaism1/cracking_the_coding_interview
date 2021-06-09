package org.mostafaism.problemsolving.ArraysAndStrings.IsUnique;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.Test;

public class IsUnique1Test {

    @Test
    void it_should_return_true_on_a_unique_string() {
        // given
        IsUnique isUnique = new IsUnique();

        // when, then
        then(isUnique.isUnique1("abc")).isTrue();
    }

    @Test
    void it_should_return_false_on_a_non_unique_string() {
        // given
        IsUnique isUnique = new IsUnique();

        // when, then
        then(isUnique.isUnique1("abca")).isFalse();
    }

}
