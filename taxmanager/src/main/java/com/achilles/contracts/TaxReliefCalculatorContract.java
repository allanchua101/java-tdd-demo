package com.achilles.contracts;

import com.achilles.enums.CivilStatus;

/**
 * Interface used for mandating implementation of
 * methods used for calculating tax reliefs.
 *
 * @author Allan A. Chua
 * @version 1.0
 * @since February 24, 2019
 */
public interface TaxReliefCalculatorContract {
    /**
     * Method used for executing class.
     *
     * @param civilStatus Civil status of person subjected to tax relief calculation.
     * @param dependentCount Number of dependents associated with person subjected to tax relief calculations.
     *
     * @return Tax relief allowed for person subjected to tax relief calculation.
     */
    double execute(CivilStatus civilStatus, int dependentCount);
}
