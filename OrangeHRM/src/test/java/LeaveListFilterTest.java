import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeaveListFilterTest extends BaseClass {
    @Test
    public void filterLeaveList() throws InterruptedException {
        doLogin("Admin", "admin123");
        driver.findElement(By.xpath("//span[text()='Leave']")).click();
        Thread.sleep(2000);
        WebElement fromDate = driver.findElement(By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]"));
        fromDate.sendKeys("2026-01-01");
        WebElement toDate = driver.findElement(By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]"));
        toDate.sendKeys("2026-31-12");
        driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='listbox']//span[contains(text(),'CAN')]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("a");
        Thread.sleep(2500);
        driver.findElement(By.xpath("(//div[@role='listbox']//span)[1]")).click();
        driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@role='listbox']//span)[2]")).click();
        driver.findElement(By.xpath("//span[contains(@class,'oxd-switch-input')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Reset']")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}