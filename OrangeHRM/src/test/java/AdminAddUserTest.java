import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminAddUserTest extends BaseClass {
    @Test
    public void adminProcessTest() throws InterruptedException {
        doLogin("Admin", "admin123");
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@role='listbox']//span[text()='Admin']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("a");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@role='listbox']//span)[1]")).click();
        driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@role='listbox']//span[text()='Enabled']")).click();
        String uniqueUsername = "tanviUser" + (System.currentTimeMillis() % 10000);
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(uniqueUsername);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Tanvi@2505!");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Tanvi@2505!");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(4000);
        boolean isUserList = driver.findElement(By.xpath("//h5[normalize-space()='System Users']")).isDisplayed();
        Assert.assertTrue(isUserList, "Admin process failed to save user!");
        
    }
}