package global.goit;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static final Map<Integer, Long> memo = new HashMap<>();


    public static void main(String[] args) {
        long res = fibRecursive(6);
        print(res);
        res = fibIterative(10);
        print(res);
        res = fibDP(20);
        print(res);

    }

    //Часова складність  O(2^n) |  просторова складність O(n)
    static long fibRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("number cannot be negative");
        }
        if (n < 2) {
            return n;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    //Часова складність  O(n) |  просторова складність O(1)
    static long fibIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("number cannot be negative");
        }
        if (n < 2) {
            return n;
        }
        long prev = 0;
        long curr = 1;
        for (int i = 2; i <= n; i++) {
            long tmp = curr;
            curr = prev + curr;
            prev = tmp;
        }
        return curr;
    }

    //Часова складність  O(n) |  просторова складність  O(n)
    static long fibDP(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("number cannot be negative");
        }
        if (n < 2) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long fib = fibDP(n - 1) + fibDP(n - 2);
        memo.put(n, fib);
        return fib;
    }

    static void print(long res) {
        System.out.println(res);
        System.out.println("-".repeat(20));
    }

}



















