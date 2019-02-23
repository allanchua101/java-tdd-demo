package com.achilles.models;

/**
 * Class used for representing taxation bracket.
 *
 * @author Allan A. Chua
 * @version 1.0
 * @since February 23, 2019
 */
public class TaxBracket {
    //#region Constants
    private final static int CEILING_INDICATOR = -1;
    //#endregion

    //#region Constructors
    public TaxBracket(double minAmount, double capAmount, double taxRate) {
        this.minAmount = minAmount;
        this.capAmount = capAmount;
        this.taxRate = taxRate;
    }
    //#endregion

    //#region Fields
    private double minAmount;
    private double capAmount;
    private double taxRate;
    //#endregion

    //#region Getters / Setters
    public double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(double minAmount) {
        this.minAmount = minAmount;
    }

    public double getCapAmount() {
        return capAmount;
    }

    public void setCapAmount(double capAmount) {
        this.capAmount = capAmount;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
    //#endregion

    //#region Methods
    /**
     * Method used for calculating ceiling values.
     *
     * @return
     */
    public boolean isCeiling() {
        return this.capAmount == CEILING_INDICATOR;
    }
    //#endregion
}
