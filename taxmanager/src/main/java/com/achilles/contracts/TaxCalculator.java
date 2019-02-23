package com.achilles.contracts;

/**
 * Interface used for mandating implementation
 * of methods used for tax calculation.
 *
 * @author Allan A. Chua
 * @version 1.0
 * @since February 23, 2019
 */
public interface TaxCalculator {
    /**
     * Method used for executing calculator instance.
     *
     * @param taxableAmount Amount subjected for tax calculation.
     *
     * @return Annual tax.
     */
    double execute(double taxableAmount);
}
