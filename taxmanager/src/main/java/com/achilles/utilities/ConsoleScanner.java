package com.achilles.utilities;

import com.achilles.contracts.ConsoleScannerContract;

import java.util.Scanner;

/**
 * Class used for scanning console inputs.
 *
 * @author Allan A. Chua
 * @version 1.0
 * @since February 24, 2019
 */
public class ConsoleScanner implements ConsoleScannerContract {
    //#region Constants
    private final static String EMPTY_STRING = "";
    //#endregion

    //#region Public Methods
    /**
     * Method used for executing module.
     *
     * @return Input gathered from console line.
     */
    @Override
    public String execute() {
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
    //#endregion
}
