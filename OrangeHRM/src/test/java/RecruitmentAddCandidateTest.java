import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RecruitmentAddCandidateTest extends BaseClass {

    @Test
    public void addCandidateTest() throws Exception {
        doLogin("Admin", "admin123");
        driver.findElement(By.xpath("//span[text()='Recruitment']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.findElement(By.name("firstName")).sendKeys("Tanvi");
        Thread.sleep(1000);
        driver.findElement(By.name("middleName")).sendKeys("Rajaram");
        Thread.sleep(1000);
        driver.findElement(By.name("lastName")).sendKeys("Suryawanshi");
        Thread.sleep(1000);
        WebElement vacancyDropdown = driver.findElement(By.xpath("//label[text()='Vacancy']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text')]"));
        vacancyDropdown.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@role='listbox']//span)[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//label[text()='Email']/parent::div/following-sibling::div/input")).sendKeys("tanvi" + (System.currentTimeMillis() % 10000) + "@test.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[text()='Contact Number']/parent::div/following-sibling::div/input")).sendKeys("9876543210");
        Thread.sleep(1000);
        File dummyResume = new File("resume_sample.txt");
        if (!dummyResume.exists()) {
            dummyResume.createNewFile();
        }
        WebElement uploadInput = driver.findElement(By.xpath("//input[@type='file']"));
        uploadInput.sendKeys(dummyResume.getAbsolutePath());
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@placeholder='Enter comma seperated words...']")).sendKeys("Java, Selenium, TestNG");
        Thread.sleep(1000);
        WebElement notesField = driver.findElement(By.xpath("//textarea[@placeholder='Type here']"));
        notesField.sendKeys("Candidate profile automated via Selenium.");
        Thread.sleep(1000);
        WebElement consentCheckbox = driver.findElement(By.xpath("//i[contains(@class,'oxd-checkbox-input-icon')]"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", consentCheckbox);
        Thread.sleep(500);
        js.executeScript("arguments[0].click();", consentCheckbox);
        Thread.sleep(1000);
        WebElement saveBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", saveBtn);
        Thread.sleep(500);
        saveBtn.click();
        Thread.sleep(4000);

      
        driver.quit();
    }
}