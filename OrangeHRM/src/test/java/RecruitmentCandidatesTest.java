import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RecruitmentCandidatesTest extends BaseClass {

    @Test
    public void filterCandidatesTest() throws InterruptedException {
        doLogin("Admin", "admin123");
        driver.findElement(By.xpath("//span[text()='Recruitment']")).click();
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='listbox']//span[text()='Software Engineer']")).click();

        driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='listbox']//span[contains(text(),'Software Engineer')]")).click();

        driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='listbox']//span[contains(text(),'Rahul Patil')]")).click();

        driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[4]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='listbox']//span[text()='Application Initiated']")).click();

        driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("a");
        Thread.sleep(2500);
        driver.findElement(By.xpath("(//div[@role='listbox']//span)[1]")).click();

        driver.findElement(By.xpath("//input[@placeholder='Enter comma seperated words...']")).sendKeys("Java, Selenium");

        WebElement fromCal = driver.findElement(By.xpath("(//i[contains(@class,'bi-calendar')])[1]"));
        js.executeScript("arguments[0].click();", fromCal);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='oxd-calendar-selector-month-selected']")).click();
        driver.findElement(By.xpath("//li[normalize-space()='January']")).click();
        driver.findElement(By.xpath("//div[@class='oxd-calendar-selector-year-selected']")).click();
        driver.findElement(By.xpath("//li[normalize-space()='2026']")).click();
        driver.findElement(By.xpath("//div[contains(@class,'oxd-calendar-date') and text()='15']")).click();
        Thread.sleep(1000);

        WebElement toCal = driver.findElement(By.xpath("(//i[contains(@class,'bi-calendar')])[2]"));
        js.executeScript("arguments[0].click();", toCal);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='oxd-calendar-selector-month-selected']")).click();
        driver.findElement(By.xpath("//li[normalize-space()='December']")).click();
        driver.findElement(By.xpath("//div[@class='oxd-calendar-selector-year-selected']")).click();
        driver.findElement(By.xpath("//li[normalize-space()='2026']")).click();
        driver.findElement(By.xpath("//div[contains(@class,'oxd-calendar-date') and text()='25']")).click();
        Thread.sleep(1000);

        WebElement methodDropdown = driver.findElement(By.xpath("//label[text()='Method of Application']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text')]"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", methodDropdown);
        Thread.sleep(1000);
        methodDropdown.click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//div[@role='listbox']//*[contains(text(),'Online') or contains(text(),'Manual')]")).click();
        Thread.sleep(1000);

        WebElement searchBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", searchBtn);
        Thread.sleep(500);
        searchBtn.click();
        Thread.sleep(3000);

        WebElement resetBtn = driver.findElement(By.xpath("//button[normalize-space()='Reset']"));
        resetBtn.click();
        Thread.sleep(2000);

        driver.quit();
    }
}