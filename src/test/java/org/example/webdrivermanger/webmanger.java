package org.example.webdrivermanger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class webmanger {
    @Test
    public void f(){
        WebDriverManager.chromedriver().setup();
        WebDriver  wahabDriver = new ChromeDriver();
        wahabDriver.get("https://employees.vmao.org/en");
        wahabDriver.manage().window().maximize();
    }
}
