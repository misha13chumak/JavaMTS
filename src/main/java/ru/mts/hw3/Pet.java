package ru.mts.hw3;
/**
 * Абстрактный класс, представляющий собой домашнее животное.
 * Наследуется от AbstractAnimal.
 */
public abstract class Pet extends AbstractAnimal {
    /**
     * Конструктор. Устанавливает характер домашнего животного как "Gentle".
     */
    Pet() {
        this.character = "Kind";
    }


}
