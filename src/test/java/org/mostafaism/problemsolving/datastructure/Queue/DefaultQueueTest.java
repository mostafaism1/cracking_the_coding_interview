package org.mostafaism.problemsolving.datastructure.Queue;

import org.junit.jupiter.api.BeforeEach;

public class DefaultQueueTest extends QueueTest {

    @BeforeEach
    void setup() {
        queue = new DefaultQueue<>();
    }
}
