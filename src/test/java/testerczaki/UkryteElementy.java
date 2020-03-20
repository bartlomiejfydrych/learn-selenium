package testerczaki;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UkryteElementy extends TestBase
{
    @Test
    public void ukryteElementy(){
        driver.findElement(By.cssSelector("[href=\"/ukryte\"]")).click();

        WebElement form = driver.findElement(By.cssSelector(".container .row:nth-of-type(3) form"));
        form.findElement(By.cssSelector("#firstName")).sendKeys("Bogdan");
        form.findElement(By.cssSelector("#lastName")).sendKeys("Bogucki");
        form.findElement(By.cssSelector("#email")).sendKeys("boguskopytko@amorki.pl");
        form.findElement(By.cssSelector("#city")).sendKeys("Chorzów");
        form.findElement(By.cssSelector("#street")).sendKeys("Gajowa 2/4a");
        form.findElement(By.cssSelector("#rules")).click();
        form.findElement(By.cssSelector("#submit")).click();

        Assert.assertTrue(form.findElement(By.cssSelector("#alert")).isDisplayed());
    }
}
