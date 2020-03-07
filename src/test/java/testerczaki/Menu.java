package testerczaki;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Menu extends TestBase
{
    @Test
    public void menu(){
        driver.findElement(By.cssSelector("[href=\"/menu\"]")).click();

        driver.findElement(By.cssSelector("nav.navbar-expand > .collapse > .navbar-nav > a:nth-child(2)")).click();
        Assert.assertTrue(driver.findElement(By.id("alert1")).isDisplayed());

        driver.findElement(By.className("m-2")).click();
        driver.findElement(By.cssSelector("#navbarNavAltMarkup > .navbar-nav > a:nth-child(3)")).click();
        Assert.assertTrue(driver.findElement(By.id("alert2")).isDisplayed());

        driver.findElement(By.cssSelector("[role=\"button\"]")).click();
        driver.findElement(By.cssSelector(".show > a:nth-child(3)")).click();
        Assert.assertTrue(driver.findElement(By.id("alert3")).isDisplayed());

        Actions action1 = new Actions(driver);
        WebElement hover = driver.findElement(By.cssSelector("nav:nth-child(17) > div.navbar-collapse > div.navbar-nav > ul.mr-auto > li.nav-item.dropdown.hover > a"));
        action1.moveToElement(hover).moveToElement(driver.findElement(By.cssSelector("li.hover > .dropdown-menu> a:nth-child(2)"))).click().build().perform();
        Assert.assertTrue(driver.findElement(By.id("alert4")).isDisplayed());

        Actions action2 = new Actions(driver);
        WebElement hover2 = driver.findElement(By.cssSelector("nav:nth-child(21) > div.navbar-collapse > div.navbar-nav > ul.mr-auto > li.nav-item.dropdown.hover > a"));
        WebElement hover3 = driver.findElement(By.className("hover2nd"));
        WebElement hover4 = driver.findElement(By.cssSelector(".dropdown2nd > a:nth-child(1)"));
        WebElement hover5 = driver.findElement(By.cssSelector(".dropdown2nd > a:nth-child(5)"));
        action2.moveToElement(hover2).moveToElement(hover3).click().moveToElement(hover4).moveToElement(hover5).click().build().perform();
        Assert.assertTrue(driver.findElement(By.id("alert5")).isDisplayed());
    }
}
