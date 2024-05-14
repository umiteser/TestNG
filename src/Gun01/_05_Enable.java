package Gun01;

import Utility.Tools;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class _05_Enable {
    @Test
    public void Test1()
    {
        System.out.println("Test 1");
        driver.get("https://techno.study/");
    }

    @Test
    public void Test2()
    {
        System.out.println("Test 2");
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void Test3()
    {
        System.out.println("Test 3");
        driver.get("https://www.google.com/");
    }

    public static ChromeDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void BaslangicIslemleri(){ // TearStart
        System.out.println("başlangıç işlemleri yapılıyor"); //driver oluşturma, wait işlemleri,

        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); //sayfayı yükleme mühleti
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // elementi bulma mühleti
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //driver.manage().window().maximize(); ekranı max yapıyor. tam ekran açılıyor.

    }

    @AfterClass
    public void KapanisIslemleri(){  // TearDown
        System.out.println("kapanış işlemleri yapılıyor"); //BekleKapat

        Tools.Bekle(2);
        driver.quit();
    }
}

