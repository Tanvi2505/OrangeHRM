import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminSearch extends BaseClass{

    @Test
    public void searchUserInAdmin() throws InterruptedException {
        doLogin("Admin", "admin123");
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("Admin");
        driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='listbox']//span[text()='Admin']")).click();
        driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='listbox']//span[text()='Enabled']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        boolean isResultFound = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[contains(text(),'Admin')]")).isDisplayed();
        Assert.assertTrue(isResultFound, "Search failed: User record not found in table!");
        driver.findElement(By.xpath("//button[normalize-space()='Reset']")).click();
        Thread.sleep(2000);
    }
}