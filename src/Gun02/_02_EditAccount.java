package Gun02;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _02_EditAccount extends BaseDriver {

    /*
  Senaryo
  1- Siteyi açınız.
  2- Edit Account sayfasına ulaşınız.
  3- Ad ve soyadı değiştirip tekrar kaydedidiniz.
 */
@Test
public void EditAccount(){
    WebElement editLink = driver.findElement(By.linkText("Edit Account"));
    editLink.click();

    WebElement txtFirstName=driver.findElement(By.id("input-firstname"));
    txtFirstName.clear();
    txtFirstName.sendKeys("Umit");

    WebElement txtLastName= driver.findElement(By.id("input-lastname"));
    txtLastName.clear();
    txtLastName.sendKeys("Esser");

    WebElement btnSubmit=driver.findElement(By.xpath("//input[@type='submit']"));
    btnSubmit.click();

    Tools.SuccessMessageValidation();

}



}
