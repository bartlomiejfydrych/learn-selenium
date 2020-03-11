package testerczaki;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class NiestandardoweListy extends TestBase {
    @Test
    public void niestandardoweListy(){
        driver.findElement(By.cssSelector("[href=\"/listy\"]")).click();

        //Zadanie 1
        driver.findElement(By.cssSelector("button:first-of-type")).click();
        driver.findElement(By.cssSelector(".show > a:nth-child(3)")).click();
        Assert.assertTrue(driver.findElement(By.id("alert1")).isDisplayed());

        //Zadanie 2
        driver.findElement(By.cssSelector("button#dropdown_coins")).click();
        driver.findElement(By.id("search2")).sendKeys("Element 2");
        driver.findElement(By.cssSelector("[value=\"Element 2\"]")).click();
        Assert.assertTrue(driver.findElement(By.id("alert2")).isDisplayed());
    }
}
