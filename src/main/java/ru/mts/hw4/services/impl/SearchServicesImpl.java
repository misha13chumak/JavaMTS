package ru.mts.hw4.services.impl;

import ru.mts.hw4.abstraction.Animal;
import ru.mts.hw4.services.SearchService;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;


public class SearchServicesImpl implements SearchService {



    /**
     * Находит имена животных, рожденных в високосные года.
     *
     * @param animals Массив животных, не должен быть null.
     * @return Массив имен животных, рожденных в високосные года.
     * @throws IllegalArgumentException Если массив животных равен null.
     */
    @Override
    public String[] findLeapYearNames(Animal[] animals) {
        if (animals == null) {
            throw new IllegalArgumentException("Массив животных не может быть null");
        }

        List<String> leapYearNames = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal != null && animal.getBirthDate() != null && animal.getBirthDate().isLeapYear()) {
                leapYearNames.add(animal.getName());
            }
        }

        return leapYearNames.toArray(new String[0]);
    }

    /**
     * Находит животных, которым больше или равно указанное количество лет.
     *
     * @param animals Массив животных, не должен быть null.
     * @param age     Возраст, который необходимо проверить.
     * @return Массив животных старше или равных указанному возрасту.
     * @throws IllegalArgumentException Если массив животных равен null.
     */
    @Override
    public Animal[] findOlderAnimal(Animal[] animals, int age) {
        if (animals == null) {
            throw new IllegalArgumentException("Массив животных не может быть null");
        }

        List<Animal> olderAnimals = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal != null && animal.getBirthDate() != null) {
                int animalAge = Period.between(animal.getBirthDate(), LocalDate.now()).getYears();

                if (animalAge >= age) {
                    olderAnimals.add(animal);
                }
            }
        }

        return olderAnimals.toArray(new Animal[0]);
    }

    /**
     * Находит животных с одинаковыми именами в предоставленном массиве.
     *
     * @param animals Массив животных, не должен быть null.
     * @return Массив животных с дублирующимися именами.
     * @throws IllegalArgumentException Если массив животных равен null.
     */
    public void findDuplicate(Animal[] animals) {
        if (animals == null) {
            throw new IllegalArgumentException("Массив животных не может быть null");
        }

        Map<String, Integer> nameCountMap = new HashMap<>();

        for (Animal animal : animals) {
            if (animal != null) {
                String name = animal.getName();
                int count = nameCountMap.getOrDefault(name, 0);
                nameCountMap.put(name, count + 1);
            }
        }

        boolean duplicatesFound = false;

        for (Map.Entry<String, Integer> entry : nameCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicatesFound = true;
                System.out.println(entry.getKey() + " - количество дубликатов: " + entry.getValue());
            }
        }

        if (!duplicatesFound) {
            System.out.println("Дубликатов не найдено");
        }
    }

}