package com.achilles.utilities;

import com.achilles.enums.CivilStatus;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TaxReliefCalculatorTest {
    //#region Public Methods
    @Test
    public void testSingleReliefCalculations() {
        TaxReliefCalculator calculator = new TaxReliefCalculator();
        int dependentCount = 0;

        double expectedRelief = 54000000;
        double output = calculator.execute(CivilStatus.SINGLE, dependentCount);

        assertThat(output).isEqualTo(expectedRelief);
    }

    @Test
    public void testSingleWithDependentCalculations() {
        TaxReliefCalculator calculator = new TaxReliefCalculator();
        int faultyDependentCount = 15;

        double expectedRelief = 54000000;
        double output = calculator.execute(CivilStatus.SINGLE, faultyDependentCount);

        assertThat(output).isEqualTo(expectedRelief);
    }

    @Test
    public void testMarriedWithNoDependent() {
        TaxReliefCalculator calculator = new TaxReliefCalculator();
        int dependentCount = 0;
        double expectedRelief = 58500000;
        double output = calculator.execute(CivilStatus.MARRIED, dependentCount);

        assertThat(output).isEqualTo(expectedRelief);
    }

    @Test
    public void testMarriedWithOneDependent() {
        TaxReliefCalculator calculator = new TaxReliefCalculator();
        int dependentCount = 1;
        double expectedRelief = 63000000;
        double output = calculator.execute(CivilStatus.MARRIED, dependentCount);

        assertThat(output).isEqualTo(expectedRelief);
    }

    @Test
    public void testMarriedWithTwoDependent() {
        TaxReliefCalculator calculator = new TaxReliefCalculator();
        int dependentCount = 2;
        double expectedRelief = 67500000;
        double output = calculator.execute(CivilStatus.MARRIED, dependentCount);

        assertThat(output).isEqualTo(expectedRelief);
    }

    @Test
    public void testMarriedWithThreeDependent() {
        TaxReliefCalculator calculator = new TaxReliefCalculator();
        int dependentCount = 3;
        double expectedRelief = 72000000;
        double output = calculator.execute(CivilStatus.MARRIED, dependentCount);

        assertThat(output).isEqualTo(expectedRelief);
    }

    @Test
    public void testUnProvidedCivilStatus() {
        TaxReliefCalculator calculator = new TaxReliefCalculator();
        int dependentCount = 0;
        double expected = 0;
        double output = calculator.execute(null, dependentCount);

        assertThat(output).isEqualTo(expected);
    }
    //#endregion
}
