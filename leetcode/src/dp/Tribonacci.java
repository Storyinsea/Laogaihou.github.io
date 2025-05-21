package dp;

public class Tribonacci {
    public int tribonacci(int n) {
        if (n == 2) {
            return 1;
        } else if (n < 2) {
            return n;
        }
        int a = 0, b = 1, c = 1;
        int fn = 0;
        for (int i = 3; i <= n; i++) {
            fn = a + b + c;
            a = b;
            b = c;
            c = fn;
        }
        return fn;
    }

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0, b = 1;
        int fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = a + b;
            a = b;
            b = fn;
        }
        return fn;
    }
}
