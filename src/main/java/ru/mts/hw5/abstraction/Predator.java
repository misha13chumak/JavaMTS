package ru.mts.hw5.abstraction;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Абстрактный класс, представляющий собой хищника.
 * Наследуется от AbstractAnimal.
 */
public abstract class Predator extends AbstractAnimal {

    /**
     * Конструктор.
     *
     * @param breed      Порода хищника.
     * @param name       Имя хищника.
     * @param cost       Стоимость хищника.
     * @param character  Характер хищника.
     * @param birthDate  День рождения хищника.
     */
    public Predator(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
