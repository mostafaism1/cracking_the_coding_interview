package org.mostafaism.problemsolving.ArraysAndStrings.URLify;

import static org.assertj.core.api.BDDAssertions.then;
import org.junit.jupiter.api.Test;

public class URLifyTest {

    @Test
    void it_should_not_change_the_string() {
        // given
        URLify urlify = new URLify();
        char[] str = new char[5];
        str[0] = 'a';
        str[1] = 'b';
        str[2] = 'c';
        int trueLength = 3;

        char[] expected = str;

        // when, then
        then(urlify.URLify(str, trueLength)).isEqualTo(expected);
    }

    @Test
    void it_should_replace_one_space() {
        // given
        URLify urlify = new URLify();
        char[] str = new char[5];
        str[0] = 'a';
        str[1] = ' ';
        str[2] = 'c';
        int trueLength = 3;

        char[] expected = new char[5];
        expected[0] = 'a';
        expected[1] = '%';
        expected[2] = '2';
        expected[3] = '0';
        expected[4] = 'c';

        // when, then
        then(urlify.URLify(str, trueLength)).isEqualTo(expected);
    }

    @Test
    void it_should_replace_two_space() {
        // given
        URLify urlify = new URLify();
        char[] str = new char[7];
        str[0] = ' ';
        str[1] = 'a';
        str[2] = ' ';
        int trueLength = 3;

        char[] expected = new char[7];
        expected[0] = '%';
        expected[1] = '2';
        expected[2] = '0';
        expected[3] = 'a';
        expected[4] = '%';
        expected[5] = '2';
        expected[6] = '0';

        // when, then
        then(urlify.URLify(str, trueLength)).isEqualTo(expected);
    }

}
