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

        Assert.assertEquals(firstName.getAttribute("value"), "Bogdan");
        Assert.assertEquals(lastName.getAttribute("value"), "Bogucki");
        Assert.assertEquals(email.getAttribute("value"), "boguskopytko@amorki.pl");
        Assert.assertEquals(city.getAttribute("value"), "Chorzów");
        Assert.assertEquals(street.getAttribute("value"), "Gajowa 2/4a");
        Assert.assertTrue(rulesCheckBox.isSelected());
    }
}
