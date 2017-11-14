package ru.job4j.automat;

public class Operation implements Automat {
    /**
     * Для хранения количества соответсвующих монет.
     */
    int one;
    int five;
    int two;
    int ten;
    int[] array = new int[0];

    public Operation() {

    }

    public Operation(int ten, int five, int two, int one) {
        this.ten = ten;
        this.five = five;
        this.two = two;
        this.one = one;
    }

    /**
     * Определяет монеты для сдачи.
     * @return array
     */
    public int[] getMoney() {
        array = new int[ten + five + two + one];
        for (int index = 0; index < array.length; index++) {
            if (ten > 0) {
                array[index] = 10;
                ten--;
            } else if (five > 0) {
                array[index] = 5;
                five--;
            } else if (two > 0) {
                array[index] = 2;
                two--;
            } else if (one > 0) {
                array[index] = 1;
                one--;
            }
        }
        return array;
    }

    /**
     * Получает сдачу
     * @param value купюра.
     * @param price цена кофе.
     * @return array массив со сдачей.
     */
    public int[] changes(int value, int price) {
        int delivery = value - price;
        ten = delivery / 10;
        five = 1;

        if (delivery % 2 != 0 && delivery % 5 != 0 && delivery % 10 != 1) {
            if (delivery - (10 * ten) >= 5) {
                two = ((delivery - (10 * ten))-5) / 2;
            } else {
                five = 0;
                one = 1;
                two = 1;
            }
        } else if (delivery % 10 == 1) {
            five = 0;
            one = 1;
        } else if (delivery % 2 == 0) {
            if ( delivery - (10*ten) >= 5 ) {
                two = ((delivery - (10 * ten))-5) / 2;
                one = 1;
            } else {
                five = 0;
                two = (delivery - (10 * ten)) / 2;
                one = 0;
            }
        }
        Operation operation = new Operation(ten, five, two, one);
        return operation.getMoney();
    }
}