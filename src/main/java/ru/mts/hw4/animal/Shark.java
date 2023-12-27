package ru.mts.hw4.animal;

import ru.mts.hw4.abstraction.Predator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 * Класс, представляющий собой акулу. Наследуется от класса Predator.
 */
public class Shark extends Predator {

    /**
     * Конструктор класса Shark.
     *
     * @param breed     Порода акулы.
     * @param name      Имя акулы.
     * @param cost      Стоимость акулы.
     * @param character Характер акулы.
     * @param birthDate День рождения акулы.
     */
    public Shark(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        super(breed, name, cost.setScale(2, RoundingMode.HALF_UP), character, birthDate);
    }

    /**
     * Конструктор класса Shark.
     *
     * @param breed     Порода акулы.
     * @param name      Имя акулы.
     * @param cost      Стоимость акулы.
     * @param birthDate День рождения акулы.
     */
    public Shark(String breed, String name, BigDecimal cost, LocalDate birthDate) {
        super(breed, name, cost.setScale(2, RoundingMode.HALF_UP), "Friendly", birthDate);
    }

    /**
     * Метод toString для получения строкового представления акулы.
     *
     * @return Строковое представление акулы.
     */
    @Override
    public String toString() {
        return "Shark{" +
                "порода='" + getBreed() + '\'' +
                ", имя='" + getName() + '\'' +
                ", стоимость=" + getCost() +
                ", характер='" + getCharacter() + '\'' +
                ", дата рождения='" + getBirthDate() + '\'' +
                '}' + "\n";
    }

}
