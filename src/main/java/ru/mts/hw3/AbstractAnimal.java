package ru.mts.hw3;

import java.math.BigDecimal;
/**
 * Абстрактный класс, представляющий общие характеристики животных.
 * Реализует интерфейс Animal.
 */
public abstract class AbstractAnimal implements Animal {
    /** Порода животного. */
    protected String breed;

    /** Имя животного. */
    protected String name;

    /** Стоимость животного. */
    protected BigDecimal cost;
    /** Характер животного. */
    protected String character;

    /**
     * @return Порода животного.
     */
    @Override
    public String getBreed() {
        return breed;
    }

    /**
     * @return Имя животного.
     */
    @Override
    public String getName() {
        return name;
    }


    /**
     * @return Стоимость животного в формате BigDecimal.
     */
    @Override
    public BigDecimal getCost() {
        return cost;
    }


    /**
     * @return Характер животного.
     */
    @Override
    public String getCharacter() {
        return character;
    }
}
