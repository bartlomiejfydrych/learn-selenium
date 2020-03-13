package testerczaki;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;


public class Tabele extends TestBase {

    @Test
    public void tabele(){
        driver.findElement(By.cssSelector("[href=\"/tabele\"]")).click();

        // Pole 1
        List<String> stringsPole1 = new ArrayList<>();
        for (int i = 1; i <= 5; i++){
            stringsPole1.add(driver.findElement(By.xpath("//*[@id=\"table1\"]/tr[" + i + "]/td[2]")).getText());
        }
        List<Integer> intsPole1 = new ArrayList<>();
        for (String s : stringsPole1) intsPole1.add(Integer.valueOf(s));

        int total = 0;
        for (int i=0; i<intsPole1.size(); i++){
            total = total + intsPole1.get(i);
        }
        double srednia = (double)total / (double)intsPole1.size();

        String sSrednia = String.valueOf(srednia);

        driver.findElement(By.id("avg")).sendKeys(sSrednia);


        // Pole 2
        String wiekJanusza = driver.findElement(By.xpath("//td[text()='Janusz']/following-sibling::td[1]")).getText();
        driver.findElement(By.id("age")).sendKeys(wiekJanusza);


        // Pole 3
        String imieWarszawiaka = driver.findElement(By.xpath("//td[text()='Warszawa']/preceding-sibling::td[2]")).getText();
        driver.findElement(By.id("name")).sendKeys(imieWarszawiaka);


        // Zakonczenie
        driver.findElement(By.id("submit1")).click();
        Assert.assertTrue(driver.findElement(By.id("alert1")).isDisplayed());
    }
}
