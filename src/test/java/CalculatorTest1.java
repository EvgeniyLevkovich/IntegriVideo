import org.testng.annotations.*;

import java.util.Random;

import static org.testng.Assert.assertEquals;

public class CalculatorTest1 {
    Calculator calculator;

    @BeforeClass
    public void createCalculator() {
        calculator = new Calculator();
    }

    @Test
    public void division(@Optional("10")  double x, @Optional("2")double y) throws InterruptedException {
        calculator.division(x, y);
        Thread.sleep(50000);
        double result = calculator.division(x, y);
    }

    @Test(retryAnalyzer = Retry.class, invocationCount = 10)
    public void flackyTest() {
        if (new Random().nextBoolean()) {
            throw new ArithmeticException();

        }
    }
}
