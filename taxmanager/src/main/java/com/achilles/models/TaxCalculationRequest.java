package com.achilles.models;

import com.achilles.enums.CivilStatus;

/**
 * Class used for representing tax calculation request.
 * 
 * @version 1.0
 * @author Allan A. Chua
 * @since February 21, 2019
 */
public class TaxCalculationRequest {
  // #region Fields
  private float monthlyIncome;
  private CivilStatus civilStatus;
  private int dependentCount;
  // #endregion

  // #region Getters / Setters
  /**
   * Method used for retrieving the monthly income subjected for tax calculation
   * request.
   * 
   * @return The monthly income for the tax calculation request.
   */
  public float getMonthlyIncome() {
    return monthlyIncome;
  }

  /**
   * Method used for setting the monthly income subjected for tax calculation
   * request.
   * 
   * @param monthlyIncome Monthly income that would be subjected to tax
   *                      calculation.
   */
  public void setMonthlyIncome(float monthlyIncome) {
    this.monthlyIncome = monthlyIncome;
  }

  /**
   * Method used for retrieving the civil status of the person subjected to tax
   * calculation.
   * 
   * 
   * @return The civil status of the person subjected to tax calculation.
   */
  public CivilStatus getCivilStatus() {
    return civilStatus;
  }

  /**
   * Method used for setting the civil status of the person subjected to tax
   * calculation.
   * 
   * @param civilStatus The civil status of the person subjected to tax
   *                    calculation.
   */
  public void setCivilStatus(CivilStatus civilStatus) {
    this.civilStatus = civilStatus;
  }

  /**
   * Method used for retrieving dependent count of person subjected for tax
   * calculation.
   * 
   * @return The number of dependents associated with the person subjected for tax
   *         calculation.
   */
  public int getDependentCount() {
    return dependentCount;
  }

  /**
   * Method used for setting the dependent count of person subjected for tax
   * calculation.
   * 
   * @param dependentCount The number of dependents associated with the person
   *                       subjected for tax calculation.
   */
  public void setDependentCount(int dependentCount) {
    this.dependentCount = dependentCount;
  }
  // #endregion
}
