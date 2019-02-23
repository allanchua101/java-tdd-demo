package com.achilles.models.taxbracketcalculationrequest;

import com.achilles.enums.CivilStatus;
import com.achilles.models.TaxCalculationRequest;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TaxCalculationRequestPojoTest {
    @Test
    public void testMonthlyIncome() {
        TaxCalculationRequest request = new TaxCalculationRequest();
        float monthlyIncome = 50000;

        request.setMonthlyIncome(monthlyIncome);
        float output = request.getMonthlyIncome();

        assertThat(output).isEqualTo(monthlyIncome);
    }

    @Test
    public void testDependentCount() {
        TaxCalculationRequest request = new TaxCalculationRequest();
        int dependentCount = 5;

        request.setDependentCount(dependentCount);
        int output = request.getDependentCount();

        assertThat(output).isEqualTo(dependentCount);
    }

    @Test
    public void testCivilStatus() {
        TaxCalculationRequest request = new TaxCalculationRequest();
        CivilStatus civilStatus = CivilStatus.SINGLE;

        request.setCivilStatus(civilStatus);
        CivilStatus output = request.getCivilStatus();

        assertThat(output).isEqualTo(civilStatus);
    }
}
