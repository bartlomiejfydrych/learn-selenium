package testerczaki;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class PrzeciagnijUpusc extends TestBase {

    @Test
    public void przeciagnijUpusc() throws IOException {
        driver.findElement(By.cssSelector("[href=\"/przeciagnij\"]")).click();

        // Zadanie 1
        List<WebElement> webElementsZadanie1 = new ArrayList<WebElement>();
        for (int i = 1; i <= 3; i++) {
            webElementsZadanie1.add(driver.findElement(By.cssSelector("#simpleList1 > li:nth-child(" + i + ")")));
        }

        WebElement grupaB = driver.findElement(By.id("simpleList2"));
        Actions action1 = new Actions(driver);

        for (WebElement elementZ1 : webElementsZadanie1) {
            action1.dragAndDrop(elementZ1, grupaB);
        }
        action1.perform();

        Assert.assertTrue(driver.findElement(By.id("alert1")).isDisplayed());


        //Zadanie 2
        List<WebElement> listOfAllWebElements = new ArrayList<WebElement>();
        for (int i = 5; i >= 1; i--) {
            listOfAllWebElements.add(driver.findElement(By.cssSelector("[data-order=\"" + i + "\"]")));
        }

        Actions actions = new Actions(driver);
        for (WebElement element : listOfAllWebElements) {
            Actions smoothMove = actions.clickAndHold(element);
            for (int e = 0; e < 10; e++) {
                smoothMove.moveByOffset(0, -30);
            }
            smoothMove.release().perform();
        }
        Assert.assertTrue(driver.findElement(By.id("alert2")).isDisplayed());


        //Zadanie 3
        WebElement element1X = driver.findElement(By.id("test1"));
        WebElement element2X = driver.findElement(By.id("test2"));
        WebElement grupaY = driver.findElement(By.id("simpleList5"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        File file = new File("src/test/resources/drag_and_drop_helper.js");

        String script = readFile(file.getAbsolutePath())
                +"\nsimulateHTML5DragAndDrop(arguments[0], arguments[1])";
        javascriptExecutor.executeScript(script, element1X, grupaY);
        javascriptExecutor.executeScript(script, element2X, grupaY);

        Assert.assertTrue(driver.findElement(By.id("alert3")).isDisplayed());
    }


    private static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }
}
