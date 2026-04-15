package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseClass(WebDriver driver){
        this.driver= driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public boolean isElementDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public void ScrollToElement(WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);"
                ,element);
    }

}
