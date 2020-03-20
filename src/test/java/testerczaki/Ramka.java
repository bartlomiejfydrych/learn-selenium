package testerczaki;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Ramka extends TestBase {

    @Test
    public void ramka(){
        driver.findElement(By.cssSelector("[href=\"/ramka\"]")).click();
        driver.switchTo().frame("frame");
        driver.findElement(By.id("firstName")).sendKeys("Bogdan");
        driver.findElement(By.id("lastName")).sendKeys("Bogucki");
        driver.findElement(By.id("email")).sendKeys("boguskopytko@amorki.pl");
        driver.findElement(By.id("city")).sendKeys("Chorzów");
        driver.findElement(By.id("street")).sendKeys("Gajowa 2/4a");
        driver.findElement(By.id("rules")).click();
        driver.findElement(By.id("submit")).click();
        Assert.assertTrue(driver.findElement(By.id("alert")).isDisplayed());
        driver.switchTo().defaultContent();
    }
}
