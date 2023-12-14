package ru.mts;

import java.math.BigDecimal;

/**
 * Класс Purchase выводит информацию о покупке: количество товаров,
 * общую сумму без скидки и процент скидки на товар. Для финансовых расчетов,
 * в этом классе использован класс BigDecimal.
 */
public class Purchase {
    // Количество товаров
    private int itemCount;

    // Сумма товара без скидки
    private BigDecimal totalAmount;

    // Скидка на товар
    private BigDecimal discount;

    public Purchase(int itemCount, double totalAmount, double discount) {
        this.itemCount = itemCount;
        this.totalAmount = BigDecimal.valueOf(totalAmount);
        this.discount = BigDecimal.valueOf(discount);
    }

    public void calculateTotal() {
        BigDecimal totalWithoutDiscount = totalAmount.multiply(BigDecimal.valueOf(itemCount));
        BigDecimal discountedTotal = totalWithoutDiscount.multiply(BigDecimal.ONE.subtract(discount.divide(BigDecimal.valueOf(100))));

        System.out.println("Общая сумма покупки без скидки: " + totalWithoutDiscount);
        System.out.println("Общая сумма покупки со скидкой: " + discountedTotal.setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println("");
    }
}
