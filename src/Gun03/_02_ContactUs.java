package Gun03;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.tools.Tool;

public class _02_ContactUs extends BaseDriver {
 /*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra url deki success yazısını doğrulayınız.
 */
    @Test
    public void contactUs(){

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        Tools.Bekle(1);

        WebElement contactUs = driver.findElement(By.linkText("Contact Us"));
        contactUs.click();
        Tools.Bekle(1);

        WebElement enquiry = driver.findElement(By.id("input-enquiry"));
        enquiry.sendKeys("Bugün günlerden onbir mart");

        WebElement submit = driver.findElement(By.cssSelector("[type='submit']"));
        submit.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));




    }



}
