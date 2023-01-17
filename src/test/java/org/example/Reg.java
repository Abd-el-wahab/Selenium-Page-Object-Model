package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Reg {


                                // Without Automation
//    WebDriver wahabDriver;
//    @Test
//    public void Reg(){
//        wahabDriver.findElement(By.name("LoginForm[email]")).sendKeys("automation@gmail.com");
//        wahabDriver.findElement(By.name("LoginForm[password]")).sendKeys("123456789");
//        // wahabDriver.findElement(By.xpath("//*[@id=\"login_form\"]/button")).click();
//
//        WebElement login_button = wahabDriver.findElement(By.xpath("//*[@id=\"login_form\"]/button"));
//        JavascriptExecutor java = (JavascriptExecutor)wahabDriver;
//        java.executeScript("scroll(0,250)");
//        login_button.click();
//
//        WebDriverWait wait = new WebDriverWait(wahabDriver , 5);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[3]/div[1]/div/div[1]/div[1]/h2")));
//        String welcoome_login = wahabDriver.findElement(By.xpath("/html/body/div[5]/div[3]/div[1]/div/div[1]/div[1]/h2")).getText();
//        Assert.assertEquals(welcoome_login, "Welcome mobile phone, Let's Start Learning!");
//    }
//
//
    WebDriver wahabDriver;
    @Test(dataProvider=("test_data"))
    public void Reg(String email,String password) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver  wahabDriver = new ChromeDriver();
        wahabDriver.get("https://employees.vmao.org/en");
        wahabDriver.manage().window().maximize();

        wahabDriver.findElement(By.linkText("Log In")).click();
        wahabDriver.findElement(By.name("LoginForm[email]")).sendKeys(email);
        wahabDriver.findElement(By.name("LoginForm[password]")).sendKeys(password);
        wahabDriver.findElement(By.xpath("//*[@id=\"login_form\"]/button")).click();

        wahabDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //Implicite Wait , Global , Dynamic

       // WebDriverWait wait = new WebDriverWait(wahabDriver , 50); // Explicit wait , Spacifiy one line or one call , Dynamic
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[3]/div[1]/div/div[1]/div[2]/h3")));

        //Thread.sleep(10000); //Thread Wait , Dupmt will wait all the Time added
        String welcoome_login = wahabDriver.findElement(By.xpath("/html/body/div[5]/div[3]/div[1]/div/div[1]/div[2]/h3")).getText();
        Assert.assertEquals(welcoome_login, "Live Activity Now");

     //   wahabDriver.findElement(By.xpath("//*[@id=\"register-form\"]/a")).click();
        wahabDriver.findElement(By.xpath("//*[@id=\"register-form\"]/a/span")).click();


   //     wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(" Log Out"))).click();
//        WebElement logout =  wahabDriver.findElement(By.xpath("//*[@id=\"register-form\"]/a"));
//        logout.click();
    }


//    @Parameters({"browser"})
//    @BeforeClass
//
//    public void openBrowser(@Optional String browser){
//        if (browser == null){
//            browser="chrome";
//        }
//
//        if (browser.equals("chrome")) {
//            System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
//            wahabDriver = new ChromeDriver();
//            wahabDriver.get("https://employees.vmao.org/en");
//            wahabDriver.manage().window().maximize();
//        }
//        if (browser.equals("firfox")){
//            System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
//            wahabDriver = new FirefoxDriver();
//            wahabDriver.get("https://employees.vmao.org/en");
//            wahabDriver.manage().window().maximize();
//        }
//    }

    /*
    @AfterClass
    public void closeBrowser(){

        wahabDriver.close();
*/
    @DataProvider
    public Object[][] test_data() throws IOException, InvalidFormatException {

        read_excel obj = new read_excel();
        return obj.read_data();
    }
}
