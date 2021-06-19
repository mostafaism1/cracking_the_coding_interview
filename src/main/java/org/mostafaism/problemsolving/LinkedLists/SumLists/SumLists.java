package org.mostafaism.problemsolving.LinkedLists.SumLists;

import org.mostafaism.problemsolving.datastructure.LinkedList.DoublyLinkedList;
import org.mostafaism.problemsolving.datastructure.LinkedList.LinkedList;
import org.mostafaism.problemsolving.datastructure.LinkedList.Node;

public class SumLists {

    public LinkedList<Integer> sumLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        padShorterList(list1, list2);
        PartialSum result = sumListsHelper(list1, list2, list1.getHead(), list2.getHead());
        if (result.carry() != 0) {
            result.sum().add(new Node<>(result.carry()));
        }
        return result.sum();
    }

    private void padShorterList(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        int difference = list1.size() - list2.size();
        if (difference > 0) {
            padFront(list2, difference);
        } else {
            padFront(list1, -difference);
        }
    }

    private void padFront(LinkedList<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.add(new Node<>(0));
        }
    }

    private PartialSum sumListsHelper(LinkedList<Integer> list1, LinkedList<Integer> list2, Node<Integer> head1,
            Node<Integer> head2) {
        // base case
        if (list1.isNil(head1) && list2.isNil(head2)) {
            return new PartialSum(new DoublyLinkedList<>(), 0);
        }

        // recursive step
        PartialSum partialSum = sumListsHelper(list1, list2, head1.next, head2.next);
        int SumUnitsAndTens = head1.key + head2.key + partialSum.carry();
        int sumUnits = SumUnitsAndTens % 10;
        int carry = SumUnitsAndTens / 10;
        partialSum.sum().add(new Node<>(sumUnits));
        return new PartialSum(partialSum.sum(), carry);
    }

    private static record PartialSum(LinkedList<Integer> sum, int carry) {
    }

}
