package testerczaki;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class OknaZakladki extends TestBase {

    @Test
    public void Zakladki() {
        driver.findElement(By.cssSelector("[href=\"/okna\"]")).click();
        driver.findElement(By.id("newTab")).click();
        List<String> tabs2 = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs2.get(1)); //Tab number

        driver.findElement(By.id("firstName")).sendKeys("Bogdan");
        driver.findElement(By.id("lastName")).sendKeys("Bogucki");
        driver.findElement(By.id("email")).sendKeys("boguskopytko@amorki.pl");
        driver.findElement(By.id("city")).sendKeys("Chorzów");
        driver.findElement(By.id("street")).sendKeys("Gajowa 2/4a");
        driver.findElement(By.id("rules")).click();
        driver.findElement(By.id("submit")).click();

        Assert.assertTrue(driver.findElement(By.id("alert")).isDisplayed());
        driver.close();

        driver.switchTo().window(tabs2.get(0));
    }

    @Test
    public void Okna() {
        driver.findElement(By.cssSelector("[href=\"/okna\"]")).click();
        driver.findElement(By.id("newWindow")).click();
        List<String> windows2 = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(windows2.get(1)); //Window number
        driver.manage().window().maximize();

        driver.findElement(By.id("firstName")).sendKeys("Bogdan");
        driver.findElement(By.id("lastName")).sendKeys("Bogucki");
        driver.findElement(By.id("email")).sendKeys("boguskopytko@amorki.pl");
        driver.findElement(By.id("city")).sendKeys("Chorzów");
        driver.findElement(By.id("street")).sendKeys("Gajowa 2/4a");
        driver.findElement(By.id("rules")).click();
        driver.findElement(By.id("submit")).click();

        Assert.assertTrue(driver.findElement(By.id("alert")).isDisplayed());
        driver.close();

        driver.switchTo().window(windows2.get(0));
    }
}
