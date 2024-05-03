package Task2;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
public class Task2InSelenium {
    @BeforeTest
    public void BeforeTest() throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            Dimension Resolution = new Dimension(1024, 768);
            driver.manage().window().setSize(Resolution);
//          driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
           }
            @Test
        public void BookTicket() throws InterruptedException {
                WebDriver driver =new ChromeDriver();
                driver.navigate().to("https://ksrtc.in/oprs-web/guest/home.do?h=1");
                WebElement element = driver.findElement(By.xpath("//*[@id=\"mainSlider\"]/a[2]/span[1]"));
            scrollToElement(driver, element);

            driver.findElement(By.xpath("/html/body/main/section/div/div/div[1]/div/div/div/a[1]/span[1]")).click();
            driver.findElement(By.xpath("/html/body/main/section/div/div/div[1]/div/div/div/div[2]/div/div/ul/li[1]/a")).click();
            //click on Date Of Departure
            driver.findElement(By.id("txtJourneyDate")).click();
            //select the date 16
            driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[5]/a")).click();
            //remove the advertisment
            driver.findElement(By.xpath("//*[@id=\"corover-close-btn\"]")).click();
            driver.findElement(By.xpath("/html/body/main/form/div[1]/div/div[2]/div[3]/button")).click();
            Thread.sleep(10000);
            //select a seat
            driver.findElement(By.xpath("//*[@id=\"corover-close-btn\"]")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[1]/div[1]/div[3]/div/input[4]")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[1]/div/div[1]/div/div/div/ul[2]/li[4]/span")).click();
            Thread.sleep(2000);
            //select Dropping Point
            driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[2]/div/div[2]/ul/li[2]/a")).click();
            driver.findElement(By.xpath("//*[@id=\"Forward92\"]/span")).click();
//go to customer detail
            driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[2]/div/div[2]/ul/li[3]/a")).click();
            //fill mobile
            driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[2]/div/div[2]/div/div[3]/div[3]/div/div[1]/div[2]/div[1]/div/input")).sendKeys("6789125987");
            driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("ahmed@gmail.com");
            driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[3]/div/div/div/div/div[1]/div[1]/div[2]/div[1]/input")).sendKeys("Ahmed");
            driver.findElement(By.id("genderCodeIdForward0")).click();
            driver.findElement(By.xpath("//*[@id=\"genderCodeIdForward0\"]/option[2]")).click();
            driver.findElement(By.id("passengerAgeForward0")).sendKeys("20");
            //Select concessionId
            Select concessionId = new Select(driver.findElement(By.id("concessionIdsForward0")));
            concessionId.selectByVisibleText("GENERAL PUBLIC");
            //type name of female
            driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[3]/div/div/div/div/div[1]/div[2]/div[2]/div[1]/input")).sendKeys("Hager");
            //select Female
            driver.findElement(By.id("genderCodeIdForward1")).click();
            driver.findElement(By.xpath("//*[@id=\"genderCodeIdForward1\"]/option[3]")).click();
            driver.findElement(By.id("passengerAgeForward1")).sendKeys("15");
            Select concessionId2 = new Select(driver.findElement(By.id("concessionIdsForward1")));
            concessionId2.selectByVisibleText("GENERAL PUBLIC");
            String actualUrl = "https://ksrtc.in/oprs-web/avail/services.do";
            String expectedUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl, expectedUrl);
            driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[5]/div/div/div/div/div/div[2]/div[1]/input")).click();
            driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[5]/div/div/div/div/div/div[2]/div[3]/input")).click();
        }
    @Test
    public void invalidBookTicketTC() throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        driver.navigate().to("https://ksrtc.in/oprs-web/guest/home.do?h=1");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"mainSlider\"]/a[2]/span[1]"));
        scrollToElement(driver, element);

        driver.findElement(By.xpath("/html/body/main/section/div/div/div[1]/div/div/div/a[1]/span[1]")).click();
        driver.findElement(By.xpath("/html/body/main/section/div/div/div[1]/div/div/div/div[2]/div/div/ul/li[1]/a")).click();
        //click on Date Of Departure
        driver.findElement(By.id("txtJourneyDate")).click();
        //select the date 16
        driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[5]/a")).click();
        //remove the advertisement
        driver.findElement(By.xpath("//*[@id=\"corover-close-btn\"]")).click();
        //search for a bus
        driver.findElement(By.xpath("/html/body/main/form/div[1]/div/div[2]/div[3]/button")).click();
        Thread.sleep(10000);
        //select a seat
        driver.findElement(By.xpath("//*[@id=\"corover-close-btn\"]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[1]/div[1]/div[3]/div/input[4]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[1]/div/div[1]/div/div/div/ul[2]/li[4]/span")).click();
        Thread.sleep(2000);
        //select Dropping Point
        driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[2]/div/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"Forward92\"]/span")).click();
//go to customer detail
        driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[2]/div/div[2]/ul/li[3]/a")).click();
        //fill mobile
        driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[2]/div/div[2]/div/div[3]/div[3]/div/div[1]/div[2]/div[1]/div/input")).sendKeys("6789125987");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("ahmed@gmail.com");
        driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[3]/div/div/div/div/div[1]/div[1]/div[2]/div[1]/input")).sendKeys("Ahmed");
        driver.findElement(By.id("genderCodeIdForward0")).click();
        driver.findElement(By.xpath("//*[@id=\"genderCodeIdForward0\"]/option[2]")).click();
        driver.findElement(By.id("passengerAgeForward0")).sendKeys("4");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[5]/div/div/div/div/div/div[2]/div[3]/input")).click();
        driver.switchTo().alert().accept();
        driver.quit();
        System.out.println("Age Must BE Above 6 Years");
    }
        private static void scrollToElement (WebDriver driver, WebElement element){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        }
    }
