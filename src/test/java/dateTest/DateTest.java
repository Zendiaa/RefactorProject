/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dateTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.tes1.refactoring.Date;

public class DateTest {

    public DateTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }


    @Test
    public void correctDateTest() {
        Date correctDate = new Date(20, 6, 2008);
        assertTrue(correctDate.validate());

    }

    @Test
    public void correctLeapDateTest() {
        Date goodDayLeapYear1 = new Date(29, 2, 2008);

        Date goodDayLeapYear2 = new Date(29, 2, 2000);

        assertTrue(goodDayLeapYear1.validate());

        assertTrue(goodDayLeapYear2.validate());

    }

    @Test
    public void badLeapDateTest() {
        Date badDayLeapYear = new Date(29, 2, 2007);

        Date badDayLeapYear2 = new Date(29, 2, 1900);
        assertFalse(badDayLeapYear.validate());
        assertFalse(badDayLeapYear2.validate());

    }

    @Test
    public void badMonthTest() {
        Date badMonth = new Date(21, 0, 3000);
        Date badMonth2 = new Date(21, 13, 3000);

        assertFalse(badMonth.validate());
        assertFalse(badMonth2.validate());

    }

    @Test
    public void badDay() {

        Date badDay = new Date(0, 11, 2000);

        Date badDay2 = new Date(32, 11, 2000);

        assertFalse(badDay.validate());

        assertFalse(badDay2.validate());

    }

    @Test
    public void badYearDateTest() {
        Date badYear = new Date(29, 5, 20);
        Date badYear2 = new Date(29, 5, 190);
        assertFalse(badYear.validate());
        assertFalse(badYear2.validate());

    }

}
