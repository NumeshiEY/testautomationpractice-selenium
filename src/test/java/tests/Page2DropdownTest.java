package tests;

import base.TestBase;
import jdk.jfr.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Page2Dropdown;

import java.util.Arrays;

public class Page2DropdownTest extends TestBase {

    private Page2Dropdown page2Dropdown;

//    @BeforeClass
//    public void setUp() {
//        page2Dropdown = new Page2Dropdown(driver);
//    }

    @Test(priority = 1)
    @Description("Verify that a country is selected - Using text")
    public void testCountrySelectionByText(){
        page2Dropdown = new Page2Dropdown(driver);
        page2Dropdown.selectCountryByText("Canada");
        Assert.assertEquals(page2Dropdown.getSelectedCountry(),"Canada",
                "Country selection is failed.");
    }

    @Test(priority = 2)
    @Description("Verify that a country is selected - Using index")
    public void testCountrySelectionByIndex(){
        driver.navigate().refresh();
        scrollDownSlightly();
        page2Dropdown.selectCountryByIndex(5);
        Assert.assertNotNull(page2Dropdown.getSelectedCountry(),
                "Country selection is failed.");
    }

    @Test(priority = 3)
    @Description("Verify that a country is selected - Using value")
    public void testCountrySelectionByValue(){
        driver.navigate().refresh();
        page2Dropdown.selectCountryByValue("india");
        Assert.assertEquals(page2Dropdown.getSelectedCountry(),"India",
                "Country selection is failed.");
    }

    @Test(priority = 4)
    @Description("Verify colors dropdown support multiple selection.")
    public void testColorsDropdownIsMultiple(){
        Assert.assertTrue(page2Dropdown.isColorsDropdownMultiple(),
                "Colors dropdown should support multiple selection.");
    }

    @Test(priority = 5)
    @Description("Verify multiple colors is selected - using text")
    public void testMultipleColorsByText(){
        driver.navigate().refresh();
        page2Dropdown.selectColorsByText(Arrays.asList("Red","Blue","Green"));
        Assert.assertEquals(page2Dropdown.getSelectedColorsCount(),5,
                "Multiple color selection is failed.");
    }

    @Test(priority = 6)
    @Description("Verify multiple colors is selected - using index")
    public void testMultipleColorsByIndex(){
        driver.navigate().refresh();
        page2Dropdown.selectColorsByIndex(Arrays.asList(1,3,5));
        Assert.assertEquals(page2Dropdown.getSelectedColorsCount(),3,
                "Multiple color selection is failed.");
    }

    @Test(priority = 7)
    @Description("Verify multiple colors is selected - using value")
    public void testMultipleColorsByValue(){
        driver.navigate().refresh();
        page2Dropdown.selectColorsByValue(Arrays.asList("blue","green","yellow"));
        Assert.assertEquals(page2Dropdown.getSelectedColorsCount(),4,
                "Multiple color selection is failed.");
    }

    @Test(priority = 8)
    @Description("Verify user can deselect selected colors.")
    public void testDeselectionColors(){
        driver.navigate().refresh();
        page2Dropdown.selectColorsByText(Arrays.asList("Yellow","Blue","Green"));
        page2Dropdown.deselectColorsByText(Arrays.asList("Blue","Green"));
        Assert.assertEquals(page2Dropdown.getSelectedColorsCount(),1,
                "Color deselection is failed.");
    }

    @Test(priority = 9)
    @Description("Verify user can deselect all selected colors.")
    public void testDeselectionAllColors(){
        driver.navigate().refresh();
        page2Dropdown.selectColorsByText(Arrays.asList("Yellow","Blue","Green"));
        page2Dropdown.deselectAllColors();
        Assert.assertEquals(page2Dropdown.getSelectedColorsCount(),0,
                "Color deselection is failed.");
    }

    @Test(priority = 10)
    @Description("Verify animal dropdown is sorted alphabetically")
    public void testAnimalDropdown(){
        Assert.assertTrue(page2Dropdown.isSortedAlphabetically());
    }

//    @BeforeMethod
//    public void pageReset(){
//        driver.navigate().refresh();
//    }


    private void scrollDownSlightly() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0, 600);");
    }


}
