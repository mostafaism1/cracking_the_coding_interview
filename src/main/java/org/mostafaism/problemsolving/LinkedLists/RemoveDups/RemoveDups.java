package org.mostafaism.problemsolving.LinkedLists.RemoveDups;

import org.mostafaism.problemsolving.datastructure.LinkedList.LinkedList;
import org.mostafaism.problemsolving.datastructure.LinkedList.Node;

public class RemoveDups {

    public void removeDups(LinkedList<Integer> list) {
        Node<Integer> current = list.getHead();
        while (!list.isNil(current)) {
            removeDupsOfNode(list, current);
            current = current.next;
        }
    }

    /**
     * Removes any nodes after n with a key equal to n.key.
     * 
     * @param list the list which n belongs to
     * @param n    the node whose key we want to check for duplicates
     */
    private void removeDupsOfNode(LinkedList<Integer> list, Node<Integer> n) {
        Node<Integer> runner = n.next;
        while (!list.isNil(runner)) {
            if (runner.key == n.key) {
                list.remove(runner);
            }
            runner = runner.next;
        }
    }

}
