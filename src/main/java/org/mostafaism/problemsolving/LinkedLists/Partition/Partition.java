package org.mostafaism.problemsolving.LinkedLists.Partition;

import org.mostafaism.problemsolving.datastructure.LinkedList.LinkedList;

public class Partition<K extends Comparable<K>> {

    public void partition(LinkedList<K> list, K partitionValue) {
        var runner = list.getHead();
        while (!list.isNil(runner)) {
            var next = runner.next;
            if (runner.key.compareTo(partitionValue) < 0) {
                list.remove(runner);
                list.add(runner);
            }
            runner = next;
        }
    }

}
