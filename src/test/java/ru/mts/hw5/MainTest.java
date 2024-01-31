package ru.mts.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.mts.hw5.abstraction.AbstractAnimal;
import ru.mts.hw5.abstraction.Animal;
import ru.mts.hw5.animal.Cat;
import ru.mts.hw5.animal.Dog;
import ru.mts.hw5.services.SearchService;
import ru.mts.hw5.services.impl.SearchServicesImpl;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


class MainTest {

    @Nested
    class AnimalEqualsTest {
        private final Cat cat1 = new Cat("Siamese", "Chipa", BigDecimal.valueOf(5000), "Kind", LocalDate.of(2010, 3, 10));
        private final Cat cat2 = new Cat("Siamese", "Chipa", BigDecimal.valueOf(5000), "Kind", LocalDate.of(2010, 3, 10));
        private final Cat cat3 = new Cat("Siamese", "Chipa", BigDecimal.valueOf(5000), "Kind", LocalDate.of(2010, 3, 10));

        @Test
        @DisplayName("Проверка правильности переопределения метода equals в классе AbstractAnimal")
        void testEqualsOverride() throws NoSuchMethodException {
            Class<?> expectedClass = AbstractAnimal.class;

            // Получение класса
            Class<?> animalClass = AbstractAnimal.class;

            // Проверка наличия самого метода equals
            Method equalsMethod = animalClass.getMethod("equals", Object.class);
            assertNotNull(equalsMethod);

            // Получение реального класса, который объявил метод equals
            Class<?> declaringClass = equalsMethod.getDeclaringClass();

            // Проверка соответствия ожидаемого и реального класса
            assertEquals(expectedClass, declaringClass);
        }

        @Test
        @DisplayName("Проверка симметричности метода equals в классе AbstractAnimal")
        void testEqualsSymmetry() {
            Assertions.assertEquals(cat1, cat2);
            Assertions.assertEquals(cat2, cat1);
        }

        @Test
        @DisplayName("Проверка транзитивности метода equals в классе AbstractAnimal")
        void testEqualsTransitive() {
            Assertions.assertEquals(cat1, cat2);
            Assertions.assertEquals(cat2, cat3);
            Assertions.assertEquals(cat1, cat3);
        }

        @Test
        @DisplayName("Проверка консистентности метода equals в классе AbstractAnimal")
        void testEqualsConsistent() {
            Assertions.assertEquals(cat1, cat2);
            Assertions.assertEquals(cat1, cat2);
        }

        @Test
        @DisplayName("Проверка непустого объекта в методе equals класса AbstractAnimal")
        void testEqualsNullComparison() {
            Assertions.assertNotEquals(null, cat3);
        }
    }

    @Nested
    class SearchServicesImplTest {

        @Test
        @DisplayName("Тест метода findLeapYearNames в классе SearchServicesImpl")
        void testFindLeapYearNames() {
            Animal cat = new Cat("Siamese", "Whiskers", BigDecimal.valueOf(100), "Friendly", LocalDate.of(2024, 1, 1));
            Animal dog = new Dog("Terrier", "Buddy", BigDecimal.valueOf(120), "Playful", LocalDate.of(2023, 1, 1));

            Animal[] animals = {cat, dog};
            SearchService searchService = new SearchServicesImpl();
            String[] leapYearNames = searchService.findLeapYearNames(animals);

            assertArrayEquals(new String[]{"Whiskers"}, leapYearNames);
        }

        @ParameterizedTest
        @ValueSource(ints = {5, 10, 15})
        @DisplayName("Тест метода findOlderAnimal в классе SearchServicesImpl")
        void testFindOlderAnimal(int age) {
            Animal cat = new Cat("Siamese", "Whiskers", BigDecimal.valueOf(100), "Friendly", LocalDate.now().minusYears(age));
            Animal dog = new Dog("Terrier", "Buddy", BigDecimal.valueOf(120), "Playful", LocalDate.now().minusYears(age - 1));

            Animal[] animals = {cat, dog};
            SearchService searchService = new SearchServicesImpl();
            Animal[] olderAnimals = searchService.findOlderAnimal(animals, age);

            assertArrayEquals(new Animal[]{cat}, olderAnimals);
        }

        @Test
        @DisplayName("Тест метода findDuplicate в классе SearchServicesImpl")
        void testFindDuplicate() {
            // Create an array with animals, some having the same name
            Animal[] animalsWithDuplicates = {new Cat("Siamese", "Chipa", BigDecimal.valueOf(5000), "Kind", LocalDate.of(2015, 3, 11)), new Cat("Siamese", "Lili", BigDecimal.valueOf(4000), "Kind", LocalDate.of(2020, 5, 14)), new Cat("Siamese", "Boba", BigDecimal.valueOf(5500), "Kind", LocalDate.of(2017, 9, 16)), new Cat("Siamese", "Chipa", BigDecimal.valueOf(6000), "Kind", LocalDate.of(2013, 1, 19))};

            SearchServicesImpl searchService = new SearchServicesImpl();

            Animal[] duplicateAnimals = searchService.findDuplicate(animalsWithDuplicates);

            assertEquals(2, duplicateAnimals.length);

            assertEquals("Chipa", duplicateAnimals[0].getName());
            assertEquals("Chipa", duplicateAnimals[1].getName());

        }
    }
}

