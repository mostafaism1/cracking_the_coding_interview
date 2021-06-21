package org.mostafaism.problemsolving.StacksAndQueues.AnimalShelter;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DefaultAnimalShelterQueueTest {

    private AnimalShelterQueue queue;

    @BeforeEach
    void setup() {
        queue = new DefaultAnimalShelterQueue();
    }

    @Test
    void givenEmptyQueue_whenDequeueAny_ThenThrowException() {
        // given

        // when, then
        thenThrownBy(() -> queue.dequeueAny()).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void givenEmptyQueue_whenDequeueDog_ThenThrowException() {
        // given

        // when, then
        thenThrownBy(() -> queue.dequeueDog()).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void givenEmptyQueue_whenDequeueCat_ThenThrowException() {
        // given

        // when, then
        thenThrownBy(() -> queue.dequeueCat()).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void givenQueueWithOneDog_whenDequeueAny_ThenReturnDog() {
        // given
        ShelterAnimal dog = new Dog("Dog");
        queue.enqueue(dog);

        // when
        ShelterAnimal actual = queue.dequeueAny();

        // then
        then(actual).isEqualTo(dog);
    }

    @Test
    void givenQueueWithOneDog_whenDequeueDog_ThenReturnDog() {
        // given
        ShelterAnimal dog = new Dog("Dog");
        queue.enqueue(dog);

        // when
        ShelterAnimal actual = queue.dequeueDog();

        // then
        then(actual).isEqualTo(dog);
    }

    @Test
    void givenQueueWithOneDog_whenDequeueCat_ThenThrowException() {
        // given
        ShelterAnimal dog = new Dog("Dog");
        queue.enqueue(dog);

        // when, then
        thenThrownBy(() -> queue.dequeueCat()).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void givenQueueWithOneCat_whenDequeueAny_ThenReturnCat() {
        // given
        ShelterAnimal cat = new Cat("Cat");
        queue.enqueue(cat);

        // when
        ShelterAnimal actual = queue.dequeueAny();

        // then
        then(actual).isEqualTo(cat);
    }

    @Test
    void givenQueueWithOneCat_whenDequeueCat_ThenThrowException() {
        // given
        ShelterAnimal cat = new Cat("Cat");
        queue.enqueue(cat);

        // when
        ShelterAnimal actual = queue.dequeueCat();

        // then
        then(actual).isEqualTo(cat);
    }

    @Test
    void givenQueueWithOneCat_whenDequeueDog_ThenThrowException() {
        // given
        ShelterAnimal cat = new Cat("Cat");
        queue.enqueue(cat);

        // when, then
        thenThrownBy(() -> queue.dequeueDog()).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void givenQueueWithDogThenCat_whenDequeueAny_ThenReturnDog() {
        // given
        ShelterAnimal dog = new Dog("Dog");
        ShelterAnimal cat = new Cat("Cat");
        queue.enqueue(dog);
        queue.enqueue(cat);

        // when
        ShelterAnimal actual = queue.dequeueAny();

        // then
        then(actual).isEqualTo(dog);
    }

    @Test
    void givenQueueWithDogThenCat_whenDequeueDog_ThenReturnDog() {
        // given
        ShelterAnimal dog = new Dog("Dog");
        ShelterAnimal cat = new Cat("Cat");
        queue.enqueue(dog);
        queue.enqueue(cat);

        // when
        ShelterAnimal actual = queue.dequeueDog();

        // then
        then(actual).isEqualTo(dog);
    }

    @Test
    void givenQueueWithDogThenCat_whenDequeueCat_ThenReturnCat() {
        // given
        ShelterAnimal dog = new Dog("Dog");
        ShelterAnimal cat = new Cat("Cat");
        queue.enqueue(dog);
        queue.enqueue(cat);

        // when
        ShelterAnimal actual = queue.dequeueCat();

        // then
        then(actual).isEqualTo(cat);
    }

}
