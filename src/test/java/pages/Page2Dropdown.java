package pages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Page2Dropdown extends BaseClass {

    public Page2Dropdown(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(id = "colors")
    private WebElement colorsDropdown;

    @FindBy(id = "animals")
    private WebElement animalDropdown;

    // === Country Dropdown === Single selection

    public void selectCountryByText(String countryName){
//        ScrollToElement(countryDropdown);
        Select dropdown = new Select(countryDropdown);
        dropdown.selectByVisibleText(countryName);
    }

    public void selectCountryByIndex(int i){
        Select dropdown = new Select(countryDropdown);
        dropdown.selectByIndex(i);
    }

    public void selectCountryByValue(String val){
        Select dropdown = new Select(countryDropdown);
        dropdown.selectByValue(val);
    }

    public String getSelectedCountry(){
        Select select = new Select(countryDropdown);
        return select.getFirstSelectedOption().getText();
    }

    // === Colors Dropdown === multiple selection

    public boolean isColorsDropdownMultiple(){
        Select dropdown = new Select(colorsDropdown);
        return dropdown.isMultiple();
    }

    public void selectColorsByText(List<String> colors){
        Select dropdown = new Select(colorsDropdown);
        for (String color: colors){
            dropdown.selectByVisibleText(color);
        }
    }

    public void selectColorsByIndex(List<Integer> indexes){
        Select dropdown = new Select(colorsDropdown);
        for (int i: indexes){
            dropdown.selectByIndex(i);
        }
    }

    public void selectColorsByValue(List<String> colors){
        Select dropdown = new Select(colorsDropdown);
        for (String color: colors){
            dropdown.selectByValue(color);
        }
    }

    public int getSelectedColorsCount(){
        Select dropdown = new Select(colorsDropdown);
        return dropdown.getAllSelectedOptions().size();
    }

    public void deselectAllColors(){
        Select dropdown = new Select(colorsDropdown);
        dropdown.deselectAll();
    }

    public void deselectColorsByText(List<String> colors){
        Select dropdown = new Select(colorsDropdown);
        for (String color: colors){
            dropdown.deselectByVisibleText(color);
        }
    }

    // === Animal Dropdown ===

    public boolean isSortedAlphabetically(){
        Select dropdown = new Select(animalDropdown);

        List<String> animalList = new ArrayList<>();
        for (WebElement animal:dropdown.getOptions()){
            animalList.add(animal.getText());
        }

        List<String> sortedList = new ArrayList<>(animalList);
        Collections.sort(sortedList);

        return animalList.equals(sortedList);
    }

}
