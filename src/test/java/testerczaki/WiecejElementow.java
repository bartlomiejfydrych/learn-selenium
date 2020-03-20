package testerczaki;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.Arrays;

public class WiecejElementow extends TestBase {

    @Test
    public void wiecejElementow() {
        driver.findElement(By.id("wiecej")).click();
        driver.findElement(By.id("firstName")).sendKeys("Dawidek");
        driver.findElement(By.id("lastName")).sendKeys("Kopytniak");
        new Select(driver.findElement(By.id("country"))).selectByVisibleText("Tonga");
        Select langSelect = new Select(driver.findElement(By.id("lang")));
        langSelect.selectByVisibleText("PHP");
        langSelect.selectByVisibleText("C#");
        driver.findElement(By.id("about")).sendKeys("Kocham małe zwierzątka i uwielbiam długie" +
                "spacery po plaży. Mój ojciec to fanatyk" +
                "wędkarstwa oraz piekarz z zamiłowania." + "\nLubi kupować dużo latarek, pracować na ogródku" +
                "oraz jeść fast foody i popijać Pepsi");
        String textTest = new File("src/test/resources/TextTest.txt").getAbsolutePath();
        driver.findElement(By.id("file")).sendKeys(textTest);
        driver.findElement(By.id("otherLabel")).click();
        driver.findElement(By.id("rulesLabel")).click();
        driver.findElement(By.id("submit")).click();

        Assert.assertTrue(driver.findElement(By.className("alert-success")).isDisplayed());
    }
}
