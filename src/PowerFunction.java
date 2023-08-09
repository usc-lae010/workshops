public class PowerFunction {

    public static double power(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        if (n % 2 == 1) {
            double halfPower = power(x, n / 2);
            return halfPower * halfPower;
        } else {
            double halfPower = power(x, (n - 1) / 2);
            return halfPower * halfPower * x;
        }
    }

    public static void main(String[] args) {
        double base = 2.0;
        int exponent = 10;

        double result = power(base, exponent);

        System.out.println(base + " raised to the power of " + exponent + " is " + result);
    }
}
