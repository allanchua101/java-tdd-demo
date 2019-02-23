package com.achilles.utilities;

import com.achilles.contracts.TaxableIncomeCalculator;

/**
 * Class used for calculating annual taxable income.
 *
 * @author Allan A. Chua
 * @version 1.0
 * @since February 23, 2019
 */
public class AnnualTaxableIncomeCalculator implements TaxableIncomeCalculator {
    private final static int MONTHS_IN_A_YEAR = 12;

    /**
     * Method used for executing calculator instance.
     *
     * @param monthlyIncome Monthly income subjected for calculation.
     *
     * @return The taxable income.
     */
    @Override
    public float execute(float monthlyIncome) {
        return monthlyIncome * MONTHS_IN_A_YEAR;
    }
}
