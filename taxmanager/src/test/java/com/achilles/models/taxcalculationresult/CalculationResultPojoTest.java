package com.achilles.models.taxcalculationresult;

import com.achilles.models.TaxCalculationResult;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CalculationResultPojoTest {
    @Test
    public void testGrossAnnualTaxableIncome() {
        TaxCalculationResult subject = new TaxCalculationResult();
        double input = 5000;

        subject.setGrossAnnualTaxableIncome(input);
        double output = subject.getGrossAnnualTaxableIncome();

        assertThat(output).isEqualTo(input);
    }

    @Test
    public void testGrossAnnualTax() {
        TaxCalculationResult subject = new TaxCalculationResult();
        double input = 5000;

        subject.setGrossAnnualTax(input);
        double output = subject.getGrossAnnualTax();

        assertThat(output).isEqualTo(input);
    }

    @Test
    public void testNetAnnualTaxableIncome() {
        TaxCalculationResult subject = new TaxCalculationResult();
        double input = 5000;

        subject.setNetAnnualTaxableIncome(input);
        double output = subject.getNetAnnualTaxableIncome();

        assertThat(output).isEqualTo(input);
    }

    @Test
    public void testNetAnnualTax() {
        TaxCalculationResult subject = new TaxCalculationResult();
        double input = 5000;

        subject.setNetAnnualTax(input);
        double output = subject.getNetAnnualTax();

        assertThat(output).isEqualTo(input);
    }
}

