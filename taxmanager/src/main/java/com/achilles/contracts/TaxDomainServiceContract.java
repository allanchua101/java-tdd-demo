package com.achilles.contracts;

import com.achilles.models.TaxCalculationRequest;
import com.achilles.models.TaxCalculationResult;

/**
 * Interface used for mandating implementation of methods used for
 * calculating taxpayer's annual income and tax reliefs.
 *
 * @author Allan A. Chua
 * @version 1.0
 * @since February 23, 2019
 */
public interface TaxDomainServiceContract {
    /**
     * Method used for calculating tax information.
     *
     * @param request Tax calculation request containing information subjected for taxation.
     *
     * @return Inferred taxation information based on provided input.
     */
    TaxCalculationResult calculateTax(TaxCalculationRequest request);
}
