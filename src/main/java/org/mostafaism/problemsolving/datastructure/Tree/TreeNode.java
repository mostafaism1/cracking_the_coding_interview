package org.mostafaism.problemsolving.datastructure.Tree;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class TreeNode<E> {
    @Getter
    private E data;
    private List<TreeNode<E>> children;

    public TreeNode(E data) {
        this(data, new ArrayList<>());
    }

    public void addChild(TreeNode<E> treeNode) {
        children.add(treeNode);
    }

    public void removeChild(TreeNode<E> treeNode) {
        children.remove(treeNode);
    }

    public List<TreeNode<E>> getChildren() {
        // Create a defensive copy.
        return new ArrayList<>(children);
    }

}
