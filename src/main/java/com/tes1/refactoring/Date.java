/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.tes1.refactoring;

/**
 *
 * @author zendia
 *
 * @version 2.0
 * 
 * This class is used to store and validate dates.
 *
 */


/*
   The refactor was made by Gisela Arias.
 *
 * Note from the refactorer:
 *
 * The existing of classes that facilitate the creation and validation of dates
 * are not implemented here, because I assume the task is aimed to refactor the
 * code done managing the validation of dates.
 *
 * The purpose is to make the code more manteinable and reduce the possible of errors
*/

public class Date {

    private int day; //Day of the date

    private int month;//Month of the date

    private int year;//Year of the date

    
    /**
     * Constructor of the Date class.
     * @param day of the date
     * @param month of the date
     * @param year of the date
     */
    public Date(int day, int month, int year) {
        if (validate(day, month, year)) {
            setDay(day);
            setMonth(month);
            setYear(year);
        }

    }

    /*
     * Create encapsulated variables. Getters and Setters
     */
    
    /**
     * @return number of the day
     * @since 2.0
     */
    public int getDay() {
        return this.day;
    }

    
    
    /**
     * Establishes the day of the date
     * @param day of the date
     * @since 2.0
     */
    public void setDay(int day) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        }
    }
    
    
    /**
     * @return number of the month
     * @since 2.0
     */
    public int getMonth() {
        return this.month;
    }
    
    
    /**
     * Establishes the month of the date
     * @param month of the date
     * @since 2.0
     */
    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        }
    }

    
    /**
     * @return number of the year
     * @since 2.0
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Establishes the year of the date
     * @param year of the date
     * @since 2.0
     */
    public void setYear(int year) {
        if(checkDigitsYear(year))
            this.year = year;
    }

    
    /*
        Methods to validate the date
    */
    
    
    /**
     * Gets the maximum days that a month can have
     *
     * @return an integer with the maximum days that a month can have
     * @since 2.0
     */
    public int getDaysByMonth() {

        switch (month) {
            case 1, 3, 5, 8, 10, 12:
                return 31;
            case 4, 6, 9, 11:
                return 30;
            case 2: // verificación de año bisiesto
                if (isYearLeap()) {
                    return 29;
                } else {
                    return 28;
                }
        }
        return 0;

    }

    /**
     * Validate the date
     *
     * @return true if the class has a valid date
     * @since 2.0
     */
    public boolean validate() {
        return (month != 0 && (day > 0 && day <= getDaysByMonth()) && year !=0);

    }

    /**
     * Added method, can be used to validate the date before creating it.
     * @param day to validate of a date
     * @param month to validate of a date
     * @param year to validate of a date
     * @return true if it is valid date
     * @since 2.0
     */
    public boolean validate(int day, int month, int year) {

        return (month > 0 && month < 13) && (day > 0 && day <= getDaysByMonth(month, year)) && checkDigitsYear(year);

    }

    /**
     * Gets the maximum days that a month can have
     *
     * @param month is the month we want to get the days of
     * @param year is the year with the one we are going to check if it is leap
     * or not
     * @return an integer with the maximum days that a month can have
     * @since 2.0
     */
    public int getDaysByMonth(int month, int year) {

        switch (month) {
            case 1, 3, 5, 8, 10, 12:
                return 31;
            case 4, 6, 9, 11:
                return 30;
            case 2: // verify of a leap year
                if (isYearLeap(year)) {
                    return 29;
                } else {
                    return 28;
                }
        }

        return 0;
    }

    /**
     * Gets if a year is leap
     *
     * @param year is the year with the one we are going to check if it is leap
     * or not
     * @return true if the year is leap.
     * @since 2.0
     */
    public boolean isYearLeap(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    /**
     * Gets if a year is leap
     *
     * @return true if the year of the date set is leap.
     * @since 2.0
     */
    public boolean isYearLeap() {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    
    
   /**
     * Checks if a year has  four digits
     *
     * @return true if the year of the date is four digits long.
     * @since 2.0
     */
    public boolean checkDigitsYear(){
        String checkDigits = String.valueOf(year);
        return checkDigits.length() == 4;
    }
    /**
     * Checks if a year has  four digits
     * @param year that is going to be checked
     * @return true if the year input is four digits long.
     * @since 2.0
     */
    public boolean checkDigitsYear(int year){
        String checkDigits = String.valueOf(year);
        return checkDigits.length() == 4;
    }
}
