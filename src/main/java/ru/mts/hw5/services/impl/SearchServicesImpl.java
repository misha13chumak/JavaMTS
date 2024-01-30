package ru.mts.hw5.services.impl;

import ru.mts.hw5.abstraction.Animal;
import ru.mts.hw5.services.SearchService;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
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
    public Animal[] findDuplicate(Animal[] animals) {
        if (animals == null) {
            throw new IllegalArgumentException("Массив животных не может быть null");
        }

        Map<String, List<Animal>> nameToAnimalsMap = new HashMap<>();

        for (Animal animal : animals) {
            if (animal != null) {
                String name = animal.getName();
                List<Animal> animalsWithSameName = nameToAnimalsMap.computeIfAbsent(name, k -> new ArrayList<>());
                animalsWithSameName.add(animal);
            }
        }

        List<Animal> duplicates = new ArrayList<>();

        for (List<Animal> animalList : nameToAnimalsMap.values()) {
            if (animalList.size() > 1) {
                duplicates.addAll(animalList);
            }
        }

        return duplicates.toArray(new Animal[0]);
    }

    /**
     * Выводит дубликаты животных с одинаковыми именами в предоставленном массиве.
     *
     * @param animals Массив животных, не должен быть null.
     * @throws IllegalArgumentException Если массив животных равен null.
     */
    public void printDuplicate(Animal[] animals) {
        System.out.println("=================================================================================");
        Animal[] duplicateAnimals = findDuplicate(animals);
        for (Animal animal : duplicateAnimals) {
            System.out.println(animal.getName() + " - " + animal.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }
        System.out.println("=================================================================================");
    }

}