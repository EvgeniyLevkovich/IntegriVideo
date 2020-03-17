import org.testng.annotations.*;

import java.util.Random;

import static org.testng.Assert.assertEquals;

public class CalculatorTest {
    Calculator calculator;

    @BeforeClass
    public void createCalculator() {
        calculator = new Calculator();
    }


    @DataProvider(name = "Данные для суммирования")
    public Object[][] dataForSum() {
        return new Object[][]{
                {1, 2, 3},
                {-1, -2, -3},
                {0, 0, 0},
                {2.2, 3.3, 5.5},
                {-1, 1, 0},

        };
    }
        @Test(dataProvider = "Данные для суммирования")
        public void testSum (double x, double y, double expectedResult ) {
            double sum = calculator.addition(x, y);
            assertEquals(sum, expectedResult, "Суммирование работает некорректно");
        }
        @Parameters({"x", "y"})
        @Test (expectedExceptions = {ArithmeticException.class})
        public void division(@Optional("0")  double x, @Optional("0")double y) throws InterruptedException {
        Thread.sleep(50000);
        calculator.division(x, y);
        //double result = calculator.division(0,0);
        }

        @Test(retryAnalyzer = Retry.class, invocationCount = 3)
        public void flackyTest() {
        if (new Random().nextBoolean()) {
            throw new ArithmeticException();

            }
        }
    }





