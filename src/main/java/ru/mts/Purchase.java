package ru.mts;

public class Purchase {
    // Количество товаров
    private int itemCount;

    // Сумма товара без скидки
    private double totalAmount;

    // Скидка на товар
    private double discount;

    public Purchase(int itemCount, double totalAmount, double discount) {
        this.itemCount = itemCount;
        this.totalAmount = totalAmount;
        this.discount = discount;
    }

    public void calculateTotal() {
        double totalWithoutDiscount = itemCount * totalAmount;
        double discountedTotal = totalWithoutDiscount * (1 - discount / 100);

        System.out.println("Общая сумма покупки без скидки: " + totalWithoutDiscount);
        System.out.println("Общая сумма покупки со скидкой: " + String.format("%.2f", discountedTotal));
    }
}

