package org.mostafaism.problemsolving.datastructure.Heap;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.Test;

public abstract class MinHeapTest {

    protected MinHeap<Integer> minHeap;

    @Test
    void givenAnEmptyHeap_whenInsertingOneElement_thenExtractMinWillReturnThatElement() {
        // Given.
        int item = 0;

        // When.
        minHeap.insert(item);

        // Then.
        then(minHeap.extractMin()).isEqualTo(item);
    }

    @Test
    void givenAnEmptyHeap_whenInsertingTwoElementsInAscendingOrder_thenExtractMinWillReturnTheMinElement() {
        // Given.
        int item0 = 0;
        int item1 = 1;

        // When.
        minHeap.insert(item0);
        minHeap.insert(item1);

        // Then.
        then(minHeap.extractMin()).isEqualTo(item0);
        then(minHeap.extractMin()).isEqualTo(item1);
    }

    @Test
    void givenAnEmptyHeap_whenInsertingTwoElementsInDescendingOrder_thenExtractMinWillReturnTheMinElement() {
        // Given.
        int item0 = 1;
        int item1 = 0;

        // When.
        minHeap.insert(item0);
        minHeap.insert(item1);

        // Then.
        then(minHeap.extractMin()).isEqualTo(item1);
        then(minHeap.extractMin()).isEqualTo(item0);
    }

    @Test
    void givenAnEmptyHeap_whenInsertingThreeElementsInAscendingOrder_thenExtractMinWillReturnTheMinElement() {
        // Given.
        int item0 = 0;
        int item1 = 1;
        int item2 = 2;

        // When.
        minHeap.insert(item0);
        minHeap.insert(item1);
        minHeap.insert(item2);

        // Then.
        then(minHeap.extractMin()).isEqualTo(item0);
        then(minHeap.extractMin()).isEqualTo(item1);
        then(minHeap.extractMin()).isEqualTo(item2);
    }

    @Test
    void givenAnEmptyHeap_whenInsertingThreeElementsInDescendingOrder_thenExtractMinWillReturnTheMinElement() {
        // Given.
        int item0 = 2;
        int item1 = 1;
        int item2 = 0;

        // When.
        minHeap.insert(item0);
        minHeap.insert(item1);
        minHeap.insert(item2);

        // Then.
        then(minHeap.extractMin()).isEqualTo(item2);
        then(minHeap.extractMin()).isEqualTo(item1);
        then(minHeap.extractMin()).isEqualTo(item0);
    }

    @Test
    void givenAnEmptyHeap_whenInsertingThreeElementsInParticularOrder_thenExtractMinWillReturnTheMinElement() {
        // Given.
        int item0 = 1;
        int item1 = 2;
        int item2 = 0;

        // When.
        minHeap.insert(item0);
        minHeap.insert(item1);
        minHeap.insert(item2);

        // Then.
        then(minHeap.extractMin()).isEqualTo(item2);
        then(minHeap.extractMin()).isEqualTo(item0);
        then(minHeap.extractMin()).isEqualTo(item1);
    }

}
