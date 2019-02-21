package com.achilles.contracts;

import com.achilles.models.TaxCalculationRequest;

/**
 * Interface used for mandating implementation of input collection.
 * 
 * @version 1.0
 * @author Allan A. Chua
 * @since February 21, 2019
 */
public interface InputCollector {
  /**
   * Method used for executing the input collector.
   * 
   * @return Tax calculation request information (Monthly income, civil status and
   *         number of dependents.)
   */
  TaxCalculationRequest execute();
}