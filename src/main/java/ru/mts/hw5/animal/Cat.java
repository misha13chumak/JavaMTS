package ru.mts.hw5.animal;

import ru.mts.hw5.abstraction.Pet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 * Класс, представляющий собой кошку. Наследуется от класса Pet.
 */
public class Cat extends Pet {

    /**
     * Конструктор класса Cat.
     *
     * @param breed     Порода кошки.
     * @param name      Имя кошки.
     * @param cost      Стоимость кошки.
     * @param character Характер кошки.
     * @param birthDate День рождения кошки.
     */
    public Cat(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        super(breed, name, cost.setScale(2, RoundingMode.HALF_UP), character, birthDate);
    }

    /**
     * Конструктор класса Cat.
     *
     * @param breed     Порода кошки.
     * @param name      Имя кошки.
     * @param cost      Стоимость кошки.
     * @param birthDate День рождения кошки.
     */
    public Cat(String breed, String name, BigDecimal cost, LocalDate birthDate) {
        super(breed, name, cost.setScale(2, RoundingMode.HALF_UP), "Friendly", birthDate);
    }

    /**
     * Метод toString для получения строкового представления кошки.
     *
     * @return Строковое представление кошки.
     */
    @Override
    public String toString() {
        return "Cat{" +
                "порода='" + getBreed() + '\'' +
                ", имя='" + getName() + '\'' +
                ", стоимость=" + getCost() +
                ", характер='" + getCharacter() + '\'' +
                ", дата рождения='" + getBirthDate() + '\'' +
                '}' + "\n";
    }

}
