package testerczaki;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpcjonalnyFormularz extends TestBase
{
    @Test
    public void opcjonalnyFormularz(){
        driver.findElement(By.cssSelector("[href=\"/opcjonalny\"]")).click();
        driver.findElement(By.id("firstName")).sendKeys("Bogdan");
        driver.findElement(By.id("lastName")).sendKeys("Bogucki");
        driver.findElement(By.id("email")).sendKeys("boguskopytko@amorki.pl");
        driver.findElement(By.cssSelector("label[for=\"add\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city"))).sendKeys("Chorzów");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("street"))).sendKeys("Gajowa 2/4a");

        driver.findElement(By.id("submit")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("button#submit")).isDisplayed());
    }
}
