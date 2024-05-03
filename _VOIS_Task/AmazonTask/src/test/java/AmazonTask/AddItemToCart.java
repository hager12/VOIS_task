package AmazonTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddItemToCart {
    @BeforeTest
    public  void BeforeTest () throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        Dimension Resolution = new Dimension(1024,768);
        driver.manage().window().setSize(Resolution);
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @Test
    public void AddiItem() throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        driver.navigate().to("https://www.amazon.com/");
        //Select the first Item
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input")).sendKeys("car accessories");
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[3]/div/span/input")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div[1]/span/a/div/img")).click();
        //Add item to the cart
        driver.findElement(By.xpath("/html/body/div[1]/div/div[9]/div[5]/div[1]/div[6]/div/div[1]/div/div/div/form/div/div/div/div/div[4]/div/div[16]/div[1]/span/span/span/input")).click();
        Thread.sleep(5000);
        //Go to the cart
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[2]/div/div[1]/span/span/a")).click();
        //check that item is added successfully
        boolean ItemAdded= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/ul/div[2]/li[1]/span/span/message/primary")).isDisplayed();
        System.out.println("item is displayed " + ItemAdded);





        //    WebElement AddItem =driver.findElement(By.xpath("//*[@id=\"CardInstance0rYt9N6hzF9PV62CiaXgSg\"]/div[2]/div[1]/div[1]/a/div[1]/img"));
        //  String NewItem= AddItem.getText();
        //  System.out.println("NewItem is :"+NewItem);
//        Select courses = new Select(driver.findElement(By.id("courses")));
//        courses.selectByValue("selenium");


    }
}
