package org.mostafaism.problemsolving.datastructure.Heap;

import org.junit.jupiter.api.BeforeEach;

public class DefaultMinHeapTest extends MinHeapTest {

    @BeforeEach
    void setup() {
        this.minHeap = new DefaultMinHeap<>();
    }

}
