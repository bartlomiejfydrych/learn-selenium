package testerczaki;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class WiecejRamek extends TestBase {
    @Test
    public void wiecejRamek() {
        driver.findElement(By.cssSelector("[href=\"/ramki\"]")).click();

        WebElement iframe2 = driver.findElement(By.cssSelector("[src=\"/iframe2.php\"]"));
        driver.switchTo().frame(iframe2);

        WebElement iframe3 = driver.findElement(By.cssSelector("[src=\"/iframe3.php\"]"));
        WebElement iframe4 = driver.findElement(By.cssSelector("[src=\"/iframe4.php\"]"));

        driver.findElement(By.id("firstName")).sendKeys("Bogdan");
        driver.findElement(By.id("lastName")).sendKeys("Bogucki");
        driver.switchTo().frame(iframe3);
        driver.findElement(By.id("email")).sendKeys("boguskopytko@amorki.pl");
        driver.switchTo().parentFrame();
        driver.switchTo().frame(iframe4);
        driver.findElement(By.id("city")).sendKeys("Chorzów");

        driver.switchTo().defaultContent();
        WebElement iframe5 = driver.findElement(By.cssSelector("[src=\"/iframe5.php\"]"));
        driver.switchTo().frame(iframe5);
        driver.findElement(By.id("street")).sendKeys("Gajowa 2/4a");

        driver.switchTo().defaultContent();
        driver.findElement(By.id("rules")).click();
        driver.findElement(By.id("submit")).click();

        Assert.assertTrue(driver.findElement(By.id("alert")).isDisplayed());
    }
}
