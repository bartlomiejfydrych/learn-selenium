package testerczaki;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;


public class Tabele extends TestBase {

    @Test
    public void tabele() throws InterruptedException {
        driver.findElement(By.cssSelector("[href=\"/tabele\"]")).click();

        List<WebElement> rows = driver.findElements(By.cssSelector("#table1 tr"));

        int sum = 0;
        String wiekJanusza = "";
        String imieWarszawiaka = "";
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector("td"));
            WebElement imie = cells.get(0);
            WebElement wiek = cells.get(1);
            WebElement miasto = cells.get(2);
            sum += Integer.parseInt(wiek.getText());

            if (imie.getText().equals("Janusz")) wiekJanusza = wiek.getText();
            if (miasto.getText().equals("Warszawa")) imieWarszawiaka = imie.getText();
        }

        double srednia = (double)sum / (double)rows.size();
        driver.findElement(By.cssSelector("#avg")).sendKeys(Double.toString(srednia));
        driver.findElement(By.cssSelector("#age")).sendKeys(wiekJanusza);
        driver.findElement(By.cssSelector("#name")).sendKeys(imieWarszawiaka);

        driver.findElement(By.id("submit1")).click();
        Assert.assertTrue(driver.findElement(By.id("alert1")).isDisplayed());
    }
}
