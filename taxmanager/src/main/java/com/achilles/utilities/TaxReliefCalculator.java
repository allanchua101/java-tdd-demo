package com.achilles.utilities;

import com.achilles.contracts.TaxReliefCalculatorContract;
import com.achilles.enums.CivilStatus;
import com.achilles.models.TaxRelief;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class used for calculating tax relief.
 *
 * @author Allan A. Chua
 * @version 1.0
 * @since February 24, 2019
 */
public class TaxReliefCalculator implements TaxReliefCalculatorContract {
    //#region Fields
    private List<TaxRelief> taxReliefList;
    //#endregion

    //#region Constructors
    public TaxReliefCalculator() {
        this.taxReliefList = buildList();
    }
    //#endregion

    //#region Private Methods
    // NOTE: On real-lief situations, this would usually originate
    //       from an easy to configure data storage. For the sake of
    //       TDD demo, they we're hardcoded for the mean time.
    private ArrayList<TaxRelief> buildList() {
        ArrayList<TaxRelief> taxReliefs = new ArrayList<>();

        // Single Tax Relief
        TaxRelief singleTaxRelief = new TaxRelief();
        singleTaxRelief.setCivilStatus(CivilStatus.SINGLE);
        singleTaxRelief.setReliefValue(54000000); // 54M
        taxReliefs.add(singleTaxRelief);

        // Married with no child
        TaxRelief marriedWithNoDependent = new TaxRelief();
        marriedWithNoDependent.setCivilStatus(CivilStatus.MARRIED);
        marriedWithNoDependent.setReliefValue(58500000); // 58.5M
        taxReliefs.add(marriedWithNoDependent);

        // Married with one child
        TaxRelief marriedWithOneDependent = new TaxRelief();
        marriedWithOneDependent.setCivilStatus(CivilStatus.MARRIED);
        marriedWithOneDependent.setNumberOfDependents(1);
        marriedWithOneDependent.setReliefValue(63000000); // 63M
        taxReliefs.add(marriedWithOneDependent);

        TaxRelief marriedWithTwoDependent = new TaxRelief();
        marriedWithTwoDependent.setCivilStatus(CivilStatus.MARRIED);
        marriedWithTwoDependent.setNumberOfDependents(2);
        marriedWithTwoDependent.setReliefValue(67500000); // 67.5M
        taxReliefs.add(marriedWithTwoDependent);

        TaxRelief marriedWithThreeDependent = new TaxRelief();
        marriedWithThreeDependent.setCivilStatus(CivilStatus.MARRIED);
        marriedWithThreeDependent.setNumberOfDependents(3);
        marriedWithThreeDependent.setReliefValue(72000000); // 72M
        taxReliefs.add(marriedWithThreeDependent);

        return taxReliefs;
    }
    //#endregion

    //#region Public Methods
    /**
     * Method used for executing class.
     *
     * @param civilStatus Civil status of person subjected to tax relief calculation.
     * @param dependentCount Number of dependents associated with person subjected to tax relief calculations.
     *
     * @return Tax relief allowed for person subjected to tax relief calculation.
     */
    public double execute(CivilStatus civilStatus, int dependentCount) {
        if (civilStatus == CivilStatus.SINGLE) {
            Optional<TaxRelief> singleRelief = this.taxReliefList
                    .stream()
                    .filter(tr -> tr.getCivilStatus() == CivilStatus.SINGLE)
                    .findFirst();

            if (singleRelief.isPresent()) {
                return singleRelief.get().getReliefValue();
            }
        }

        if (civilStatus == CivilStatus.MARRIED){
            Optional<TaxRelief> marriedTaxRelief = this.taxReliefList
                    .stream()
                    .filter(tr -> tr.getCivilStatus() == CivilStatus.MARRIED
                                && tr.getNumberOfDependents() == dependentCount)
                    .findFirst();

            if(marriedTaxRelief.isPresent()) {
                return marriedTaxRelief.get().getReliefValue();
            }
        }

        return 0;
    }
    //#endregion
}
