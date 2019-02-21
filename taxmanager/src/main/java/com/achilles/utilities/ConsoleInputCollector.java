package com.achilles.utilities;

import com.achilles.contracts.InputCollector;
import com.achilles.models.TaxCalculationRequest;

import java.util.Scanner;

/**
 * Class used for collecting input from console.
 *
 * @version 1.0
 * @author Allan A. Chua
 * @since February 21, 2019
 */
public class ConsoleInputCollector implements InputCollector {
    //#region Constants
    private final static String WELCOME_MESSAGE = "Welcome to Achilles Tax Manager";
    private final static String PROVIDE_MONTHLY_INCOME = "Please provide your monthly income: ";
    private final static String EMPTY_STRING = "";
    private final static String SEPARATOR = ",";
    //#endregion

    //#region Constructors
    public ConsoleInputCollector() {
        this.request = new TaxCalculationRequest();
    }
    //#endregion

    //#region Fields
    private TaxCalculationRequest request;
    //#endregion

    //#region Private Methods
    private void logMessageLine(String input) {
        System.out.println(input);
    }

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

    private float getNumber(String msg) {
        String output;

        do {
            logMessage(msg);
            output = scanLine();
            output = cleanNumericString(output);
        } while (!isNumeric(output));

        return Float.parseFloat(output);
    }
    //#endregion

    /**
     * Method used for executing the input collector.
     *
     * @return Tax calculation request information (Monthly income, civil status and
     *         number of dependents.)
     */
    @Override
    public TaxCalculationRequest execute() {
        logMessageLine(WELCOME_MESSAGE);
        request.setMonthlyIncome(getNumber(PROVIDE_MONTHLY_INCOME));

        return request;
    }
}
