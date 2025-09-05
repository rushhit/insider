package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class QAJobsPage extends BasePage {

    private final By seeAllQAJobsButton = By.xpath("//a[contains(text(),'See all QA jobs')]");
    private final By acceptBtn = By.cssSelector("#wt-cli-accept-all-btn");
    private final By locationFilter = By.cssSelector("#select2-filter-by-location-container");
    private final By departmentFilter = By.cssSelector("#select2-filter-by-department-container");
    private final By departmentLabel = By.xpath("//span[@title='Quality Assurance']");
    private final By positionText = By.xpath("//div[@id='jobs-list']//div[contains(@class,'position-list-item-wrapper')]//p");
    private final By departmentText = By.xpath("//div[@id='jobs-list']//div[contains(@class,'position-list-item-wrapper')]//span");
    private final By locationText = By.xpath("//div[@id='jobs-list']//div[contains(@class,'position-list-item-wrapper')]//div[@class='position-location text-large']");
    private final By viewRoleButton = By.xpath("//a[text()='View Role']");

    public QAJobsPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToQAJobsPage() {
        driver.get("https://useinsider.com/careers/quality-assurance/");
        click(acceptBtn);
        driver.switchTo().parentFrame();
    }

    public void clickSeeAllQAJobs() {
        click(seeAllQAJobsButton);
        waitUntilPageLoaded();
    }

    public void filterJobs(String location, String department) {
        waitUntilElementVisible(departmentLabel);
        click(locationFilter);
        click(By.xpath("//li[contains(text(),'" + location + "')]"));
        click(departmentFilter);
        click(By.xpath("//li[contains(text(),'" + department + "')]"));
    }

    public boolean getJobPosition() {
        waitForPositions();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600)");
        return driver.findElements(positionText).get(1).getText().contains("Quality Assurance");
    }

    public boolean getJobDepartment() {
        return driver.findElements(departmentText).get(1).getText().contains("Quality Assurance");
    }

    public boolean getJobLocation() {
        return driver.findElements(locationText).get(1).getText().contains("Istanbul, Turkiye");
    }

    public void clickViewRole() {
        click(viewRoleButton);
    }
}
