package ru.mts.hw4.services;


import ru.mts.hw4.abstraction.Animal;
import ru.mts.hw4.factory.AnimalFactory;

import java.util.Random;

import static ru.mts.hw4.factory.AnimalTypes.*;

/**
 * Реализация интерфейса CreateAnimalService для создания уникальных животных.
 */
public interface CreateAnimalService {
    int MAX_COUNT_TYPE_ANIMAL = 4;
    /**
     * Создать и вывести 10 уникальных животных по умолчанию.
     *
     * @return
     */
    default Animal[] createUniqueAnimals() {
        int animalCounter = 0;
        AnimalFactory animalFactory = new AnimalFactory();
        Animal[] animals = new Animal[10];
        while (animalCounter < 10) {
            Random random = new Random();
            int randomNum = random.nextInt(MAX_COUNT_TYPE_ANIMAL);
            switch (randomNum) {
                case 0:
                    animals[animalCounter] = animalFactory.createAnimal(Cat);
                    break;
                case 1:
                    animals[animalCounter] = animalFactory.createAnimal(Dog);
                    break;
                case 2:
                    animals[animalCounter] = animalFactory.createAnimal(Shark);
                    break;
                case 3:
                    animals[animalCounter] = animalFactory.createAnimal(Wolf);
                    break;
            }
            animalCounter++;
        }
        return animals;
    }

    Animal[] createUniqueAnimals(int n);

    Animal[] createUniqueAnimals(int n, int duplicateNum);
}