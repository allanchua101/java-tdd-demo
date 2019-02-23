package com.achilles.utilities;

import com.achilles.utilities.AnnualTaxCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.*;

@RunWith(Parameterized.class)
public class AnnualTaxCalculatorTest {
    //#region Fields
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                // No Input
                {0, 0},
                // Bracket A
                {10000000, 500000},
                {20000000, 1000000},
                {30000000, 1500000},
                {40000000, 2000000},
                {50000000, 2500000},
                // Bracket B
                {60000000, 4000000},
                {90000000, 8500000},
                {120000000, 13000000},
                {200000000, 25000000},
                {250000000, 32500000},
                // Bracket C
                {300000000, 45000000},
                // Bracket D
                {500000000, 95000000}
        });
    }

    private double input;
    private double expected;
    //#endregion

    //#region Constructors
    public AnnualTaxCalculatorTest(double input, double expected) {
        this.input = input;
        this.expected = expected;
    }
    //#endregion

    //#region Public Methods
    @Test
    public void testAnnualTaxCalculation() {
        AnnualTaxCalculator calculator = new AnnualTaxCalculator();
        double output = calculator.execute(input);

        assertThat(output).isEqualTo(expected);
    }
    //#endregion
}
