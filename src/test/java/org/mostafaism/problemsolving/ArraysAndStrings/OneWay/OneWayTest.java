package org.mostafaism.problemsolving.ArraysAndStrings.OneWay;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.Test;

public class OneWayTest {

    @Test
    void it_should_return_true_when_can_replace() {
        // given
        OneWay oneWay = new OneWay();
        String str1 = "abc";
        String str2 = "adc";

        // when
        boolean actual = oneWay.oneWay(str1, str2);

        // then
        then(actual).isTrue();
    }

    @Test
    void it_should_return_true_when_can_insert() {
        // given
        OneWay oneWay = new OneWay();
        String str1 = "abc";
        String str2 = "ac";

        // when
        boolean actual = oneWay.oneWay(str1, str2);

        // then
        then(actual).isTrue();
    }

    @Test
    void it_should_return_false_when_length_difference_is_greater_than_1() {
        // given
        OneWay oneWay = new OneWay();
        String str1 = "abc";
        String str2 = "a";

        // when
        boolean actual = oneWay.oneWay(str1, str2);

        // then
        then(actual).isFalse();
    }

    @Test
    void it_should_return_false_when_can_not_replace() {
        // given
        OneWay oneWay = new OneWay();
        String str1 = "abc";
        String str2 = "ade";

        // when
        boolean actual = oneWay.oneWay(str1, str2);

        // then
        then(actual).isFalse();
    }

    @Test
    void it_should_return_false_when_can_not_insert() {
        // given
        OneWay oneWay = new OneWay();
        String str1 = "abc";
        String str2 = "ad";

        // when
        boolean actual = oneWay.oneWay(str1, str2);

        // then
        then(actual).isFalse();
    }
}
