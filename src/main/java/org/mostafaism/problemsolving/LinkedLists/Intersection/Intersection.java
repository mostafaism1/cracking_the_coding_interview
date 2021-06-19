package org.mostafaism.problemsolving.LinkedLists.Intersection;

import org.mostafaism.problemsolving.datastructure.LinkedList.Node;

public class Intersection<K> {

    /*
     * The inputs for this problem are of type Node and not LinkedList like the
     * other LinkedList problems, for 2 reasons:
     * 
     * 1. My implementation of LinkedList is a DoublyLinkedList, which complicates
     * sharing nodes between 2 lists.
     * 
     * 2. My implementation uses the sentinnel pattern, so a head or a tail node
     * cannot be shared between 2 lists.
     */
    public Node<K> intersection(Node<K> head1, Node<K> head2) {
        Node<K> current1 = adjustHead(head1, head2);
        Node<K> current2 = adjustHead(head2, head1);
        return getFirstIntersectingNode(current1, current2);
    }

    /**
     * Returns longer advanced by the length difference between longer and shorter
     * if longer is indeed longer than shorter, otherwise returns longer.
     */
    private Node<K> adjustHead(Node<K> longer, Node<K> shorter) {
        int lengthDifference = getLength(longer) - getLength(shorter);
        if (lengthDifference <= 0) {
            return longer;
        }
        return advance(longer, lengthDifference);
    }

    private int getLength(Node<K> head) {
        int result = 0;
        Node<K> node = head;
        while (node != null) {
            result++;
            node = node.next;
        }
        return result;
    }

    private Node<K> advance(Node<K> head, int advanceCount) {
        Node<K> result = head;
        for (int i = 0; i < advanceCount; i++) {
            result = result.next;
        }
        return result;
    }

    private Node<K> getFirstIntersectingNode(Node<K> head1, Node<K> head2) {
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

}
