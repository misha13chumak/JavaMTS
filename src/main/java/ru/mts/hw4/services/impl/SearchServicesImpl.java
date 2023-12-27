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
    @Override
    public Animal[] findDuplicate(Animal[] animals) {
        if (animals == null) {
            throw new IllegalArgumentException("Массив животных не может быть null");
        }

        Set<String> uniqueNames = new HashSet<>();
        Set<String> duplicateNames = new HashSet<>();

        for (Animal animal : animals) {
            if (animal != null) {
                if (!uniqueNames.add(animal.getName())) {
                    duplicateNames.add(animal.getName());
                }
            }
        }

        if (!duplicateNames.isEmpty()) {
            System.out.println("Имена дубликатов животных: " + duplicateNames);
        } else {
            System.out.println("Дубликатов не найдено");
        }

        return duplicateNames.stream()
                .map(name -> Arrays.stream(animals)
                        .filter(animal -> animal != null && animal.getName().equals(name))
                        .findFirst()
                        .orElse(null))
                .toArray(Animal[]::new);
    }
}