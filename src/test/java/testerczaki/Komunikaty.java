package testerczaki;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class Komunikaty extends TestBase
{
    @Test
    public void komunikaty(){
        driver.findElement(By.cssSelector("[href=\"/komunikaty\"]")).click();
        driver.findElement(By.id("msgBtn")).click();
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        driver.findElement(By.id("msg")).sendKeys(text);
        driver.findElement(By.id("submit")).click();
        alert.accept();
        alert.dismiss();
        alert.sendKeys("tak");
        alert.accept();

        Assert.assertTrue(driver.findElement(By.id("alert")).isDisplayed());
    }
}
