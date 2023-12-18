package ru.mts.hw3;

import java.math.BigDecimal;
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
}
