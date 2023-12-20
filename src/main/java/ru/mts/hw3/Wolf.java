package ru.mts.hw3;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * Класс, представляющий собой волка. Наследуется от класса Predator.
 */
public class Wolf extends Predator {

    /**
     * Конструктор класса Wolf.
     *
     * @param breed Порода волка.
     * @param name  Имя волка.
     * @param cost  Стоимость волка.
     * @param character Характер волка.
     */
    public Wolf(String breed, String name, BigDecimal cost, String character) {
        this.breed = breed;
        this.name = name;
        this.cost = cost.setScale(2, RoundingMode.HALF_UP);
        this.character = character;
    }

    /**
     * Конструктор класса Wolf.
     *
     * @param breed Порода волка.
     * @param name  Имя волка.
     * @param cost  Стоимость волка.
     */
    public Wolf(String breed, String name, BigDecimal cost) {
        this.breed = breed;
        this.name = name;
        this.cost = cost.setScale(2, RoundingMode.HALF_UP);
    }
    /**
     * Метод toString для получения строкового представления волка.
     *
     * @return Строковое представление волка.
     */
    @Override
    public String toString() {
        return "Wolf{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                '}';
    }
}
