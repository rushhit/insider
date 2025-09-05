package test;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CareerPage;
import pages.HomePage;
import pages.QAJobsPage;

import java.util.Set;

public class JobApplicationTest extends BaseClass {

    @Test(priority = 1)
    public void testHomePage() {
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.isHomePageLoaded(), "#1 Leader in Individualized, Cross-Channel CX — Insider");
    }

    @Test(priority = 2)
    public void testCareerPage() {
        HomePage homePage = new HomePage(driver);
        homePage.goToCareersPage();
        CareerPage careerPage = new CareerPage(driver);
        Assert.assertTrue(careerPage.areCareerPageBlocksVisible(), "Career page blocks are not visible.");
    }

    @Test(priority = 3)
    public void testQAJobList() {
        QAJobsPage qaJobsPage = new QAJobsPage(driver);
        qaJobsPage.navigateToQAJobsPage();
        qaJobsPage.clickSeeAllQAJobs();
        qaJobsPage.filterJobs("Istanbul, Turkiye", "Quality Assurance");
    }

    @Test(priority = 4)
    public void testJobDetails() {
        QAJobsPage qaJobsPage = new QAJobsPage(driver);
        Assert.assertTrue(qaJobsPage.getJobPosition());
        Assert.assertTrue(qaJobsPage.getJobDepartment());
        Assert.assertTrue(qaJobsPage.getJobLocation());
    }

    @Test(priority = 5)
    public void testViewRoleRedirect() {
        QAJobsPage qaJobsPage = new QAJobsPage(driver);
        qaJobsPage.clickViewRole();
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://jobs.lever.co/useinsider/"));
    }
}
