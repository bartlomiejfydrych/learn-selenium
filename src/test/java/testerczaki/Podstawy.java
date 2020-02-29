package testerczaki;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Podstawy extends TestBase
{
    @Test
    public void podstawy(){
        driver.findElement(By.id("podstawy")).click();
        driver.findElement(By.id("firstName")).sendKeys("Bogdan");
        driver.findElement(By.id("lastName")).sendKeys("Bogucki");
        driver.findElement(By.id("email")).sendKeys("boguskopytko@amorki.pl");
        driver.findElement(By.id("city")).sendKeys("Chorzów");
        driver.findElement(By.id("street")).sendKeys("Gajowa 2/4a");
        driver.findElement(By.id("rules")).click();
        driver.findElement(By.id("submit")).click();

        Assert.assertTrue(driver.findElement(By.id("alert")).isDisplayed());
    }
}
