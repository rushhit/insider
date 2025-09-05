package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareerPage extends BasePage {

    private final By locationsBlock = By.xpath("//h3[contains(text(),'Locations')]");
    private final By teamsBlock = By.xpath("//a[contains(text(),'teams')]");
    private final By lifeAtInsiderBlock = By.xpath("//h2[contains(text(),'Life at Insider')]");

    public CareerPage(WebDriver driver) {
        super(driver);
    }

    public boolean areCareerPageBlocksVisible() {
        return isElementVisible(locationsBlock) && isElementVisible(teamsBlock) && isElementVisible(lifeAtInsiderBlock);
    }
}
