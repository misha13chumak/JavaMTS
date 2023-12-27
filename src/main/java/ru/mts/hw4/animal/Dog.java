package ru.mts.hw4.animal;

import ru.mts.hw4.abstraction.Pet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 * Класс, представляющий собой собаку. Наследуется от класса Pet.
 */
public class Dog extends Pet {

    /**
     * Конструктор класса Dog.
     *
     * @param breed     Порода собаки.
     * @param name      Имя собаки.
     * @param cost      Стоимость собаки.
     * @param character Характер собаки.
     * @param birthDate День рождения собаки.
     */
    public Dog(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        super(breed, name, cost.setScale(2, RoundingMode.HALF_UP), character, birthDate);
    }
    /**
     * Конструктор класса Dog.
     *
     * @param breed     Порода собаки.
     * @param name      Имя собаки.
     * @param cost      Стоимость собаки.
     * @param birthDate День рождения собаки.
     */
    public Dog(String breed, String name, BigDecimal cost, LocalDate birthDate) {
        super(breed, name, cost.setScale(2, RoundingMode.HALF_UP), "Friendly", birthDate);
    }

    /**
     * Метод toString для получения строкового представления собаки.
     *
     * @return Строковое представление собаки.
     */
    @Override
    public String toString() {
        return "Dog{" +
                "порода='" + getBreed() + '\'' +
                ", имя='" + getName() + '\'' +
                ", стоимость=" + getCost() +
                ", характер='" + getCharacter() + '\'' +
                ", дата рождения='" + getBirthDate() + '\'' +
                '}' + "\n";
    }
}
