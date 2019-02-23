package com.achilles.enums;

/**
 * Enumeration used to distinguish civil status of a tax requestor.
 * 
 * @version 1.0
 * @author Allan A. Chua
 * @since February 21, 2019
 */
public enum CivilStatus {
  /**
   * Status indicating single people.
   */
  SINGLE,
  /**
   * Status indicating married people.
   */
  MARRIED;

  /**
   * Method used to convert civil status to string.
   * 
   * @return String version of civil status.
   */
  @Override
  public String toString() {
    return super.toString();
  }
}