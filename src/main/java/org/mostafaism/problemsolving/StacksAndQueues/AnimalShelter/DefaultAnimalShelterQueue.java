package org.mostafaism.problemsolving.StacksAndQueues.AnimalShelter;

import org.mostafaism.problemsolving.datastructure.Queue.DefaultQueue;
import org.mostafaism.problemsolving.datastructure.Queue.Queue;

public class DefaultAnimalShelterQueue implements AnimalShelterQueue {
    /*
     * Unfortunately this implementation makes heavy use of instanceof and static
     * casting, which are, generally speaking, symptoms of bad design. However, in
     * this case their use is a must if we are to have separate queues for Dogs and
     * Cats, and at the same time perform our operations on an abstract
     * ShelterAnimal type.
     */

    private Queue<Dog> dogs;
    private Queue<Cat> cats;
    private int order;

    public DefaultAnimalShelterQueue() {
        dogs = new DefaultQueue<>();
        cats = new DefaultQueue<>();
        order = 0;
    }

    @Override
    public void enqueue(ShelterAnimal animal) {
        animal.setOrder(order++);
        if (animal instanceof Dog) {
            dogs.add((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.add((Cat) animal);
        }
    }

    @Override
    public ShelterAnimal dequeueAny() {
        if (dogs.isEmpty()) {
            return cats.remove();
        }
        if (cats.isEmpty()) {
            return dogs.remove();
        }
        if (dogs.peek().isOlderThan(cats.peek())) {
            return dogs.remove();
        } else {
            return cats.remove();
        }
    }

    @Override
    public Dog dequeueDog() {
        return dogs.remove();
    }

    @Override
    public Cat dequeueCat() {
        return cats.remove();
    }
}
