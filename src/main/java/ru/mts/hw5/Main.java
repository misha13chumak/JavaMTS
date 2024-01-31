package ru.mts.hw5;

import ru.mts.hw5.abstraction.Animal;
import ru.mts.hw5.services.CreateAnimalService;
import ru.mts.hw5.services.SearchService;
import ru.mts.hw5.services.impl.CreateAnimalServiceImpl;
import ru.mts.hw5.services.impl.SearchServicesImpl;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int MIN_YEARS_FOR_FIND_OLDER = 5;
        CreateAnimalService createAnimalService = new CreateAnimalServiceImpl();
        SearchService searchService = new SearchServicesImpl();

        // Создать 10 уникальных животных
        Animal[] animals = createAnimalService.createUniqueAnimals();

        // Вывести имена, рожденные в високосные года
        String[] leapYearNames = searchService.findLeapYearNames(animals);
        System.out.println("=================================================================================");
        System.out.println("Животные, рожденные в високосный год: " + String.join(", ", leapYearNames));
        System.out.println("=================================================================================");

        // Вывести животных старше 5 лет
        Animal[] olderAnimals = searchService.findOlderAnimal(animals, MIN_YEARS_FOR_FIND_OLDER);
        System.out.println("Животные старше 5 лет: ");
        for (Animal animal : olderAnimals) {
            System.out.println(animal.getName() + " - " + animal.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }

        // Поиск дубликатов среди 10 уникальных животных
        Animal[] animalsArrayWithDuplicate = createAnimalService.createUniqueAnimals(10, 1);
        searchService.printDuplicate(animalsArrayWithDuplicate);
    }
}
