package com.achilles;

import com.achilles.contracts.InputCollector;
import com.achilles.models.TaxCalculationRequest;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.achilles.ioc.TaxManagerModule;

/**
 * Tax Management Module
 *
 */
public class App 
{
    /**
     * Main entry point of the application.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new TaxManagerModule());

        InputCollector inputCollector = injector.getInstance(InputCollector.class);
        TaxCalculationRequest request = inputCollector.execute();

        System.out.flush();
    }
}
