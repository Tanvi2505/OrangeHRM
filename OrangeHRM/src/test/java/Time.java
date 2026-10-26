import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Time extends BaseClass {
    @Test
    public void viewEmployeeTimesheet() throws InterruptedException {
        doLogin("Admin", "admin123");
        driver.findElement(By.xpath("//span[text()='Time']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("a");
        Thread.sleep(2500);
        driver.findElement(By.xpath("(//div[@role='listbox']//span)[1]")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        boolean isTimesheetDisplayed = driver.findElement(By.xpath("//div[contains(@class,'orangehrm-timesheet-body')] | //h6[contains(.,'Timesheet')]")).isDisplayed();
        Assert.assertTrue(isTimesheetDisplayed, "Timesheet view failed to open!");
        driver.quit();
    }
}