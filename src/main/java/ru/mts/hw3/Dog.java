package ru.mts.hw3;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * Класс, представляющий собой собаку. Наследуется от класса Pet.
 */
public class Dog extends Pet {

    /**
     * Конструктор класса Dog.
     *
     * @param breed Порода собаки.
     * @param name  Имя собаки.
     * @param cost  Стоимость собаки.
     * @param character Характер собаки.
     */
    public Dog(String breed, String name, BigDecimal cost, String character) {
        this.breed = breed;
        this.name = name;
        this.cost = cost.setScale(2, RoundingMode.HALF_UP);
        this.character = character;
    }

    /**
     * Конструктор класса Dog.
     *
     * @param breed Порода собаки.
     * @param name  Имя собаки.
     * @param cost  Стоимость собаки.
     */
    public Dog(String breed, String name, BigDecimal cost) {
        this.breed = breed;
        this.name = name;
        this.cost = cost.setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Метод toString для получения строкового представления собаки.
     *
     * @return Строковое представление собаки.
     */
    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                '}';
    }
}
