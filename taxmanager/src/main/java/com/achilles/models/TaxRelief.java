package com.achilles.models;

import com.achilles.enums.CivilStatus;

/**
 * Class used for representing tax relief groups.
 *
 * @author Allan A. Chua
 * @version 1.0
 * @since February 23, 2019
 */
public class TaxRelief {
    //#region Fields
    private CivilStatus civilStatus;
    private int numberOfDependents;
    private double reliefValue;
    //#endregion

    //#region Getters / Setters
    public CivilStatus getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(CivilStatus civilStatus) {
        this.civilStatus = civilStatus;
    }

    public int getNumberOfDependents() {
        return numberOfDependents;
    }

    public void setNumberOfDependents(int numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
    }

    public double getReliefValue() {
        return reliefValue;
    }

    public void setReliefValue(double reliefValue) {
        this.reliefValue = reliefValue;
    }
    //#endregion
}
