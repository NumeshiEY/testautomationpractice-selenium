package tests;

import base.TestBase;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Page1;

import static utils.ExpectedResults.PAGE_TITLE;

public class Page1Test extends TestBase {

    private Page1 page1;

    @Test(priority = 1)
    @Description("Verify the page title")
    public void testPageTitle() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,PAGE_TITLE,
                "Page title does not match the expected value");
    }

    @Test(priority = 2)
    @Description("Verify valid name entry")
    public void testValidNameEntry() {
        page1 = new Page1(driver);
        page1.enterName("Numeshi");
        Assert.assertEquals(page1.getNameFieldValue(),"Numeshi",
                "Name field value does not match the expected input");
    }

    @Test(priority = 3)
    @Description("Verify the gender radio button functionality - Select by index")
    public void testGenderRadioButtonByIndex() {
        page1 = new Page1(driver);
        page1.selectGender(0);
        Assert.assertTrue(page1.isGenderSelected(0),"Selected option is not found");
    }

    @Test(priority = 4)
    @Description("Verify the gender radio button functionality - Select by text")
    public void testGenderRadioButtonByText() {
        page1 = new Page1(driver);
        page1.selectGender("Female");
        Assert.assertTrue(page1.isGenderSelected("Female"),"Selected option is not found");
    }

    @Test(priority = 5)
    @Description("Select a single day - by index")
    public void testSelectSingleDayIndex(){
        page1.selectDay(0);
        Assert.assertTrue(page1.isDaySelected(0),"Selected checkbox is not checked.");
    }

    @Test(priority = 6, dependsOnMethods = "testSelectSingleDayIndex")
    @Description("Uncheck a selected checkbox - by index")
    public void testUncheckSelectedCheckboxIndex(){
        page1.unSelectDay(0);
        Assert.assertFalse(page1.isDaySelected(0),"Selected checkbox is checked.");
    }

    @Test(priority = 7)
    @Description("Select a single day - by text")
    public void testSelectSingleDayText(){
        page1.selectDay("Sunday");
        Assert.assertTrue(page1.isDaySelected("sunday"),"Selected checkbox is not checked.");
    }

    @Test(priority = 8, dependsOnMethods = "testSelectSingleDayText")
    @Description("Uncheck a selected checkbox - by text")
    public void testUncheckSelectedCheckboxText(){
        page1.unSelectDay("Sunday");
        Assert.assertFalse(page1.isDaySelected("sunday"),"Selected checkbox is checked.");
    }

    @Test(priority = 9)
    @Description("Select multiple day checkboxes")
    public void testSelectMultipleDays(){
        driver.navigate().refresh();
        page1.selectDay(0);
        page1.selectDay(3);
        page1.selectDay(5);
        Assert.assertTrue(page1.getSelectedDaysCount()>1,"Multiple selection were not selected correctly.");
    }

    @Test(priority = 10)
    @Description("Select all days")
    public void testSelectAllDays(){
        driver.navigate().refresh();
        page1.selectAllCheckboxes();
        Assert.assertEquals(page1.getSelectedDaysCount(),7,"All days are not selected.");
    }

    @Test(priority = 11, dependsOnMethods = "testSelectAllDays")
    @Description("Unselect all days")
    public void testUnselectAllDays(){
        page1.unSelectAllDays();
        Assert.assertEquals(page1.getSelectedDaysCount(),0,"All days are still selected.");
    }


    @Test(priority = 12)
    @Description("Select first N day checkboxes")
    public void testSelectFirstN(){
        driver.navigate().refresh();
        page1.selectFirstN(4);
        Assert.assertEquals(page1.getSelectedDaysCount(),4,"First N day were not selected correctly.");
    }

    @Test(priority = 13)
    @Description("Select first N day checkboxes")
    public void testSelectLastN(){
        driver.navigate().refresh();
        page1.selectLastN(4);
        Assert.assertEquals(page1.getSelectedDaysCount(),4,"Last N day were not selected correctly.");
    }

}
