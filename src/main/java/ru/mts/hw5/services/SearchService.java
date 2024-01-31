package ru.mts.hw5.services;

import ru.mts.hw5.abstraction.Animal;

public interface SearchService {

    String[] findLeapYearNames(Animal[] animals);
    Animal[] findOlderAnimal(Animal[] animals, int age);
    Animal[] findDuplicate(Animal[] animals);
    void printDuplicate(Animal[] animals);
}