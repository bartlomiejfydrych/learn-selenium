package testerczaki;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class UkryteElementy extends TestBase
{
    @Test
    public void ukryteElementy(){
        driver.findElement(By.cssSelector("[href=\"/ukryte\"]")).click();
        driver.findElement(By.xpath("(//input[@id='firstName'])[2]")).sendKeys("Bogdan");
        driver.findElement(By.xpath("(//input[@id='lastName'])[2]")).sendKeys("Bogucki");
        driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys("boguskopytko@amorki.pl");
        driver.findElement(By.xpath("(//input[@id='city'])[2]")).sendKeys("Chorzów");
        driver.findElement(By.xpath("(//input[@id='street'])[2]")).sendKeys("Gajowa 2/4a");
        driver.findElement(By.xpath("(//input[@id='rules'])[2]")).click();
        driver.findElement(By.xpath("(//button[@id='submit'])[2]")).click();

        Assert.assertTrue(driver.findElement(By.xpath("(//div[@id='alert'])[2]")).isDisplayed());
    }
}
