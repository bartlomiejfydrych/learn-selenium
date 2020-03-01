package testerczaki;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class Lokalizatory extends TestBase
{
    @Test
    public void lokalizatory(){
        driver.findElement(By.cssSelector("[href=\"/lokalizatory\"]")).click();
        driver.findElement(By.className("firstName")).sendKeys("Dawidek");
        driver.findElement(By.cssSelector("[placeholder=\"Nazwisko\"]")).sendKeys("Kopytniak");
        new Select(driver.findElement(By.className("custom-select"))).selectByVisibleText("Tonga");
        new Select(driver.findElement(By.cssSelector("select.form-control"))).selectByVisibleText("PHP");
        new Select(driver.findElement(By.cssSelector("select.form-control"))).selectByVisibleText("C#");
        driver.findElement(By.cssSelector("textarea.form-control")).sendKeys("Kocham małe zwierzątka i uwielbiam długie" +
                                                                    "spacery po plaży. Mój ojciec to fanatyk" +
                                                                    "wędkarstwa oraz piekarz z zamiłowania.");
        driver.findElement(By.cssSelector("textarea.form-control")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("textarea.form-control")).sendKeys("Lubi kupować dużo latarek, pracować na ogródku" +
                                                                    "oraz jeść fast foody i popijać Pepsi");
        driver.findElement(By.className("form-control-file")).sendKeys("D:\\Nauka\\Tester oprogramowania\\GIT Repozytoria\\Resources\\TextTest.txt");
        driver.findElement(By.cssSelector("div .custom-radio:nth-of-type(3) label")).click();
        driver.findElement(By.cssSelector(".custom-checkbox > .custom-control-label")).click();
        driver.findElement(By.className("btn-md")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-success[role=\"alert\"]")).isDisplayed());
    }
}
