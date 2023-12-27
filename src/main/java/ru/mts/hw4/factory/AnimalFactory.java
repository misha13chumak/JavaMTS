package ru.mts.hw4.factory;

import ru.mts.hw4.abstraction.Animal;
import ru.mts.hw4.animal.Cat;
import ru.mts.hw4.animal.Dog;
import ru.mts.hw4.animal.Shark;
import ru.mts.hw4.animal.Wolf;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

/**
 * Класс для создания одного уникального животного с случайными характеристиками.
 */
public class AnimalFactory {

    // Максимальное количество лет в прошлом для генерации случайной даты рождения.
    private static final int MAX_YEARS_IN_PAST = 20;

    // Количество месяцев в году.
    private static final int MONTHS_IN_YEAR = 12;

    // Максимальное количество типов характеров животных.
    private static final int MAX_COUNT_CHARACTER = 5;

    // Максимальное количество пород для животных.
    private static final int MAX_COUNT_BREED_ANIMAL = 10;

    // Возможные характеры животных.
    private static final String[] CHARACTERS = {"Friendly", "Playful", "Aggressive", "Calm", "Energetic"};

    /**
     * Создать одно уникальное животное.
     *
     * @param type Тип животного.
     * @return Экземпляр животного.
     * @throws IllegalArgumentException если передан неизвестный тип животного.
     */
    public Animal createAnimal(AnimalTypes type) {
        String breed = generateRandomBreed(type);
        String name = generateRandomName();
        BigDecimal cost = generateRandomCost();
        LocalDate birthDate = generateRandomBirthDate();
        String character = generateRandomCharacter();

        switch (type) {
            case Cat:
                return new Cat(breed, name, cost, character, birthDate);
            case Dog:
                return new Dog(breed, name, cost, character, birthDate);
            case Shark:
                return new Shark(breed, name, cost, character, birthDate);
            case Wolf:
                return new Wolf(breed, name, cost, character, birthDate);
            default:
                throw new IllegalArgumentException("Unknown animal type: " + type);
        }
    }

    /**
     * Генерирует случайную породу для различных типов животных.
     *
     * @param type тип животного.
     * @return Случайная порода.
     */
    private String generateRandomBreed(AnimalTypes type) {
        Random random = new Random();
        switch (type) {
            case Dog:
                String[] dogBreeds = {"Terrier", "Boxer", "Bolognese", "Bulldog", "Chihuahua", "Collie", "Mops",
                        "Spitz", "Labrador", "Mastiff"};
                return dogBreeds[random.nextInt(MAX_COUNT_BREED_ANIMAL)];
            case Cat:
                String[] catBreeds = {"Siamese", "Persian", "Sphynx", "Asian", "Bengal", "Burmilla", "Foldex",
                        "German Rex", "Kinkalow", "Minskin"};
                return catBreeds[random.nextInt(MAX_COUNT_BREED_ANIMAL)];
            case Shark:
                String[] sharkBreeds = {"Dogfish", "Angel", "Sawsharks", "Bullhead", "Carpet", "Ground", "Bali catshark",
                        "Blind", "Blue", "Borneo"};
                return sharkBreeds[random.nextInt(MAX_COUNT_BREED_ANIMAL)];
            case Wolf:
                String[] wolfBreeds = {"Tundra", "Arabian", "Steppe", "Himalayan", "Mongolian", "Eurasian", "Indian",
                        "Arctic", "Mexican", "Eastern"};
                return wolfBreeds[random.nextInt(MAX_COUNT_BREED_ANIMAL)];
            default:
                return null;
        }
    }

    /**
     * Генерирует случайное имя для животного.
     *
     * @return Случайное имя.
     */
    private String generateRandomName() {
        Random random = new Random();
        String[] possibleNames = {"Buddy", "Whiskers", "Fang", "Shadow", "Luna", "Rex", "Misty", "Rocky", "Cleo", "Thor"};
        return possibleNames[random.nextInt(possibleNames.length)];
    }

    /**
     * Генерирует случайную стоимость для животного.
     *
     * @return Случайная стоимость в формате BigDecimal.
     */
    private BigDecimal generateRandomCost() {
        Random random = new Random();
        return BigDecimal.valueOf(random.nextDouble() * 50000.0);
    }

    /**
     * Генерирует случайный характер для животного.
     *
     * @return Случайный характер.
     */
    private String generateRandomCharacter() {
        return CHARACTERS[new Random().nextInt(MAX_COUNT_CHARACTER)];
    }

    /**
     * Генерирует случайную дату рождения для животного.
     *
     * @return Случайная дата рождения.
     */
    private LocalDate generateRandomBirthDate() {
        Random random = new Random();

        int randomYears = random.nextInt(MAX_YEARS_IN_PAST);

        int randomMonth = random.nextInt(MONTHS_IN_YEAR) + 1;
        int maxDaysInMonth = LocalDate.of(2023, randomMonth, 1).lengthOfMonth();
        int randomDay = random.nextInt(maxDaysInMonth) + 1;

        return LocalDate.now().minusYears(randomYears).minusMonths(randomMonth).minusDays(randomDay);
    }
}

