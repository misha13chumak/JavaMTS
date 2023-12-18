package ru.mts.hw3;
/**
 * Абстрактный класс, представляющий собой хищника.
 * Наследуется от AbstractAnimal.
 */
public abstract class Predator extends AbstractAnimal {
    /**
     * Конструктор. Устанавливает характер хищника как "Angry".
     */
    Predator() {
        this.character = "Angry";
    }


}
