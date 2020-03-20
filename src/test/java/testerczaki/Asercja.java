package testerczaki;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Asercja extends TestBase
{
    @Test
    public void asercja(){
        driver.findElement(By.id("asercja")).click();

        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement city = driver.findElement(By.id("city"));
        WebElement street = driver.findElement(By.id("street"));
        WebElement rulesCheckBox = driver.findElement(By.id("rulesLabel"));

        firstName.sendKeys("Bogdan");
        lastName.sendKeys("Bogucki");
        email.sendKeys("boguskopytko@amorki.pl");
        city.sendKeys("Chorzów");
        street.sendKeys("Gajowa 2/4a");
        rulesCheckBox.click();
        driver.findElement(By.id("submit")).click();

        Assert.assertEquals("Bogdan", firstName.getAttribute("value"));
        Assert.assertEquals("Bogucki", lastName.getAttribute("value"));
        Assert.assertEquals("boguskopytko@amorki.pl", email.getAttribute("value"));
        Assert.assertEquals("Chorzów", city.getAttribute("value"));
        Assert.assertEquals("Gajowa 2/4a", street.getAttribute("value"));
        Assert.assertTrue(rulesCheckBox.isSelected());
    }
}
