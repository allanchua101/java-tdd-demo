package com.achilles.utilities;

import com.achilles.contracts.InputCollectorContract;
import com.achilles.enums.CivilStatus;
import com.achilles.models.TaxCalculationRequest;

import java.util.Scanner;

/**
 * Class used for collecting input from console.
 *
 * @version 1.0
 * @author Allan A. Chua
 * @since February 21, 2019
 */
public class InputCollector implements InputCollectorContract {
    //#region Constants
    private final static String WELCOME_MESSAGE = "------------------------------Achilles Systems - Tax Calculator-----------------------------";
    private final static String PROVIDE_MONTHLY_INCOME = "Monthly income: ";
    private final static String CIVIL_STATUS_CAPTURE_MESSAGE = "Civil Status (Single - 1; Married - 2;): ";
    private final static String PROVIDE_NUMBER_OF_DEPENDENTS = "Number of dependents: ";
    private final static String EMPTY_STRING = "";
    private final static String SEPARATOR = ",";
    //#endregion

    //#region Constructors
    public InputCollector() {
        this.request = new TaxCalculationRequest();
    }
    //#endregion

    //#region Fields
    private TaxCalculationRequest request;
    //#endregion

    //#region Private Methods
    private void logMessage(String input) {
        System.out.print(input);
    }

    private String scanLine() {
        String output = EMPTY_STRING;

        while(output.equals(EMPTY_STRING)) {
            try {
                Scanner input = new Scanner(System.in);
                output = input.nextLine();
            } catch (Exception ex) {
                output = EMPTY_STRING;
            }
        }

        return output;
    }

    private boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    private String cleanNumericString(String input) {
        return input.replaceAll(SEPARATOR, EMPTY_STRING);
    }

    private float getMonthlySalary() {
        String input;

        do {
            logMessage(PROVIDE_MONTHLY_INCOME);
            input = scanLine();
            input = cleanNumericString(input);
        } while (!isNumeric(input));

        return Float.parseFloat(input);
    }

    private int getNumberOfDependents() {
        String input;

        do {
            logMessage(PROVIDE_NUMBER_OF_DEPENDENTS);
            input = scanLine();
            input = cleanNumericString(input);
        } while (!isNumeric(input));

        return Integer.parseInt(input);
    }

    private CivilStatus getCivilStatus() {
        String input;
        boolean isValidNumber;
        boolean isWithinLimit;
        int civilStatusId = 0;

        do {
            logMessage(CIVIL_STATUS_CAPTURE_MESSAGE);

            input = scanLine();
            input = cleanNumericString(input);

            isValidNumber = isNumeric(input);

            if(isValidNumber) {
                civilStatusId = Integer.parseInt(input);
                isWithinLimit = civilStatusId <= CivilStatus.values().length && civilStatusId > 0;
            } else {
                isWithinLimit = false;
            }
        } while(!isValidNumber || !isWithinLimit);

        return CivilStatus.values()[civilStatusId - 1];
    }
    //#endregion

    //#region Public Methods
    /**
     * Method used for executing the input collector.
     *
     * @return Tax calculation request information (Monthly income, civil status and
     *         number of dependents.)
     */
    @Override
    public TaxCalculationRequest execute() {
        System.out.println(WELCOME_MESSAGE);

        float monthlyIncome = getMonthlySalary();
        request.setMonthlyIncome(monthlyIncome);

        CivilStatus civilStatus = getCivilStatus();
        request.setCivilStatus(civilStatus);

        if(civilStatus.equals(CivilStatus.MARRIED)) {
            int numberOfDependents = getNumberOfDependents();
            request.setDependentCount(numberOfDependents);
        }

        return request;
    }
    //#endregion
}
