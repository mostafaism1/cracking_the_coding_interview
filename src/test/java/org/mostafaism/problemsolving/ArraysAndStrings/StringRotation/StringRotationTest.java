package org.mostafaism.problemsolving.ArraysAndStrings.StringRotation;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringRotationTest {

    private StringRotation stringRotation;

    @BeforeEach
    void setup() {
        stringRotation = new StringRotation();
    }

    @Test
    void it_should_return_true_when_both_s1_and_s2_are_empty() {
        // given
        String s1 = "";
        String s2 = "";

        // when
        boolean actual = stringRotation.stringRotation(s1, s2);

        // then
        then(actual).isTrue();
    }

    @Test
    void it_should_return_false_when_only_one_string_is_empty() {
        // given
        String s1 = "a";
        String s2 = "";

        // when
        boolean actual = stringRotation.stringRotation(s1, s2);

        // then
        then(actual).isFalse();
    }

    @Test
    void it_should_return_true_when_both_strings_are_of_length_1_and_equal() {
        // given
        String s1 = "a";
        String s2 = "a";

        // when
        boolean actual = stringRotation.stringRotation(s1, s2);

        // then
        then(actual).isTrue();
    }

    @Test
    void it_should_return_false_when_both_strings_are_of_length_1_and_not_equal() {
        // given
        String s1 = "a";
        String s2 = "b";

        // when
        boolean actual = stringRotation.stringRotation(s1, s2);

        // then
        then(actual).isFalse();
    }

    @Test
    void it_should_return_false_when_s1_size_is_2_and_s2_size_is_1() {
        // given
        String s1 = "ab";
        String s2 = "a";

        // when
        boolean actual = stringRotation.stringRotation(s1, s2);

        // then
        then(actual).isFalse();
    }

    @Test
    void it_should_return_true_when_both_strings_are_of_length_2_and_equal() {
        // given
        String s1 = "ab";
        String s2 = "ab";

        // when
        boolean actual = stringRotation.stringRotation(s1, s2);

        // then
        then(actual).isTrue();
    }

    @Test
    void it_should_return_true_when_both_strings_are_of_length_2_and_s2_is_a_rotation_of_s1() {
        // given
        String s1 = "ab";
        String s2 = "ba";

        // when
        boolean actual = stringRotation.stringRotation(s1, s2);

        // then
        then(actual).isTrue();
    }

    @Test
    void it_should_return_false_when_s1_size_is_3_and_s2_size_is_1() {
        // given
        String s1 = "abc";
        String s2 = "b";

        // when
        boolean actual = stringRotation.stringRotation(s1, s2);

        // then
        then(actual).isFalse();
    }

    @Test
    void it_should_return_false_when_s1_size_is_3_and_s2_size_is_2() {
        // given
        String s1 = "abc";
        String s2 = "bc";

        // when
        boolean actual = stringRotation.stringRotation(s1, s2);

        // then
        then(actual).isFalse();
    }

    @Test
    void it_should_return_true_when_both_strings_are_of_length_3_and_equal() {
        // given
        String s1 = "abc";
        String s2 = "abc";

        // when
        boolean actual = stringRotation.stringRotation(s1, s2);

        // then
        then(actual).isTrue();
    }

    @Test
    void it_should_return_true_when_both_strings_are_of_length_3_and_s2_is_a_rotation_of_s1() {
        // given
        String s1 = "abc";
        String s2 = "bca";

        // when
        boolean actual = stringRotation.stringRotation(s1, s2);

        // then
        then(actual).isTrue();
    }

    @Test
    void it_should_return_false_when_s2_islonger_than_s1() {
        // given
        String s1 = "a";
        String s2 = "ab";

        // when
        boolean actual = stringRotation.stringRotation(s1, s2);

        // then
        then(actual).isFalse();
    }

}
