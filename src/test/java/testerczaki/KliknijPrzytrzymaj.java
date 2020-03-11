package testerczaki;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class KliknijPrzytrzymaj extends TestBase {

    @Test
    public void kliknijPrzytrzymaj(){
        driver.findElement(By.cssSelector("[href=\"/mysz\"]")).click();

        //Zadanie 1
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("contextClick"))).perform();
        driver.findElement(By.cssSelector(".list-group> li:nth-child(2)")).click();
        Assert.assertTrue(driver.findElement(By.id("alert1")).isDisplayed());

        //Zadanie 2
        actions.clickAndHold(driver.findElement(By.id("holdClick"))).pause(3000).release().perform();
        Assert.assertTrue(driver.findElement(By.id("alert2")).isDisplayed());
    }
}
