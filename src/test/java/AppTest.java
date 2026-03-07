import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    App calc = new App();

    // √x
    @Test
    void testSquareRoot() {
        assertEquals(5.0, calc.sqrt(25), 0.0001);
        assertEquals(10000, calc.sqrt(100000000),0.0001);
        assertEquals(9.9, calc.sqrt(98.01), 0.0001);
        assertEquals(89766.89899, calc.sqrt(8058096154.28),0.0001);
    }

    // x!
    @Test
    void testFactorial() {
        assertEquals(1, calc.factorial(0));
        assertEquals(5040, calc.factorial(7));
        assertEquals(40320, calc.factorial(8));
        assertEquals(2, calc.factorial(2));
    }

    // ln(x)
    @Test
    void testNaturalLog() {
        assertEquals(1.0, calc.ln(Math.E), 0.0001);
        assertEquals(15.4249484704, calc.ln(5000000), 0.0001);
        assertEquals(20.7232658359, calc.ln(999999999), 0.0001);
        assertEquals(0.0, calc.ln(1), 0.0001);
    }

    // x^b
    @Test
    void testPower() {
        assertEquals(8.0, calc.power(2,3), 0.0001);
        assertEquals(3125.0, calc.power(5,5), 0.0001);
        assertEquals(65536.0 , calc.power(2,16), 0.0001);
        assertEquals(1.0 , calc.power(1,100000000), 0.0001);
    }

}