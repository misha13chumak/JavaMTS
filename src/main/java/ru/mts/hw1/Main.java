package ru.mts.hw1;

public class Main {
    public static void main(String[] args) {
        // Тестирование с различными объектами
        Purchase purchase1 = new Purchase(5, 10.0, 0.75);
        Purchase purchase2 = new Purchase(8, 15.0, 42.575);
        Purchase purchase3 = new Purchase(3, 20.0, 59.1);


        purchase1.calculateTotal();

        purchase2.calculateTotal();

        purchase3.calculateTotal();

    }
}
