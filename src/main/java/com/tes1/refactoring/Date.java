/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.tes1.refactoring;

/**
 *
 * @author antonia
 *
 *
 * The refactor was made by Gisela Arias.
 *
 * Note from the refactorer:
 *
 * The existing of classes that facilitate the creation and validation of dates
 * are not implemented here, because I assume the task is aimed to refactor the
 * code done managing the validation of dates.
 *
 * The purpose is to make the code more manteinable and reduce the possible of errors
 *
 *
 *
 */
public class Date {

    private int day;

    private int month;

    private int year;

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
    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        }
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        }
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        if(checkDigitsYear(year))
            this.year = year;
    }

    /**
     * Gets the maximum days that a month can have
     *
     * @retrun an integer with the maximum days that a month can have
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
     */
    public boolean validate() {
        return (month != 0 && (day > 0 && day <= getDaysByMonth()) && year !=0);

    }

    /**
     * Added method, can be used to validate the date before creating it.
     *
     * @return true if it is valid date
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
     * @retrun an integer with the maximum days that a month can have
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
     * @retrun true if the year is leap.
     */
    public boolean isYearLeap(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    /**
     * Gets if a year is leap
     *
     * @retrun true if the year of the date set is leap.
     */
    public boolean isYearLeap() {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    
    
   /**
     * Checks if a year has  four digits
     *
     * @retrun true if the year of the date is four digits long.
     */
    public boolean checkDigitsYear(){
        String checkDigits = String.valueOf(year);
        return checkDigits.length() == 4;
    }
    /**
     * Checks if a year has  four digits
     *
     * @retrun true if the year input is four digits long.
     */
    public boolean checkDigitsYear(int year){
        String checkDigits = String.valueOf(year);
        return checkDigits.length() == 4;
    }
}
