package ru.mts.hw3;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    /**
     * Создать и вывести 10 уникальных животных по умолчанию.
     */
    public void createUniqueAnimals() {
        int animalCounter = 0;
        CreateOneUniqueAnimal a = new CreateOneUniqueAnimal();
        do {
            System.out.println(a.createOneUniqueAnimal());
            animalCounter++;
        } while (animalCounter < 10);
    }
    /**
     * Создать и вывести указанное количество уникальных животных.
     *
     * @param n Количество животных для создания.
     */
    public void createUniqueAnimals(int n) {
        CreateOneUniqueAnimal a = new CreateOneUniqueAnimal();
        for (int i = 0; i < n; i++) {
            System.out.println(a.createOneUniqueAnimal());
        }
    }


}
