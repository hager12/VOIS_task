package Scenario2;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ScenarioTC {
    @BeforeTest
    public  void BeforeTestCase () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Dimension Resolution = new Dimension(1024,768);
        driver.manage().window().setSize(Resolution);
//      driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void AddiItem2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com/");
        // click on dismiss
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[4]/div[1]/div/div/div[3]/span[1]/span/input")).click();
        //click on today's deals
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[4]/div[2]/div[2]/div/a[1]")).click();
        //select Headphones and grocery
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[20]/div/div/div/div[3]/div[2]/span[3]/ul/li[27]/label/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[20]/div/div/div/div[3]/div[2]/span[3]/ul/li[25]/label/input")).click();
        //choose discount 10% off or more
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[20]/div/div/div/div[3]/div[2]/span[6]/ul/li[2]/div/a/span")).click();
//       When I execute this task the today's deals was just 2 pages
        //go to page 2
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[20]/div/div/div/div[4]/div/ul/li[3]")).click();
        Thread.sleep(2000);
        //select the firsi item
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[20]/div/div/div/div[3]/div[3]/div/div[1]/div/div/a/div/div")).click();
        Thread.sleep(2000);
// add to cart
        driver.findElement(By.xpath("/html/body/div[1]/div/div[10]/div[5]/div[1]/div[6]/div/div[1]/div/div/div/form/div/div/div/div/div[4]/div/div[16]/div[1]/span/span/span/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[2]/div/div[1]/span/span/a")).click();
        driver.quit();

//        Select Departments = new Select(driver.findElement(By.xpath("")));
//        Departments.selectByValue("selenium");
//        Departments.selectByValue("cypress");

    }
}

