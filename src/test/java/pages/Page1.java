package pages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class Page1 extends BaseClass {

    public Page1(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@type='radio']")
    private List<WebElement> genderRadioButtons;

    @FindBy(xpath = "//input[@type='checkbox'][@class='form-check-input']")
    private List<WebElement> daysCheckBoxes;

    public void enterName(String name){
        nameInput.sendKeys(name);
    }

    public String getNameFieldValue() {
        return nameInput.getAttribute("value");
    }

    // Select gender by index
    public void selectGender(int i){
        genderRadioButtons.get(i).click();
    }

    public boolean isGenderSelected(int i){
        return genderRadioButtons.get(i).isSelected();
    }

    // Select gender by text
    public void selectGender(String str){
        for (WebElement genderButton: genderRadioButtons){
            if (Objects.requireNonNull(genderButton.getAttribute("value")).equalsIgnoreCase(str)){
                genderButton.click();
                break;
            }
        }
    }

    public boolean isGenderSelected(String str){
        for (WebElement genderButton: genderRadioButtons){
            if (genderButton.getAttribute("value").equalsIgnoreCase(str)){
                genderButton.isSelected();
                return true;
            }
        }
        return false;
    }

    // Select checkbox by index
    public void selectDay(int i){
        daysCheckBoxes.get(i).click();
    }

    // Un select checkbox by index
    public void unSelectDay(int i){
        if(daysCheckBoxes.get(i).isSelected()){
            daysCheckBoxes.get(i).click();
        }
    }

    // Select checkbox by text
    public void selectDay(String day){
        for(WebElement dayCheckbox:daysCheckBoxes){
            if(dayCheckbox.getAttribute("value").equalsIgnoreCase(day)){
                dayCheckbox.click();
                break;
            }
        }
    }

    // Verify checkbox by text
    public boolean isDaySelected(String day){
        for(WebElement dayCheckbox:daysCheckBoxes){
            if(dayCheckbox.getAttribute("value").equalsIgnoreCase(day) ){
                return dayCheckbox.isSelected();
            }
        }
        return false;
    }

    // Un select checkbox by text
    public void unSelectDay(String day){
        for(WebElement dayCheckbox:daysCheckBoxes){
            if(dayCheckbox.getAttribute("value").equalsIgnoreCase(day) && dayCheckbox.isSelected() ){
                dayCheckbox.click();
                break;
            }
        }
    }

    // Select first n checkboxes
    public void selectFirstN(int n){
        for (int i=0; i<n; i++){
            daysCheckBoxes.get(i).click();
        }
    }

    // Select last n checkboxes
    public void selectLastN(int n){
        int size=daysCheckBoxes.size();
        for (int i=size-n; i<size; i++){
            daysCheckBoxes.get(i).click();
        }
    }

    // Select all checkboxes
    public void selectAllCheckboxes(){
        for (WebElement dayCheckbox:daysCheckBoxes){
            dayCheckbox.click();
        }
    }

    // Get count of selected checkboxes
    public int getSelectedDaysCount(){
        int count = 0;
        for (WebElement dayCheckbox:daysCheckBoxes){
            if (dayCheckbox.isSelected()){
                count++;
            }
        }
        return count;
    }

    // Check if a checkbox is selected
    public boolean isDaySelected(int i){
        return daysCheckBoxes.get(i).isSelected();
    }

    // Unselect all checkboxes
    public void unSelectAllDays(){
        for (WebElement dayCheckbox: daysCheckBoxes){
            if (dayCheckbox.isSelected()){
                dayCheckbox.click();
            }
        }
    }

}
