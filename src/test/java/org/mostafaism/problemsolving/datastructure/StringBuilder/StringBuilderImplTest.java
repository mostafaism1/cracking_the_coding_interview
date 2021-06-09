package org.mostafaism.problemsolving.datastructure.StringBuilder;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.Test;

public class StringBuilderImplTest {

    @Test
    void it_should_append_one_string() {
        // given
        StringBuilder sb = new StringBuilderImpl();

        // when
        sb.append("hello");

        // then
        then(sb.toString()).isEqualTo("hello");
    }

    @Test
    void it_should_append_two_strings() {
        // given
        StringBuilder sb = new StringBuilderImpl();

        // when
        sb.append("hello");
        sb.append("world");

        // then
        then(sb.toString()).isEqualTo("helloworld");
    }

    @Test
    void it_should_append_special_characters() {
        // given
        StringBuilder sb = new StringBuilderImpl();

        // when
        sb.append("hello");
        sb.append("\n");
        sb.append("world");

        // then
        then(sb.toString()).isEqualTo("hello\nworld");
    }

}
