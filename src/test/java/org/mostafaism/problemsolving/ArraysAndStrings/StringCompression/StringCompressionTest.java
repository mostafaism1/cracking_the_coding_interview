package org.mostafaism.problemsolving.ArraysAndStrings.StringCompression;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCompressionTest {

    StringCompression stringCompression;

    @BeforeEach
    void setup() {
        stringCompression = new StringCompression();
    }

    @Test
    void it_should_return_empty_string_when_input_string_is_empty() {
        // given
        String input = "";
        String expected = "";

        // when
        String actual = stringCompression.stringCompression(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @Test
    void it_should_not_compress_when_input_is_one_char_long() {
        // given
        String input = "a";
        String expected = "a";

        // when
        String actual = stringCompression.stringCompression(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @Test
    void it_should_not_compress_when_input_has_one_repeat_chain_of_length_2() {
        // given
        String input = "aa";
        String expected = "aa";

        // when
        String actual = stringCompression.stringCompression(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @Test
    void it_should_not_compress_when_input_has_two_repeat_chains_of_length_2() {
        // given
        String input = "aabb";
        String expected = "aabb";

        // when
        String actual = stringCompression.stringCompression(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @Test
    void it_should_not_compress_when_input_has_three_repeat_chains_of_length_2_two_of_which_are_of_the_same_character() {
        // given
        String input = "aabbaa";
        String expected = "aabbaa";

        // when
        String actual = stringCompression.stringCompression(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @Test
    void it_should_compress_when_input_has_one_repeat_chain_of_length_3() {
        // given
        String input = "aaa";
        String expected = "a3";

        // when
        String actual = stringCompression.stringCompression(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @Test
    void it_should_compress_when_input_has_two_repeat_chains_of_length_2_and_3() {
        // given
        String input = "aabbb";
        String expected = "a2b3";

        // when
        String actual = stringCompression.stringCompression(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @Test
    void it_should_compress_when_input_has_three_repeat_chains_of_length_2_and_3_and_2_two_of_which_are_of_the_same_character() {
        // given
        String input = "aabbbaa";
        String expected = "a2b3a2";

        // when
        String actual = stringCompression.stringCompression(input);

        // then
        then(actual).isEqualTo(expected);
    }

}
