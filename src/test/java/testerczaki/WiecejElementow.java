package testerczaki;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class WiecejElementow extends TestBase
{
    @Test
    public void wiecejElementow(){
        driver.findElement(By.id("wiecej")).click();
        driver.findElement(By.id("firstName")).sendKeys("Dawidek");
        driver.findElement(By.id("lastName")).sendKeys("Kopytniak");
        new Select(driver.findElement(By.id("country"))).selectByVisibleText("Tonga");
        new Select(driver.findElement(By.id("lang"))).selectByVisibleText("PHP");
        new Select(driver.findElement(By.id("lang"))).selectByVisibleText("C#");
        driver.findElement(By.id("about")).sendKeys("Kocham małe zwierzątka i uwielbiam długie" +
                                                                   "spacery po plaży. Mój ojciec to fanatyk" +
                                                                   "wędkarstwa oraz piekarz z zamiłowania.");
        driver.findElement(By.id("about")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("about")).sendKeys("Lubi kupować dużo latarek, pracować na ogródku" +
                                                                   "oraz jeść fast foody i popijać Pepsi");
        driver.findElement(By.id("file")).sendKeys("D:\\Nauka\\Tester oprogramowania\\GIT Repozytoria\\Resources\\TextTest.txt");
        driver.findElement(By.id("otherLabel")).click();
        driver.findElement(By.id("rulesLabel")).click();
        driver.findElement(By.id("submit")).click();

        Assert.assertTrue(driver.findElement(By.className("alert-success")).isDisplayed());
    }
}
