package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By companyMenu = By.xpath("//li/a[contains(text(),'Company')]");
    private final By careersLink = By.xpath("//a[contains(text(),'Careers')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String isHomePageLoaded() {
        return driver.getTitle();
    }

    public void goToCareersPage() {
        click(companyMenu);
        click(careersLink);
    }
}
