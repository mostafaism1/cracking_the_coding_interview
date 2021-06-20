package org.mostafaism.problemsolving.LinkedLists.LoopDetection;

import org.mostafaism.problemsolving.datastructure.LinkedList.Node;

public class LoopDetection<K> {

    public Node<K> loopDetection(Node<K> head) {
        // Find the first point of collision.
        Node<K> slowRunner = head;
        Node<K> fastRunner = head;
        do {
            if (slowRunner == null || fastRunner == null || fastRunner.next == null) {
                return null;
            }
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        } while (slowRunner != fastRunner);

        // Rewind the slowRunner to the head.
        slowRunner = head;

        // Find the second point of collision, which is the node at the start of the
        // loop.
        while (slowRunner != fastRunner) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }
        return slowRunner;
    }

}
