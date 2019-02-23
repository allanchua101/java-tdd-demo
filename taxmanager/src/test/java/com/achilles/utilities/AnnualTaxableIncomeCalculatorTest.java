package com.achilles.utilities;

import com.achilles.utilities.AnnualTaxableIncomeCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.*;

@RunWith(Parameterized.class)
public class AnnualTaxableIncomeCalculatorTest {
    //#region Fields
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 40000, 480000 },
                { 10000, 120000 },
                { 100000, 1200000 },
                { 3000, 36000 },
                {1, 12}
        });
    }

    private float input;
    private double expected;
    //#endregion

    //#region Constructors
    public AnnualTaxableIncomeCalculatorTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }
    //#endregion

    //#region Public Methods
    @Test
    public void testAnnualTaxableIncomeCalculation() {
        AnnualTaxableIncomeCalculator taxableIncomeCalculator = new AnnualTaxableIncomeCalculator();
        double output = taxableIncomeCalculator.execute(input);

        assertThat(output).isEqualTo(expected);
    }
    //#endregion
}
