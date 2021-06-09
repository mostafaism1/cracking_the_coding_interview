package org.mostafaism.problemsolving.datastructure.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;

import org.junit.jupiter.api.Test;

public class ArrayListImplTest {

    @Test
    void it_should_push_one_element() {
        // given
        ArrayList<Integer> arrayList = new ArrayListImpl<>();

        // when
        arrayList.push(1);

        // then
        then(arrayList.get(0)).isEqualTo(1);
    }

    @Test
    void it_should_push_two_elements() {
        // given
        ArrayList<Integer> arrayList = new ArrayListImpl<>();

        // when
        arrayList.push(1);
        arrayList.push(2);

        // then
        then(arrayList.get(0)).isEqualTo(1);
        then(arrayList.get(1)).isEqualTo(2);
    }

    @Test
    void it_should_push_beyond_initial_capacity() {
        // given
        ArrayList<Integer> arrayList = new ArrayListImpl<>(2);

        // when
        arrayList.push(1);
        arrayList.push(2);
        arrayList.push(3);

        // then
        then(arrayList.get(0)).isEqualTo(1);
        then(arrayList.get(1)).isEqualTo(2);
        then(arrayList.get(2)).isEqualTo(3);
    }

    @Test
    void it_should_set() {
        // given
        ArrayList<Integer> arrayList = new ArrayListImpl<>(2);

        // when
        arrayList.push(1);
        arrayList.set(0, 2);

        // then
        then(arrayList.get(0)).isEqualTo(2);
    }

    @Test
    void it_should_throw_exception_when_set_index_is_beyond_size() {
        // given
        ArrayList<Integer> arrayList = new ArrayListImpl<>(2);
        arrayList.push(1);

        // when, then
        thenThrownBy(() -> arrayList.set(1, 2)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void it_should_throw_exception_when_get_index_is_beyond_size() {
        // given
        ArrayList<Integer> arrayList = new ArrayListImpl<>(2);
        arrayList.push(1);

        // when, then
        thenThrownBy(() -> arrayList.get(1)).isInstanceOf(IndexOutOfBoundsException.class);
    }

}
