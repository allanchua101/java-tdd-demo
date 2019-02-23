package com.achilles.contracts;

/**
 * Interface used for mandating implementation of methods
 * used for calculating taxable income.
 *
 * @author Allan A. Chua
 * @version 1.0
 * @since February 23, 2019
 */
public interface TaxableIncomeCalculator {
    /**
     * Method used for executing calculator instance.
     *
     * @param monthlyIncome Monthly income subjected for calculation.
     *
     * @return The taxable income.
     */
    float execute(float monthlyIncome);
}
