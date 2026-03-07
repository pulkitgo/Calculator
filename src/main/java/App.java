public class App {

    public double sqrt(double x) {
        return Math.sqrt(x);
    }
//
    public double factorial(double x) {
        if (x < 0) throw new IllegalArgumentException("Negative not allowed");

        long res = 1;
        for (int i = 2; i <= x; i++) {
            res *= i;
        }
        return res;
    }

    public double ln(double x) {
        if (x <= 0) throw new IllegalArgumentException("x must be positive");
        return Math.log(x);
    }

    public double power(double x, double b) {
        return Math.pow(x, b);
    }
}
