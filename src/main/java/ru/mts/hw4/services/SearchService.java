package ru.mts.hw4.services;

import ru.mts.hw4.abstraction.Animal;

public interface SearchService {

    String[] findLeapYearNames(Animal[] animals);
    Animal[] findOlderAnimal(Animal[] animals, int age);
    Animal[] findDuplicate(Animal[] animals);
}