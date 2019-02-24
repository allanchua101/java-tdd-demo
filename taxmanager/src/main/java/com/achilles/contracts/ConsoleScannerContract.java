package com.achilles.contracts;

/**
 * Interface that mandate implementation resilient
 * capture of data from a console line.
 *
 * @author Allan A. Chua
 * @version 1.0
 * @since February 24, 2019
 */
public interface ConsoleScannerContract {
    /**
     * Method used for executing module.
     *
     * @return Input gathered from console line.
     */
    String execute();
}
