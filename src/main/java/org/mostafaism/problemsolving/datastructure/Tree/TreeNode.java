package org.mostafaism.problemsolving.datastructure.Tree;

import java.util.ArrayList;
import java.util.List;

public record TreeNode<E> (E data, List<TreeNode<E>> children) {

    public TreeNode(E data) {
        this(data, new ArrayList<>());
    }

}
