package lesson1;

import java.util.concurrent.atomic.AtomicInteger;

public class Program {
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger();
        System.out.println(fibo(10, count));
        System.out.println(count.get());
    }

    /**
     * n = 4
     *
     * @param n
     */
    static void f(int n) {
        System.out.println(n);
        if (n >= 3) {
            f(n - 1);
            f(n - 2);
            f(n - 2);
        }
    }

    /**
     * числа Фибоначчи линейно
     */

    static long fibo(int number, AtomicInteger counter) {
        if (number == 0 || number == 1) return number;
        long[] numbers = new long[number + 1];
        numbers[0] = 0;
        numbers[1] = 1;
        for (int i = 2; i <= number; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
            counter.getAndIncrement();
        }
        return numbers[number];
    }


}

