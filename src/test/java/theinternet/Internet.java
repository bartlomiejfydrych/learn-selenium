package theinternet;

import com.sun.xml.internal.bind.v2.TODO;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Internet {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/");
    }

    @Test
    public void abTesting(){
        driver.findElement(By.linkText("A/B Testing")).click();
        String isTextDisplayed = driver.findElement(By.cssSelector("div.example > p")).getText();
        Assert.assertEquals("Also known as split testing. This is a way in which businesses are able" +
                " to simultaneously test and learn different versions of a page to see which text and/or" +
                " functionality works best towards a desired outcome (e.g. a user action such as" +
                " a click-through).", isTextDisplayed);
    }

    @Test
    public void addRemoveElements(){
        driver.findElement(By.linkText("Add/Remove Elements")).click();
        driver.findElement(By.cssSelector("div.example > button")).click();
        WebElement buttonDelete = driver.findElement(By.cssSelector("div#elements > button"));
        boolean buttonDeleteDisplayed = buttonDelete.isDisplayed();
        Assert.assertTrue(buttonDeleteDisplayed);
        buttonDelete.click();
        Assert.assertFalse(driver.findElements(By.cssSelector("div#elements > button")).size() != 0);
    }

    @Test
    public void basicAuth(){
        driver.findElement(By.linkText("Basic Auth")).click();
        // http://username:password@adres.pl
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        String isTextDisplayed = driver.findElement(By.cssSelector("p")).getText();
        Assert.assertEquals("Congratulations! You must have the proper credentials.", isTextDisplayed);
    }

    @Test
    public void brokenImages(){
        driver.findElement(By.linkText("Broken Images")).click();
        List<WebElement> list = driver.findElements(By.tagName("img"));
        System.out.println("Total number of Images on page Broken Images:---->>"+ list.size());

        //TODO brak pomysłu na asercję

        for(WebElement ele : list){
            try {
                HttpURLConnection conn = (HttpURLConnection) new URL(ele.getAttribute("src")).openConnection();
                conn.setRequestMethod("GET");
                int responceCode = conn.getResponseCode();
                if(responceCode != 200){
                    System.out.println("Broken Image:---->>"+ele.getAttribute("src"));
                }
                else{
                    System.out.println("Fine Image:---->>"+ele.getAttribute("src"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
