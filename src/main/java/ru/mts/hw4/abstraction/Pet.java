package ru.mts.hw4.abstraction;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Абстрактный класс, представляющий собой домашнее животное.
 * Наследуется от AbstractAnimal.
 */
public abstract class Pet extends AbstractAnimal {

    /**
     * Конструктор.
     *
     * @param breed      Порода домашнего животного.
     * @param name       Имя домашнего животного.
     * @param cost       Стоимость домашнего животного.
     * @param character  Характер домашнего животного.
     * @param birthDate  День рождения домашнего животного.
     */
    public Pet(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
