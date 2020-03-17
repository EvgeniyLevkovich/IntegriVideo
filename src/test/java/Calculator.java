public class Calculator {

    public double addition(double x, double y) {
        return x + y;
    }
    public double subtraction(double x, double y) {
        return x - y;
    }
    public double multiplication(double x, double y) {
        return x * y;
    }
    public double division(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Деление на 0");
        }
        return x / y;
    }

}
