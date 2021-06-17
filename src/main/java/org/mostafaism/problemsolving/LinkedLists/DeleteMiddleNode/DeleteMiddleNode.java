package org.mostafaism.problemsolving.LinkedLists.DeleteMiddleNode;

import org.mostafaism.problemsolving.datastructure.LinkedList.Node;

public class DeleteMiddleNode<K> {

    public void deleteMiddleNode(Node<K> node) {
        node.key = node.next.key;
        node.next = node.next.next;
    }

}
