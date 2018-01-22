package ru.job4j.primeIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator {

    private int[] numbers;
    private int index = 0;
    private int indexHas = 0;

    public PrimeIterator(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
       int count = 0;
       if (index == 0) {
            indexHas = 1;
       } else {
            indexHas = index;
       }
      if (indexHas < numbers.length && numbers[indexHas] > 2) {
            for (int i = 2; i < numbers[indexHas]; i++) {
                if (numbers[indexHas] % i == 0) {
                    count = 0;
                    indexHas++;
                    if (indexHas >= numbers.length) {
                        break;
                    }
                }
                if (indexHas < numbers.length && i == numbers[indexHas] - 1) {
                    count = 1;
                }
             }
      } else if (indexHas >= numbers.length) {
          count = 0;
      } else if (numbers[indexHas] == 2) {
          count = 1;
      }

      return count == 1;

    }

    @Override
    public Object next() {
        int ch = 0;
        for (int i = index; i < numbers.length; i++) {
            int count = 1;
            if (numbers[i] > 2) {
                for (int k = 2; k < numbers[i]; k++) {
                    if (numbers[i] % k == 0) {
                        break;
                    }
                    if (k==numbers[i]-1) {
                        count = 0;
                    }
                }
            } else if (numbers[i] == 2) {
                count = 0;
            }

            if (count == 0) {
                ch = numbers[i];
                index = i + 1;
                break;
            }
        }
        if (index > numbers.length || ch == 0) {
            throw new NoSuchElementException();
        }
        return ch;
    }

    public static void main(String[] args) {
        PrimeIterator primeIterator = new PrimeIterator(new int[] {4, 6});
        System.out.println(primeIterator.hasNext());
    }
}
