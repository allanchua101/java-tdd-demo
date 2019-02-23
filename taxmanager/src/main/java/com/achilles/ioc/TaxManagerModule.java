package com.achilles.ioc;

import com.achilles.contracts.InputCollector;
import com.achilles.contracts.TaxDomainServiceContract;
import com.achilles.contracts.TaxableIncomeCalculator;
import com.achilles.domain.TaxDomainService;
import com.achilles.utilities.AnnualTaxableIncomeCalculator;
import com.achilles.utilities.ConsoleInputCollector;
import com.google.inject.AbstractModule;

/**
 * Class that configures all dependency injection mappings in tax management
 * module.
 *
 * @author Allan A. Chua
 * @version 1.0
 * @since February 21, 2019
 */
public class TaxManagerModule extends AbstractModule {
  /**
   * Method used for building all DI mappings.
   */
  @Override
  protected void configure() {
    bind(InputCollector.class).to(ConsoleInputCollector.class);
    bind(TaxableIncomeCalculator.class).to(AnnualTaxableIncomeCalculator.class);
    bind(TaxDomainServiceContract.class).to(TaxDomainService.class);
  }
}