package org.mostafaism.problemsolving.LinkedLists.DeleteMiddleNode;

import org.mostafaism.problemsolving.datastructure.LinkedList.Node;

public class DeleteMiddleNode<K> {

    /**
     * Deletes node from its list.
     * 
     * @param node the node to be deleted; must be a middle node, with a node before
     *             and a node after
     */
    public void deleteMiddleNode(Node<K> node) {
        node.key = node.next.key;
        node.next = node.next.next;
    }

}
