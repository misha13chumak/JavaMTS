package ru.mts.hw3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Класс, представляющий собой кошку. Наследуется от класса Pet.
 */
public class Cat extends Pet {
    /**
     * Конструктор класса Cat.
     *
     * @param breed Порода кошки.
     * @param name  Имя кошки.
     * @param cost  Стоимость кошки.
     */
    public Cat(String breed, String name, BigDecimal cost) {
        this.breed = breed;
        this.name = name;
        this.cost = cost.setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Метод toString для получения строкового представления кошки.
     *
     * @return Строковое представление кошки.
     */
    @Override
    public String toString() {
        return "Cat{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                '}';
    }
}
