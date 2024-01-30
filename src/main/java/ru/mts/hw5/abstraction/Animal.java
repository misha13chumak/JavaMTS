package ru.mts.hw5.abstraction;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Интерфейс, определяющий основные характеристики животных.
 */
public interface Animal {

    /**
     * Получить породу животного.
     *
     * @return Порода животного.
     */
    String getBreed();

    /**
     * Получить имя животного.
     *
     * @return Имя животного.
     */
    String getName();

    /**
     * Получить стоимость животного.
     *
     * @return Стоимость животного в формате BigDecimal.
     */
    BigDecimal getCost();

    /**
     * Получить характер животного.
     *
     * @return Характер животного.
     */
    String getCharacter();

    /**
     * Получить день рождение.
     *
     * @return День рождение животного.
     */
    LocalDate getBirthDate();
}
