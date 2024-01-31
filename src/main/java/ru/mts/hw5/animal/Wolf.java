package ru.mts.hw5.animal;

import ru.mts.hw5.abstraction.Predator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 * Класс, представляющий собой волка. Наследуется от класса Predator.
 */
public class Wolf extends Predator {

    /**
     * Конструктор класса Wolf.
     *
     * @param breed     Порода волка.
     * @param name      Имя волка.
     * @param cost      Стоимость волка.
     * @param character Характер волка.
     * @param birthDate День рождения волка.
     */
    public Wolf(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        super(breed, name, cost.setScale(2, RoundingMode.HALF_UP), character, birthDate);
    }

    /**
     * Конструктор класса Wolf.
     *
     * @param breed     Порода волка.
     * @param name      Имя волка.
     * @param cost      Стоимость волка.
     * @param birthDate День рождения волка.
     */
    public Wolf(String breed, String name, BigDecimal cost, LocalDate birthDate) {
        super(breed, name, cost.setScale(2, RoundingMode.HALF_UP), "Friendly", birthDate);
    }

    /**
     * Метод toString для получения строкового представления волка.
     *
     * @return Строковое представление волка.
     */
    @Override
    public String toString() {
        return "Wolf{" +
                "порода='" + getBreed() + '\'' +
                ", имя='" + getName() + '\'' +
                ", стоимость=" + getCost() +
                ", характер='" + getCharacter() + '\'' +
                ", дата рождения='" + getBirthDate() + '\'' +
                "}"  + "\n";
    }
}
