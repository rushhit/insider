package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public void enterText(By by, String text) {
        WebElement element = driver.findElement(by);
        element.sendKeys(text);
    }

    public boolean isElementVisible(By by) {
        WebElement element = driver.findElement(by);
        return element.isDisplayed();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void waitUntilElementIsLoaded(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver1 -> Objects.equals(((JavascriptExecutor) driver1).executeScript("return document.readyState"), "complete"));
    }

    public void waitUntilElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForPositions() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='jobs-list']//div[contains(@class,'position-list-item-wrapper')]//p"),"Senior Software Quality Assurance Engineer"));
        } catch (Exception ignored) {
        }
    }

    public static boolean checkAllTextContains(List<WebElement> elements,String word) {
        for (WebElement element : elements) {
            String text = element.getText().toLowerCase();
            if (!text.contains(word)) {
                return false;
            }
        }
        return true;
    }
}
