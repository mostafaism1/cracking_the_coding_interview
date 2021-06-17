package org.mostafaism.problemsolving.LinkedLists.KthToLast;

import org.mostafaism.problemsolving.datastructure.LinkedList.LinkedList;
import org.mostafaism.problemsolving.datastructure.LinkedList.Node;

public class KthToLast<K> {

    public Node<K> kthToLast(LinkedList<K> list, int k) {
        int size = list.size();
        if (k > size - 1) {
            return list.getNil();
        }
        Node<K> result = list.getHead();
        for (int i = 0; i < size - k - 1; i++) {
            if (list.isNil(result)) {
                return result;
            }
            result = result.next;
        }
        return result;
    }

}
