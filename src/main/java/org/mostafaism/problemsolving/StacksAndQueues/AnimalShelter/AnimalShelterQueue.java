package org.mostafaism.problemsolving.StacksAndQueues.AnimalShelter;

public interface AnimalShelterQueue {
    void enqueue(ShelterAnimal animal);

    ShelterAnimal dequeueAny();

    Dog dequeueDog();

    Cat dequeueCat();
}
