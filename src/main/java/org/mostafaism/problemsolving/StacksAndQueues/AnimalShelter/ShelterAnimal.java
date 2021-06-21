package org.mostafaism.problemsolving.StacksAndQueues.AnimalShelter;

public abstract class ShelterAnimal {
    protected String name;
    private int order;

    public ShelterAnimal(String name) {
        this.name = name;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isOlderThan(ShelterAnimal other) {
        return this.order < other.order;
    }

}
