package ru.mts.hw3;
/**
 * Главный класс приложения для демонстрации создания уникальных животных.
 */
public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl createAnimalService = new CreateAnimalServiceImpl();
        System.out.println("Создание 10 уникальных животных по умолчанию: ");
        createAnimalService.createUniqueAnimals();
        System.out.println("==========================================================================");
        System.out.println("Создание 5 уникальных животных:");
        createAnimalService.createUniqueAnimals(5);

    }
}