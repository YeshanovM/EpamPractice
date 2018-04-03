import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class TemperatureConverterTest {

    @Parameterized.Parameter(0)
    public double expected;
    @Parameterized.Parameter(1)
    public double value;

    @Parameterized.Parameters(name="{index}convertCToFTest({0})={1}")
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
                {89.6, 32},
                {89.6, 32}
        });
    }

    public static final double DELTA = 0.1;

    @Test
    public void convertCtoFTest() {
        assertEquals(32, TemperatureConverter.convertCtoF(0), DELTA);
    }

    @Test
    public void convertCtoKTest() {
        assertEquals(305.2, TemperatureConverter.convertCtoK(32), DELTA);
    }

    @Test
    public void convertFtoCTest() {
        assertEquals(0, TemperatureConverter.convertFtoC(32), DELTA);
    }

    @Test
    public void convertFtoKTest() {
        assertEquals(273.2, TemperatureConverter.convertFtoK(32), DELTA);
    }

    @Test
    public void convertKtoCTest() {
        assertEquals(-273.2, TemperatureConverter.convertKtoC(0), DELTA);
    }

    @Test
    public void convertKtoFTest() {
        assertEquals(-459.67, TemperatureConverter.convertKtoF(0), DELTA);
    }
}
