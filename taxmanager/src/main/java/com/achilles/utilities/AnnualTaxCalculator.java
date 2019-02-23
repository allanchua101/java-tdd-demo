package com.achilles.utilities;

import com.achilles.contracts.TaxCalculator;
import com.achilles.models.TaxBracket;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used for calculating tax.
 *
 * @author Allan A. Chua
 * @version 1.0
 * @since February 23, 2019
 */
public class AnnualTaxCalculator implements TaxCalculator {
    //#region Constants
    private List<TaxBracket> taxBrackets;
    private final static double CATEGORY_A_MIN = 0;
    private final static double CATEGORY_B_MIN = 50000000;
    private final static double CATEGORY_C_MIN = 250000000;
    private final static double CATEGORY_D_MIN = 500000000;
    private final static double CATEGORY_A_CAP = 50000000;
    private final static double CATEGORY_B_CAP = 250000000;
    private final static double CATEGORY_C_CAP = 500000000;
    private final static double CATEGORY_D_CAP = -1;
    private final static double CATEGORY_A_TAX_RATE = 0.05;
    private final static double CATEGORY_B_TAX_RATE = 0.15;
    private final static double CATEGORY_C_TAX_RATE = 0.25;
    private final static double CATEGORY_D_TAX_RATE = 0.30;
    //#endregion

    //#region Constructors
    public AnnualTaxCalculator() {
        this.taxBrackets = new ArrayList<>();

        taxBrackets.add(new TaxBracket(CATEGORY_A_MIN, CATEGORY_A_CAP, CATEGORY_A_TAX_RATE));
        taxBrackets.add(new TaxBracket(CATEGORY_B_MIN, CATEGORY_B_CAP, CATEGORY_B_TAX_RATE));
        taxBrackets.add(new TaxBracket(CATEGORY_C_MIN, CATEGORY_C_CAP, CATEGORY_C_TAX_RATE));
        taxBrackets.add(new TaxBracket(CATEGORY_D_MIN, CATEGORY_D_CAP, CATEGORY_D_TAX_RATE));
    }
    //#endregion

    //#region Private Methods
    private boolean checkIfTaxableByCapAmount(double taxableAmount, TaxBracket bracket) {
        return (taxableAmount > bracket.getCapAmount()) && !bracket.isCeiling();
    }
    //#endregion

    //#region Public Methods
    /**
     * Method used for executing calculator instance.
     *
     * @param taxableAmount Amount subjected for tax calculation.
     *
     * @return Annual tax.
     */
    public double execute(double taxableAmount) {
        double output = 0;
        double remainingAmount = taxableAmount;
        double taxedAmount = 0;

        if(taxableAmount <= 0)
            return 0;

        for(int i = 0, len = taxBrackets.size(); i < len; i++) {
            TaxBracket bracket = taxBrackets.get(i);

            boolean isTaxableByCap = checkIfTaxableByCapAmount(taxableAmount, bracket);
            double groupTaxedAmount = isTaxableByCap ? bracket.getCapAmount() - taxedAmount : remainingAmount;
            double groupTax = (groupTaxedAmount * bracket.getTaxRate());

            if (groupTax > 0) {
                output += groupTax;
                taxedAmount += groupTaxedAmount;
            }

            remainingAmount -= groupTaxedAmount;

            if(remainingAmount <= 0)
                break;
        }

        return output;
    }
    //#endregion
}
