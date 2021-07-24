package org.mostafaism.problemsolving.TreesAndGraphs.BuildOrder;

public class NoValidBuildOrderException extends Exception {
    public NoValidBuildOrderException() {
        super("No valid build order due to the existence of a cyclic dependency");
    }
}