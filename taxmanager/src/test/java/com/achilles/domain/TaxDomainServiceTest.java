package com.achilles.domain;

import com.achilles.contracts.TaxCalculator;
import com.achilles.contracts.TaxableIncomeCalculator;
import com.achilles.enums.CivilStatus;
import com.achilles.models.TaxCalculationRequest;
import com.achilles.models.TaxCalculationResult;
import com.achilles.utilities.AnnualTaxCalculator;
import com.achilles.utilities.TaxReliefCalculator;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

public class TaxDomainServiceTest {
    //#region Private Methods
    private TaxDomainService mockTaxDomainService(
            float mockedGrossAnnualIncome,
            double mockedTaxComputation,
            double mockedTaxRelief
    ) {
        // Gross Annual Income Mocking
        TaxableIncomeCalculator mockedIncomeCalc = Mockito.mock(TaxableIncomeCalculator.class);
        when(mockedIncomeCalc.execute(
                Mockito.anyFloat()
        )).thenReturn(mockedGrossAnnualIncome);

        // Gross and Net Annual Tax Mocking
        TaxCalculator mockedTaxCalculator = Mockito.mock(TaxCalculator.class);
        when(mockedTaxCalculator.execute(
                Mockito.anyDouble()
        )).thenReturn(mockedTaxComputation);

        // Tax Relief Calculation Mocking
        TaxReliefCalculator mockedTaxReliefCalculator = Mockito.mock(TaxReliefCalculator.class);
        when(mockedTaxReliefCalculator.execute(
                Mockito.any(CivilStatus.class),
                Mockito.anyInt()
        )).thenReturn(mockedTaxRelief);

        return new TaxDomainService(
                mockedIncomeCalc,
                mockedTaxCalculator,
                mockedTaxReliefCalculator
        );
    }
    //#endregion

    @Test
    public void testTaxResultCalculcation() {
        TaxCalculationRequest request = new TaxCalculationRequest();
        request.setCivilStatus(CivilStatus.SINGLE);
        request.setDependentCount(0);
        request.setMonthlyIncome(25000000);

        float mockedGrossAnnualIncome = 300000000;
        double mockedTaxComputation = 45000000;
        double mockedTaxRelief = 50000;
        double expectedNetAnnualTaxableIncome = mockedGrossAnnualIncome - mockedTaxRelief;

        TaxDomainService taxDomainService = mockTaxDomainService(
                mockedGrossAnnualIncome, mockedTaxComputation, mockedTaxRelief
        );
        TaxCalculationResult result = taxDomainService.calculateTax(request);

        assertThat(result.getGrossAnnualTaxableIncome()).isEqualTo(mockedGrossAnnualIncome);
        assertThat(result.getGrossAnnualTax()).isEqualTo(mockedTaxComputation);
        assertThat(result.getNetAnnualTaxableIncome()).isEqualTo(expectedNetAnnualTaxableIncome);
        assertThat(result.getNetAnnualTax()).isEqualTo(mockedTaxComputation);
    }

    @Test
    public void testNegativeTaxResults() {
        TaxCalculationRequest request = new TaxCalculationRequest();
        request.setCivilStatus(CivilStatus.SINGLE);
        request.setDependentCount(0);
        request.setMonthlyIncome(25000000);

        float mockedGrossAnnualIncome = 0;
        double mockedTaxComputation = 45000000;
        double mockedTaxRelief = 50000000;
        double expectedOutput = 0;

        TaxDomainService taxDomainService = mockTaxDomainService(
                mockedGrossAnnualIncome, mockedTaxComputation, mockedTaxRelief
        );
        TaxCalculationResult result = taxDomainService.calculateTax(request);

        assertThat(result.getGrossAnnualTaxableIncome()).isEqualTo(expectedOutput);
        assertThat(result.getGrossAnnualTax()).isEqualTo(mockedTaxComputation);
        assertThat(result.getNetAnnualTaxableIncome()).isEqualTo(expectedOutput);
        assertThat(result.getNetAnnualTax()).isEqualTo(mockedTaxComputation);
    }
}
