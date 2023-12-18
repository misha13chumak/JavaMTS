package ru.mts.hw3;
/**
 * Реализация интерфейса CreateAnimalService для создания уникальных животных.
 */
public interface CreateAnimalService {
    /**
     * Создать и вывести 10 уникальных животных по умолчанию.
     */
    default void createUniqueAnimals() {
        int animalCounter = 0;
        CreateOneUniqueAnimal a = new CreateOneUniqueAnimal();
        while (animalCounter < 10) {
            System.out.println(a.createOneUniqueAnimal());
            animalCounter++;
        }

    }


}
