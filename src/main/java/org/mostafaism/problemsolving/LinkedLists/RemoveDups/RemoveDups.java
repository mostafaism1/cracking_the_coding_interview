package org.mostafaism.problemsolving.LinkedLists.RemoveDups;

import org.mostafaism.problemsolving.datastructure.LinkedList.LinkedList;
import org.mostafaism.problemsolving.datastructure.LinkedList.Node;

public class RemoveDups {

    public void removeDups(LinkedList<Integer> list) {
        Node<Integer> n = list.getHead();
        while (!list.isNil(n)) {
            removeDupsOfNode(list, n);
            n = n.next;
        }
    }

    /**
     * Removes any nodes after n with a key equal to n.
     * 
     * @param list the list which n belongs to
     * @param n    the node whose key we want to check for duplicates
     */
    private void removeDupsOfNode(LinkedList<Integer> list, Node<Integer> n) {
        Node<Integer> m = n.next;
        while (!list.isNil(m)) {
            if (m.key == n.key) {
                list.remove(m);
            }
            m = m.next;
        }
    }

}
