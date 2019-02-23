package com.achilles.domain;

import com.achilles.contracts.TaxCalculator;
import com.achilles.contracts.TaxDomainServiceContract;
import com.achilles.contracts.TaxableIncomeCalculator;
import com.achilles.models.TaxCalculationRequest;
import com.achilles.models.TaxCalculationResult;
import com.google.inject.Inject;

public class TaxDomainService implements TaxDomainServiceContract {
    //#region Constructors
    @Inject
    public TaxDomainService(
            TaxableIncomeCalculator taxableIncomeCalculator,
            TaxCalculator taxCalculator
    ) {
        this.taxableIncomeCalculator = taxableIncomeCalculator;
        this.taxCalculator = taxCalculator;
    }
    //#endregion

    //#region Fields
    private TaxableIncomeCalculator taxableIncomeCalculator;
    private TaxCalculator taxCalculator;
    //#endregion

    //#region Public Methods
    /**
     * Method used for calculating tax information.
     *
     * @param request Tax calculation request containing information subjected for taxation.
     *
     * @return Inferred taxation information based on provided input.
     */
    public TaxCalculationResult calculateTax(TaxCalculationRequest request) {
        TaxCalculationResult result = new TaxCalculationResult();

        double grossAnnualTaxableIncome = taxableIncomeCalculator.execute(request.getMonthlyIncome());
        result.setGrossAnnualTaxableIncome(grossAnnualTaxableIncome);

        double grossAnnualTax = taxCalculator.execute(grossAnnualTaxableIncome);
        result.setGrossAnnualTax(grossAnnualTax);

        return result;
    }
    //#endregion
}
