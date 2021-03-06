package com.achilles;

import com.achilles.contracts.InputCollectorContract;
import com.achilles.contracts.TaxDomainServiceContract;
import com.achilles.models.TaxCalculationRequest;
import com.achilles.models.TaxCalculationResult;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.achilles.ioc.TaxManagerModule;

/**
 * Tax Management Module
 *
 */
public class App {
    /**
     * Main entry point of the application.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new TaxManagerModule());

        InputCollectorContract inputCollector = injector.getInstance(InputCollectorContract.class);
        TaxCalculationRequest request = inputCollector.execute();

        TaxDomainServiceContract taxDomainService = injector.getInstance(TaxDomainServiceContract.class);
        TaxCalculationResult result = taxDomainService.calculateTax(request);

        System.out.println("----------------------------------RESULT--------------------------------------");
        System.out.printf("Gross Annual Taxable Income: %,.2f\n", result.getGrossAnnualTaxableIncome());
        System.out.printf("Gross Annual Tax: %,.2f\n", result.getGrossAnnualTax());
        System.out.printf("Net Annual Taxable Income: %,.2f\n", result.getNetAnnualTaxableIncome());
        System.out.printf("Net Annual Tax: %,.2f\n", result.getNetAnnualTax());
    }
}
