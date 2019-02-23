package com.achilles.models;

/**
 * Class that represents a tax calculation result.
 *
 * @author Allan A. Chua
 * @version 1.0
 * @since February 23, 2019
 */
public class TaxCalculationResult {
    //#region Fields
    private double grossAnnualTaxableIncome;
    private double grossAnnualTax;
    private double netAnnualTaxableIncome;
    private double netAnnualTax;
    //#endregion

    //#region Getters / Setters
    /**
     * Method used for retrieving gross annual taxable income.
     *
     * @return Gross annual taxable income.
     */
    public double getGrossAnnualTaxableIncome() {
        return grossAnnualTaxableIncome;
    }

    /**
     * Method used for setting gross annual taxable income.
     *
     * @param grossAnnualTaxableIncome Gross annual taxable income.
     */
    public void setGrossAnnualTaxableIncome(double grossAnnualTaxableIncome) {
        this.grossAnnualTaxableIncome = grossAnnualTaxableIncome;
    }

    /**
     * Method used for retrieving gross annual tax.
     *
     * @return Gross annual tax.
     */
    public double getGrossAnnualTax() {
        return grossAnnualTax;
    }

    /**
     * Method used for setting gross annual tax.
     *
     * @param grossAnnualTax Gross annual tax.
     */
    public void setGrossAnnualTax(double grossAnnualTax) {
        this.grossAnnualTax = grossAnnualTax;
    }

    /**
     * Method used for retrieving the net annual taxable income.
     *
     * @return Net annual taxable income.
     */
    public double getNetAnnualTaxableIncome() {
        return netAnnualTaxableIncome;
    }

    /**
     * Method used for setting the net annual taxable income.
     *
     * @param netAnnualTaxableIncome Net annual taxable income.
     */
    public void setNetAnnualTaxableIncome(double netAnnualTaxableIncome) {
        this.netAnnualTaxableIncome = netAnnualTaxableIncome;
    }

    /**
     * Method used for retrieving the net annual tax.
     *
     * @return Net annual tax.
     */
    public double getNetAnnualTax() {
        return netAnnualTax;
    }

    /**
     * Method used for setting the net annual tax.
     *
     * @param netAnnualTax Net annual tax.
     */
    public void setNetAnnualTax(double netAnnualTax) {
        this.netAnnualTax = netAnnualTax;
    }
    //#endregion
}
