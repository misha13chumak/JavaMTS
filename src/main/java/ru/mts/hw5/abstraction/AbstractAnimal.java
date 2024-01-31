package ru.mts.hw5.abstraction;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Абстрактный класс, представляющий общие характеристики животных.
 * Реализует интерфейс Animal.
 */
public abstract class AbstractAnimal implements Animal {

    /**
     * Порода животного.
     */
    protected final String breed;

    /**
     * Имя животного.
     */
    protected final String name;

    /**
     * Стоимость животного.
     */
    protected final BigDecimal cost;

    /**
     * Характер животного.
     */
    protected final String character;

    /**
     * День рождение животного.
     */
    protected final LocalDate birthDate;

    /**
     * Конструктор.
     *
     * @param breed     Порода животного.
     * @param name      Имя животного.
     * @param cost      Стоимость животного.
     * @param character Характер животного.
     * @param birthDate День рождения животного.
     */
    public AbstractAnimal(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost.setScale(2, RoundingMode.HALF_UP);
        this.character = character;
        this.birthDate = birthDate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getBreed() {
        return breed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getCharacter() {
        return character;
    }

    /**
     * {@inheritDoc}
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractAnimal that = (AbstractAnimal) obj;
        return Objects.equals(breed, that.breed) &&
                Objects.equals(name, that.name) &&
                Objects.equals(cost, that.cost) &&
                Objects.equals(character, that.character) &&
                Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, name, cost, character, birthDate);
    }
}
