package com.achilles.domain;

import com.achilles.contracts.TaxCalculator;
import com.achilles.contracts.TaxDomainServiceContract;
import com.achilles.contracts.TaxableIncomeCalculator;
import com.achilles.models.TaxCalculationRequest;
import com.achilles.models.TaxCalculationResult;
import com.achilles.utilities.TaxReliefCalculator;
import com.google.inject.Inject;

public class TaxDomainService implements TaxDomainServiceContract {
    //#region Constructors
    @Inject
    public TaxDomainService(
            TaxableIncomeCalculator taxableIncomeCalculator,
            TaxCalculator taxCalculator,
            TaxReliefCalculator taxReliefCalculator
    ) {
        this.taxableIncomeCalculator = taxableIncomeCalculator;
        this.taxCalculator = taxCalculator;
        this.taxReliefCalculator = taxReliefCalculator;
    }
    //#endregion

    //#region Fields
    private TaxableIncomeCalculator taxableIncomeCalculator;
    private TaxCalculator taxCalculator;
    private TaxReliefCalculator taxReliefCalculator;
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

        double taxRelief = taxReliefCalculator.execute(request.getCivilStatus(), request.getDependentCount());
        double netAnnualTaxableIncome = grossAnnualTaxableIncome - taxRelief;

        if(netAnnualTaxableIncome <= 0)
            netAnnualTaxableIncome = 0;

        result.setNetAnnualTaxableIncome(netAnnualTaxableIncome);

        double netAnnualTax = taxCalculator.execute(netAnnualTaxableIncome);
        result.setNetAnnualTax(netAnnualTax);

        return result;
    }
    //#endregion
}
